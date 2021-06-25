import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Socket_con extends WebSocketServer {
    List<WebSocket> connections = new ArrayList<>();
    List<User_info> clients = new ArrayList<>();
    private database db;

    //приєднання сокету до списку
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        connections.add(webSocket);
        System.out.println(webSocket.getRemoteSocketAddress().getAddress().getHostAddress() + " приєднується");
    }

    //від'єднання сокету зі списку
    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        connections.remove(webSocket);
        System.out.println(webSocket.getRemoteSocketAddress().getAddress().getHostAddress() + " від'єднується");
    }

    //перевірка авторизації
    @Override
    public void onMessage(WebSocket webSocket, String s) {
        JSONParser parser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String type = (String) object.get("type");
        String login = (String) object.get("login");
        String pass = (String) object.get("pass");
        if (type.equalsIgnoreCase("login")) {
            for (User_info userinfo : clients) {
                if (userinfo.getLogin().equals(login)) {
                    if (userinfo.getPass().equals(pass)) {
                        webSocket.send("Вхід до системи виконаний успішно");
                    } else {
                        webSocket.send("Паролі не співпадають! Спробуйте ще раз");
                    }
                } else {
                    webSocket.send("Такого користувача не існує");
                }

                //Реєстрація нових користувачів
                if (type.equalsIgnoreCase("login")) {
                    boolean nu = true;

                    for (User_info userInfo : clients) {
                        if (userinfo.getLogin().equals(login)) {
                            webSocket.send("Такий користувач вже існує");
                            nu = false;
                            break;
                        }
                    }
                    if (nu) {
                        User_info newUser = new User_info(login, pass);
                        clients.add(newUser);
                        try {
                            db.addNewUser(newUser, clients.size());
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        webSocket.send("Реєстрація завершена");
                    }

                }
            }

        }
    }


    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println(webSocket.getRemoteSocketAddress().getAddress().getHostAddress()+": "+e.getMessage());
    }

    //інформування про успішний запуск програми
    @Override
    public void onStart() {
        System.out.println("Сокет запущено");
    }

    public Socket_con(int port){
        super(new InetSocketAddress(port));
    }

    public static void main(String[] args) {
        Socket_con socket_con = new Socket_con(1234);
        socket_con.start();
    }
}


