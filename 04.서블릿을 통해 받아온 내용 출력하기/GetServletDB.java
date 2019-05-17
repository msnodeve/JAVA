import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.util.*;

// 서버내에 존재하는 서블릿 클래스
@WebServlet("/GetServletDB")
public class GetServletDB extends HttpServlet{
    // Get 형식으로 HTTP 통신이 들어오게되면 아래 함수 실행
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
			response.setCharacterEncoding("utf-8");
            // 내부에서 디비 접속을 한 뒤 모든 데이터를 ArrayList에 담음
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.177.129/web?user=mskim&password=1234&serverTimezone=UTC&useSSL=false");
            Statement statement = conn.createStatement();
            // 쿼리문 실행
            ResultSet result = statement.executeQuery("select hakbun, name, age, tel, jumin, address from address");

            // ArrayList에 DB에서 받아온 값 저장
            ArrayList<Person> persons = new ArrayList<>();
            while(result.next()){
                Person person = new Person();
                person.setHakbun(result.getString(1));
                person.setName(result.getString(2));
                person.setAge(result.getInt(3));
                person.setTel(result.getString(4));
                person.setJumin(result.getString(5));
                person.setAddress(result.getString(6));
				persons.add(person);
            }

            // 객체 스트림을 통해 Array객체를 Client로 전송
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			out.writeObject(persons);
			out.flush();
        }catch(Exception e){

        }
    }
}