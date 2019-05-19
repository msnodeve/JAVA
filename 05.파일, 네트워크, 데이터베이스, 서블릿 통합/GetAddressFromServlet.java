import java.io.ObjectInputStream;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class GetAddressFromServlet extends PersonManager{
    private URL url;

    public GetAddressFromServlet(URL url, MyEventListener listener) throws Exception{
        super();
        this.url = url;
        this.listener = listener;
    }

    public void run(){
        try{
            ObjectInputStream in = new ObjectInputStream(url.openStream());
            ArrayList persons = (ArrayList)in.readObject();
            for (int i = 0 ; i<persons.size();i ++){
                Person person = (Person)persons.get(i);
                maps.put(person.getData("name"), person);
            }
            complete(new ArrayList(maps.values()));
        }catch(Exception e) { }
    }
}