import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.Socket;

//여러 클라이언트가 들어왔을 때를 지연을 방지하기 위함
public class ServerThread extends Thread{
    private Socket socket;
    //쓰레드가 실행 되었을 때 해당 클라이언트의 IP 주소를 출력
    public ServerThread(Socket socket){
        this.socket = socket;
        System.out.println(socket.getInetAddress().toString());
    }
    public void run() {
        try{
            FileInputStream in = new FileInputStream("original.txt");
            PrintStream out = new PrintStream(socket.getOutputStream());

            byte data[] = new byte[1024*8];
            int size;
            while((size=in.read(data))!=-1){
                out.write(data,0,size);
            }
            System.out.println(socket.getInputStream().toString()+" Complete...");
            socket.close();
        }catch(Exception e){}
    }
}