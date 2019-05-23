import java.sql.*;
import java.util.*;
import java.net.*;
import java.io.*;


public class PutAddressToServlet extends PersonManager {

	private String urlString;
	private Person person;

	public PutAddressToServlet(String urlString,Person person, MyEventListener listener) throws Exception {
		super();
		this.urlString=urlString;
		this.listener=listener;
		this.person=person;
	}

	public void run() {
		try{
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
			out.writeObject(person);
			out.flush();

			InputStream in = connection.getInputStream();
			byte data[] = new byte[1024];
			int size;
			StringBuilder str = new StringBuilder();

			while((size=in.read(data))!=-1)
				str=str.append(new String(data,0,size,"utf-8"));

			complete(str.toString());
		}catch(Exception e) {System.out.println(e);}
	}
}

