import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/AddressServletJSON")
public class AddressServletJSON extends HttpServlet{
    public doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("Servlet doPost Function Start");
        try{
            // Client에서 받은 JSON 형태를 Person 객체에 맞게 Mapping하여 List에 저장
            ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(request.getInputStream(), Person.class);
            System.out.println(person.hakbun + " " +person.name + " " +person.age + " " +person.tel + " " +person.jumin + " " +person.address + " ");

            // Database 연결 및 입력
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.177.129/web?user=mskim&password=1234&serverTimezone=UTC&useSSL=false");
            Statement state = conn.createStatement();
            String query = "insert into address(hakbun, name, age, tel, jumin, address) values('" + person.hakbun + "', '" + person.name + "', " + person.age + ", '" + person.tel + "' , '" + person.jumin + "' , '" + person.address + "')";
            state.execute(query);

            // Database 내의 데이터 읽어오기
            state = connection.createStatement();
            ResultSet result = statement.executeQuery("select hakbun, name, age, tel, jumin, address from address");

            // ArrayList에 DB에서 받아온 데이터 값 JSON 파일로 만들어서 저장
            ArrayList<Person> persons = new ArrayList<>();
            while(result.next()){
				Person p = new Person2();
				p.hakbun=result.getString(1);
				p.name=result.getString(2);
				p.age=result.getInt(3);
				p.tel=result.getString(4);
				p.jumin=result.getString(5);
				p.address=result.getString(6);				
				persons.add(p);
            }
            mapper.writeValue(response.getOutputStream(),(ArrayList)persons);
            conn.close();
        }catch(Exception e){ }

    }
}