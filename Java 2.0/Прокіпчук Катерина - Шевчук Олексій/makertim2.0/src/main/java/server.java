/*import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;



public class server extends WebSocketServer {
        List<User_info> clients = new ArrayList<>();
        database dt;
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
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
        System.out.println(object.get("login"));

        if (type.equalsIgnoreCase("reg")) {
            dt.addNewUser(login, pass);
        }

    }
            String sql = "INSERT INTO clientlist VALUES(" + login + ", " + pass + ");";
        } else {

            if (type.equalsIgnoreCase("log")) {
                for (User_info user : clients) {
                    if (user.getLogin().equals(login)) {
                        if (user.getPass().equals(pass)) {
                            webSocket.send("Вхід до системи виконаний успішно");
                        } else {
                            webSocket.send("Паролі не співпадають! Спробуйте ще раз");
                        }
                    } else {
                        webSocket.send("Такого користувача не існує");
                    }


                }

            }
        }

            @Override
            public void onError (WebSocket webSocket, Exception e){

            }

            @Override
            public void onStart () {
                System.out.println("Программа запущена");
            }

    }

*/