import java.net.*;

public class Server{
    public static void main(String[] agrs) throws Exception{
        ServerSocket serverSocket = new ServerSocket(1000);
        while(true){
            // 클라이언트를 계속 기다리며 accept가 되었을때 쓰레드를 실행
            Socket socket = serverSocket.accept();
            ServerThread thread = new ServerThread(socket);
            thread.start();
        }
    }
}