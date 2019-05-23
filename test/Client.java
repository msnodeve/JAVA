import java.net.*;
import java.util.*;
import java.sql.*;

public class Client implements MyEventListener {

	public static void main(String args[]) throws Exception {

		Client client = new Client();

/*
		Connection  connection = DriverManager.getConnection("jdbc:mysql://projectce.silla.ac.kr/twkimdb?user=twkim&password=rlaxodnd&serverTimezone=UTC&useSSL=false");
		PersonManagerDelegator delegator = new PersonManagerDelegator(connection,client);
		delegator.start();
*/
		Person person = new Person();
		person.setData("hakbun","88215041");
		person.setData("name","????");
		person.setData("age","12");
		person.setData("tel","051-999-1234");
		person.setData("jumin","690930-1357900");
		person.setData("address","???");


		PersonManager manager = new GetAddressFromServletJSON("http://localhost:1000/AddressServletJSON",person,client);
		manager.start();
		//PersonManagerDelegator delegator2 = new PersonManagerDelegator("http://61.100.231.210/test/PutAddressServlet",person,client);
		//delegator2.start();

/*
		PersonManagerDelegator delegator2 = new PersonManagerDelegator("address.txt",client);


		PersonManager manager = new GetAddressFromDB(connection,client);


		delegator.start();
		delegator2.start();
		manager.start();

		System.out.println("main complete....");

		PersonManagerDelegator delegator3 = new PersonManagerDelegator("address.txt",client);
		delegator3.start();
*/

	}

	public void complete(String message) {
		System.out.println(message);
	}

	public void complete(Object object) {
		PersonManager manager = (PersonManager)object;
		System.out.println(manager.getKeys().length);
		
		String keys[] = manager.getKeys();
		for(int i=0;i<keys.length;i++)
			System.out.println(manager.getPerson(keys[i]).getData("name"));
	}
}
