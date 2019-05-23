import java.sql.*;
import java.util.*;
import java.net.*;
import java.io.*;


public class GetAddressFromServlet extends PersonManager {

	private String urlString;
	private String method;

	public GetAddressFromServlet(String urlString,String method, MyEventListener listener) throws Exception {
		super();
		this.urlString=urlString;
		this.method=method;
		this.listener=listener;
	}

	public void run() {
		try{
			ObjectInputStream in=null;
			URL url=null;
			if(method.equals("get") || method.equals("GET")) {
				url = new URL(urlString);
				in = new ObjectInputStream(url.openStream());
			}
			else if(method.equals("post") || method.equals("POST")) {
				String str[]=urlString.split("\\?");
				urlString=str[0];
				String queryString = str[1];
				url = new URL(urlString);
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");

				OutputStream out = connection.getOutputStream();
				out.write(queryString.getBytes("utf-8"));
				out.flush();
				in = new ObjectInputStream(connection.getInputStream());
			}
			ArrayList list = (ArrayList)in.readObject();
			setData(list);
			complete(this);
		}catch(Exception e) {System.out.println(e);}
	}
}

