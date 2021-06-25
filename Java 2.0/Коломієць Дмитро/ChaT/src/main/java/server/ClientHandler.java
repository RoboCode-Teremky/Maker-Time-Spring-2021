package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private Server server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private static final int PORT = 3443;
    private Socket clientSocket = null;
    private static int client_count = 0;
    private String clients_count;

    public ClientHandler(Socket socket, Server server) {
        try{
            client_count++;
            this.server = server;
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                server.sendMessageToAllClients("New client in chat");
                server.sendMessageToAllClients("Clients in chat = " + clients_count);

                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();
                    if (clientMessage.equalsIgnoreCase("##session##end##")) {
                        break;
                    }
                    System.out.println(clientMessage);
                    server.sendMessageToAllClients(clientMessage);
                }
                Thread.sleep(100);

            }
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally{
                this.close();
            }
        }


    public void sendMsg(String msg){
   try {
    outMessage.println(msg);
    outMessage.flush();
   }catch (Exception ex) {
       ex.printStackTrace();
        }
    }
    public void close(){
        server.removeClient(this);
        int clients_count = 0;
        clients_count--;
        
        server.sendMessageToAllClients("Clients in chat ="+ clients_count);
        
    }
} 