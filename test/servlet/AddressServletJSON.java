import java.io.*;
import java.sql.*;
import java.util.*;
import java.net.URLDecoder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


@WebServlet("/AddressServletJSON")
public class AddressServletJSON extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try{
			ObjectMapper mapper = new ObjectMapper();
			Person2 person = mapper.readValue(request.getInputStream(),Person2.class);
			ArrayList<Person2> persons = new ArrayList<Person2>();
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.177.129/web?user=mskim&password=1234&serverTimezone=UTC&useSSL=false");
			Statement statement = connection.createStatement();
			System.out.println(person.hakbun + " " +person.name + " " +person.age + " " +person.tel + " " +person.jumin + " " +person.address + " ");
			String query="insert into address(hakbun,name,age,tel,jumin,address) values('";
			query=query+person.hakbun+"','";
			query=query+person.name+"',";
			query=query+person.age+",'";
			query=query+person.tel+"','";
			query=query+person.jumin+"','";
			query=query+person.address+"')";

			statement.execute(query);

			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select hakbun, name, age, tel, jumin, address from address");
            // ArrayList에 DB에서 받아온 데이터 값 JSON 파일로 만들어서 저장
            ArrayList<Person2> personss = new ArrayList<>();
            while(result.next()){
				Person2 dbPerson = new Person2();
				System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getInt(3) + " "+ result.getString(4) + " "+ result.getString(5) + " "+ result.getString(6) + " ");
				dbPerson.hakbun=result.getString(1);
				dbPerson.name=result.getString(2);
				dbPerson.age=result.getInt(3);
				dbPerson.tel=result.getString(4);
				dbPerson.jumin=result.getString(5);
				dbPerson.address=result.getString(6);				
				personss.add(dbPerson);
			}
			mapper.writeValue(response.getOutputStream(),(ArrayList)personss);

			connection.close();
		}catch(Exception e) {}
	}

	private void action(HttpServletRequest reauest, HttpServletResponse response, Person2 person) {
		
	}
}