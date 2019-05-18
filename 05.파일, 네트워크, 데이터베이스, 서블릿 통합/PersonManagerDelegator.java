import java.util.*;
import java.net.*;
import java.sql.*;

// 여러 타입의 방식으로 들어올경우 각 타입에 맞게 수행하기 위한 클래스
public class PersonManagerDelegator{
    private PersonManager personManager;

    // ArrayList에 있는 내용을 들고오기 위한 생성자
    public PersonManagerDelegator(ArrayList<String> list, MyEventListener listener){
        //personManager = new GetAddressFromArrayList(list, listener);
    }
    // 파일에 있는 내용을 들고오기 위한 생성자
    public PersonManagerDelegator(String filename, MyEventListener listener) throws Exception{
        personManager = new GetAddressFromFile(filename, listener);
    }
    // 네트워크를 통해 내용 들고오기 위한 생성자
    public PersonManagerDelegator(Socket socket, MyEventListener listener) throws Exception {
		//personManager = new GetAddressFromSocket(socket,listener);
    }
    // 데이터베이스를 직접 연결해서 내용 들고오기 위한 생성자
	public PersonManagerDelegator(Connection conn, MyEventListener listener) throws Exception {
		//personManager = new GetAddressFromDB(conn,listener);
	}
    // 서블릿을 통해 내용 들고오기 위한 생성자
	public PersonManagerDelegator(URL url, MyEventListener listener) throws Exception {
		//personManager = new GetAddressFromServlet(url,listener);
    }
    public void start(){
        try{
            personManager.start();
        }catch(Exception e){ }
    }
}