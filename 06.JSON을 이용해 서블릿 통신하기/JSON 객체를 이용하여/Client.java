import java.net.*;
import java.util.*;
import java.sql.*;

public class Client implements MyEventListener {

	public static void main(String args[]) throws Exception {

		Client client = new Client();

		// Server에 전송할 Person 객체를 생성
		Person person = new Person();
		person.setData("hakbun", "88215041");
		person.setData("name", "Seok");
		person.setData("age", "25");
		person.setData("tel", "051-999-1234");
		person.setData("jumin", "690930-1357900");
		person.setData("address", "NY");

		PersonManager manager = new GetAddressFromServletJSON("http://192.168.177.129/AddressServletJSON", person, client);
		manager.start();
	}

	public void complete(String message) {
		System.out.println(message);
	}

	public void complete(Object object) {
		PersonManager manager = (PersonManager)object;
		System.out.println("complete");
		System.out.println(manager.getKeys().length);
		
		// 받은 데이터 모두 출력
		String keys[] = manager.getKeys();
		for(int i=0;i<keys.length;i++){
			System.out.println("학번 : " + manager.getPerson(keys[i]).getData("hakbun") + ", 이름 : " + manager.getPerson(keys[i]).getData("name")
				+ ", 나이 : " + manager.getPerson(keys[i]).getData("age") + ", 전화번호 : " + manager.getPerson(keys[i]).getData("tel")
				+ ", 주민등록번호 : " + manager.getPerson(keys[i]).getData("jumin") + ", 주소 : " + manager.getPerson(keys[i]).getData("address"));
		}
	}
}
