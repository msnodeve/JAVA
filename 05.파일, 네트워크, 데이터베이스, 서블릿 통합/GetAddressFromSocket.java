import java.io.*;
import java.net.*;

public class GetAddressFromSocket extends PersonManager{
    private Socket socket;
    public GetAddressFromSocket(Socket socket, MyEventListener listener) throws Exception{
        super();
        this.socket = socket;
        this.listener = listener;
    }

    public void run(){
        try{
            InputStream in = socket.getInputStream();
            FileOutputStream out = new FileOutputStream("original_copy.txt");
            byte data[] = new byte[1024 * 8];
            int size;
            while ((size = in.read(data)) != -1) {
                out.write(data, 0, size);
            }
            out.close();
            socket.close();
            complete(this);
        }catch(Exception e) { }
    }
}