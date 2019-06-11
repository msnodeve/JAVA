import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class SOAPManager extends Thread {
    private MyEventListener listener;
    private URL url;

    public SOAPManager(MyEventListener listener, URL url) {
        this.listener = listener;
        this.url = url;
    }

    @Override
    public void run() {
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/xml; charset=\"utf-8\"");

            SOAPMaker maker = new SOAPMaker();
            maker.setServiceNamespace("http://server.class.com");
            maker.setOperationName("getDBPerson");
            String msg = maker.getRequestMessage();
            OutputStream out = conn.getOutputStream();
            out.write(msg.getBytes("utf-8"));
            out.flush();

            InputStream in = conn.getInputStream();
            SOAPParser parser = new SOAPParser();
            parser.soapMessageParser(in);
            listener.complete(parser.getData(), "threadName");
            System.out.println("쓰레드 끝");
        } catch (Exception e) {

        }
    }
}