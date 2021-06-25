import org.java_websocket.WebSocket;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.handshake.ClientHandshake;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyWebSocket extends WebSocketServer {
    List<WebSocket> connections = new ArrayList<>();
    List<User> clients = new ArrayList<>();
    private DataBase db;


    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        connections.add(webSocket);
        System.out.println(webSocket.getRemoteSocketAddress().getAddress().getHostAddress() + " connected");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        connections.remove(webSocket);
        System.out.println(webSocket.getRemoteSocketAddress().getAddress().getHostAddress() + " disconnected");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        JSONParser parser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(s);
            String type = (String) object.get("type");
            String name = (String) object.get("name");
            String pass = (String) object.get("pass");

            System.out.println(type + ", " + name + "," + pass);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println(webSocket.getRemoteSocketAddress().getAddress().getHostAddress() + ": " + e.getMessage());
    }

    @Override
    public void onStart() {
        System.out.println("Socket start!");
    }

    //open port
    public MyWebSocket(int port) {
        super(new InetSocketAddress(port));

        //connect to database
        try {
            db = new DataBase();
            clients = db.getAllUsers();
            for (User usr : clients) {
                System.out.println(usr.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyWebSocket myWebSocket = new MyWebSocket(5555);
        myWebSocket.start();
    }
}
