import java.net.*;
import java.io.*;

public class Client4{
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://192.168.177.129/server/Server");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","text/xml; charset=\"utf-8\"");

        SOAPMaker maker = new SOAPMaker();
        maker.setServiceNamespace("http://server.class.com");
        maker.setOperationName("getDBPerson");
        String msg = maker.getRequestMessage();
        System.out.println(msg);

        OutputStream out = connection.getOutputStream();
		out.write(msg.getBytes("utf-8"));
		out.flush();

		InputStream in = connection.getInputStream();
		byte data[] = new byte[1024];
		int size;

		while((size=in.read(data))!=-1) {
			System.out.println(new String(data,0,size,"utf-8"));
		}
    }
}