import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 8080;
        String host = "localhost";
        InetAddress address = InetAddress.getByName(host);
        Socket socket = new Socket(address,port);
        PrintWriter toServer = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toServer.println("Client says Jai Mata di");
        toServer.flush();
        String line = fromServer.readLine();
        System.out.println("Server received: " + line);
        fromServer.close();
        socket.close();

    }
}
