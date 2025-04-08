import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("SERVER WELCOMES YOUR NAME");
            String message;
            while((message = in.readLine()) != null){
                System.out.println("message received: " + message);
                out.println(message);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
