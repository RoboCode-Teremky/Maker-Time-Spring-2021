import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public client(String address, int port) {
        try {
            this.socket = new Socket(address, port);
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            (new Thread(this::readReg)).start();
        } catch (UnknownHostException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }
    private void readReg() {
        while(true) {
            try {
                String message = this.in.readLine();
                System.out.println("Server: " + message);
                if (!message.equals("quit")) {
                    continue;
                }
            } catch (IOException var2) {
                var2.printStackTrace();
            }

            return;
        }
    }
}

