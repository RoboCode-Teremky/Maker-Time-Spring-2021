import org.java_websocket.WebSocket;
        import org.java_websocket.handshake.ClientHandshake;
        import org.java_websocket.server.WebSocketServer;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;
        import org.json.simple.parser.ParseException;

import java.net.InetSocketAddress;
import java.util.ArrayList;
        import java.util.List;
        import java.sql.*;


public class Socket_con extends WebSocketServer {
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
        String button = (String) object.get("button");

        if (button.equalsIgnoreCase("reg")) {
            if(dt.addNewUser(login, pass) == true){
            dt.addNewUser(login, pass);}
            else{
                webSocket.send("error1");
            }
        }
        else{
            if(button.equalsIgnoreCase("log")){
                if(dt.LoginUser(login, pass) == true){
                    webSocket.send("ok");
                }
                else{
                    webSocket.send("erorr");
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
    public Socket_con(int port){ super(new InetSocketAddress(port));}
    public static void main(String[] args) {
        Socket_con socket_con = new Socket_con(1234);
        socket_con.start();
    }
}
