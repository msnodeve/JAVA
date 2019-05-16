import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private MyEventListener listener;

    public ClientThread(Socket socket, MyEventListener listener) {
        this.socket = socket;
        this.listener = listener;
    }

    public void run() {
        try {
            InputStream in = socket.getInputStream();
            FileOutputStream out = new FileOutputStream("original_copy.txt");
            byte data[] = new byte[1024 * 8];
            int size;
            while ((size = in.read(data)) != -1) {
                out.write(data, 0, size);
            }
            out.close();
            socket.close();
            listener.complete(size);
        } catch (Exception e) {
        }
    }
}