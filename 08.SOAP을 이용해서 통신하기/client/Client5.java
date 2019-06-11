import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Client5{
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
		SOAPParser parser = new SOAPParser();
		parser.soapMessageParser(in);
        ArrayList<DataObject> list = parser.getData();
        for(int i = 0 ; i< list.size(); i++){
			System.out.println("이름 : " + list.get(i).getValue("name") + ",  나이 : " + list.get(i).getValue("age"));
		}
    }
}