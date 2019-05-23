import java.util.*;
import java.net.*;
import java.sql.*;


public class PersonManagerDelegator {

	private PersonManager personManager;
	private MyEventListener listener;


	public PersonManagerDelegator(ArrayList<String> list, MyEventListener listener) {
		//personManager = new GetAddressFromArrayList(list, listener);
	}

	public PersonManagerDelegator(String filename, MyEventListener listener) throws Exception {
		personManager = new GetAddressFromFile(filename,listener);
	}

	public PersonManagerDelegator(Socket socket, MyEventListener listener) throws Exception {
		//personManager = new GetAddressFromSocket(socket,listener);
	}

	public PersonManagerDelegator(Connection connection, MyEventListener listener) throws Exception {
		personManager = new GetAddressFromDB(connection,listener);
	}

	public PersonManagerDelegator(String urlString, String method, MyEventListener listener) throws Exception {
		personManager = new GetAddressFromServlet(urlString,method,listener);
	}

	public PersonManagerDelegator(String urlString, Person person, MyEventListener listener) throws Exception {
		personManager = new PutAddressToServlet(urlString,person,listener);
	}

	public void start() {
		try{
			personManager.start();
		}catch(Exception e){}
	}
}





