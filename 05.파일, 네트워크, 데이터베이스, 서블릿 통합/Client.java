import java.net.*;
import java.util.*;
import java.sql.*;

public class Client implements MyEventListener{
    public static void main(String[] args) throws Exception{
        Client client = new Client();

        // 1. 파일
        // PersonManagerDelegator fileDelegator = new PersonManagerDelegator("address.txt",client);
        // fileDelegator.start();

        // 2. 네트워크
        // Socket socket = new Socket("localhost", 1000);
        // PersonManagerDelegator socketDelegator = new PersonManagerDelegator(socket, client);
        // socketDelegator.start();

        // 3. 데이터베이스
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.177.129/web?user=mskim&password=1234&serverTimezone=UTC&useSSL=false");
        PersonManagerDelegator dbDelegator = new PersonManagerDelegator(conn, client);
        dbDelegator.start();

        // 4. 서블릿

    }
    public void complete(ArrayList<Person> list,String threadName) {
		System.out.println("Thread 이름 : " + threadName + " complete");
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).getData("name"));
	}

	public void complete(Object object,String threadName) {
		System.out.println("Thread 이름 : " + threadName + " complete");
		PersonManager manager = (PersonManager)object;
		System.out.println(manager.getKeys().length);

		String keys[] = manager.getKeys();
        for(int i=0;i<keys.length;i++)
            System.out.println("학번 : " + manager.getPerson(keys[i]).getData("hakbun") + ", 전화번호 : " + manager.getPerson(keys[i]).getData("tel")
            + ", 주민등록번호 : " + manager.getPerson(keys[i]).getData("jumin") + ", 주소 : " + manager.getPerson(keys[i]).getData("address")
            + ", 이름 : " + manager.getPerson(keys[i]).getData("name"));
	}
}