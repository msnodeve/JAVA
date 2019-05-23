import java.sql.*;
import java.util.*;

public class GetAddressFromDB extends PersonManager {

	private Connection connection;

	public GetAddressFromDB(Connection connection,MyEventListener listener) throws Exception {
		super();
		this.connection=connection;
		this.listener=listener;
	}

	public void run() {
		try{
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select hakbun,name,age,tel,jumin,address from address");

			while(result.next()) {
				Person person = new Person();
				person.setData("hakbun",result.getString(1));
				person.setData("name",result.getString(2));
				person.setData("age",result.getString(3));
				person.setData("tel",result.getString(4));
				person.setData("jumin",result.getString(5));
				person.setData("address",result.getString(6));
				address.put(result.getString(2),person);
			}
			complete(this);
		}catch(Exception e) {}
	}
}

