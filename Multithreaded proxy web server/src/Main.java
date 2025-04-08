import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int port = 8080;
       try{
           ServerSocket serverSocket = new ServerSocket(port);
           while(true){
               Socket socket  = serverSocket.accept();
                new ClientHandler(socket).start();
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }

    }
}