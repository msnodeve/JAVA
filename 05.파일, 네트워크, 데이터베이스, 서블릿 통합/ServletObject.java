import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/ServletObject")
public class ServletObject extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");

            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.177.129/web?user=mskim&password=1234&serverTimezone=UTC&useSSL=false");
            
            Statement statement = conn.createStatement();
            
			ResultSet result = statement.executeQuery("select * from address");

			ArrayList<Person> persons = new ArrayList<Person>();
			while(result.next()) {
                Person person = new Person();
				person.setData("hakbun",result.getString("hakbun"));
				person.setData("name",result.getString("name"));
				person.setData("age",result.getString("age"));
                person.setData("tel",result.getString("tel"));
                person.setData("jumin",result.getString("jumin"));
                person.setData("address",result.getString("address"));
				persons.add(person);
			}

			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			out.writeObject(persons);
			out.flush();
			conn.close();
		}catch(Exception e) {}
	}
}