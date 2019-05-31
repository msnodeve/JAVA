import java.net.*;
import java.io.*;

public class Client {

	public static void main(String args[]) throws Exception {

		URL url = new URL("http://192.168.177.129/hello/HelloWorld");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type","text/xml; charset=\"utf-8\"");

		String message = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hello=\"http://webservice.class.gmail.com\">";
		message=message+"<soapenv:Header/>";
		message=message+"<soapenv:Body>";
		message=message+"<hello:sayHello>";
		message=message+"<arg0>mskim</arg0>";
		message=message+"</hello:sayHello>";
		message=message+"</soapenv:Body>";
		message=message+"</soapenv:Envelope>";

		OutputStream out = connection.getOutputStream();
		out.write(message.getBytes("utf-8"));
		out.flush();

		InputStream in = connection.getInputStream();
		byte data[] = new byte[1024];
		int size;

		while((size=in.read(data))!=-1) {
			System.out.println(new String(data,0,size,"utf-8"));
		}
	}
}