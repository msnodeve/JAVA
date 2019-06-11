import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Client6 implements MyEventListener{
    public static void main(String[] args) throws Exception{

        Client6 client = new Client6();

        URL url = new URL("http://192.168.177.129/server/Server");
        SOAPManager soapManager = new SOAPManager(client, url);
        soapManager.start();
    }

    @Override
    public void complete(ArrayList<DataObject> list, String threadName) {
        for(int i = 0 ; i< list.size(); i++){
			System.out.println("이름 : " + list.get(i).getValue("name") + ",  나이 : " + list.get(i).getValue("age"));
		}
    }
}