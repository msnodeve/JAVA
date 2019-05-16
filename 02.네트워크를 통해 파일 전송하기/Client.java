import java.io.BufferedReader;
import java.net.Socket;

// 파일을 다 받았으면 받았다는 것을 표시하기 위해 Listener를 상속받음
public class Client implements MyEventListener {
    public static void main(String[] agrs) throws Exception {
        Socket socket = new Socket("localhost", 1000);
        // new Client(this) 객체를 넘겨주게되면 ClientThread에서 Client에 있는 함수를 호출 할 수있음
        ClientThread thread = new ClientThread(socket, new Client());
        thread.start();
        // 쓰레드를 사용해서 클라이언트의 다른 코드를 수행 가능함
    }

    // 파일을 다 받았다면 싸이즈를 출력하여 받은 것을 표시
    @Override
    public void complete(long size) {
        System.out.println("서버로 부터 받은 파일의 크기 : " + size);
    }
}