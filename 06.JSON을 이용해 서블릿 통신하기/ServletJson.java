import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.*;
import java.io.*;
import java.sql.*;
import java.util.*;

// 서버내에 존재하는 서블릿 클래스
@WebServlet("/ServletJson")
public class ServletJson extends HttpServlet{
    // Get 형식으로 HTTP 통신이 들어오게되면 아래 함수 실행
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            // JSON 파일을 만들어주기 위함
            ObjectMapper mapper = new ObjectMapper();

            // Client에서 받은 값 Map에 넣음
            ObjectInputStream in = new ObjectInputStream(request.getInputStream());
            Map<String, Object> map = (Map<String, Object>)in.readObject();
            
            // 내부에서 디비 접속
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.177.129/web?user=mskim&password=1234&serverTimezone=UTC&useSSL=false");
            Statement statement = conn.createStatement();
            // 쿼리문 실행
            statement.execute("insert into address(hakbun, name, age, tel, jumin, address) values('"+map.get("hakbun")+"', '"+map.get("name")+"', "+map.get("age")+", '"+map.get("tel")+"', '"+map.get("jumin")+"', '"+map.get("address")+"')");

            ResultSet result = statement.executeQuery("select hakbun, name, age, tel, jumin, address from address");
            // ArrayList에 DB에서 받아온 데이터 값 JSON 파일로 만들어서 저장
            ArrayList<String> persons = new ArrayList<>();
            while(result.next()){
                Person person = new Person();
                person.setHakbun(result.getString(1));
                person.setName(result.getString(2));
                person.setAge(result.getInt(3));
                person.setTel(result.getString(4));
                person.setJumin(result.getString(5));
                person.setAddress(result.getString(6));
                String json = mapper.writeValueAsString(person);
                persons.add(json);
            }            
            // 객체 스트림을 통해 Array객체를 Client로 전송
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			out.writeObject(persons);
			out.flush();
        }catch(Exception e){

        }
    }
}