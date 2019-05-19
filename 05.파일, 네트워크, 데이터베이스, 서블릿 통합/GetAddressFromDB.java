import java.sql.*;
import java.util.*;

public class GetAddressFromDB extends PersonManager{
    private Connection conn;
    public GetAddressFromDB(Connection conn, MyEventListener listener) throws Exception{
        super();
        this.conn = conn;
        this.listener = listener;
    }

    public void run(){
        try{
            Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from address");

			while(result.next()) {
				Person person = new Person();
				person.setData("hakbun",result.getString("hakbun"));
				person.setData("name",result.getString("name"));
				person.setData("age",result.getString("age"));
                person.setData("tel",result.getString("tel"));
                person.setData("jumin",result.getString("jumin"));
                person.setData("address",result.getString("address"));
				maps.put(result.getString("name"),person);
			}
			complete(new ArrayList(maps.values()));
        }catch(Exception e) { }
    }
}