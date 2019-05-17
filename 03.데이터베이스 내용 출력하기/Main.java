import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// DataBase에 접속하여 간단하게 내부 내용을 출력하는 클래스
public class Main {
    public static void main(String[] args) throws Exception {
        // jdbc:mysql://[서버 주소]/[database 이름]?user=[db 유저이름]&password=[db 패스워드]&serverTimezone=UTC&useSSL=false
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.177.128/web2019?user=mskim&password=1234&serverTimezone=UTC&useSSL=false");
        Statement statement = conn.createStatement();
        // address 이름을 가진 테이블의 모든 내용을 들고오는 쿼리문
        ResultSet result = statement.executeQuery("select * from address");
        while (result.next()) {
            System.out.println("이름 : " + result.getString("name") + ", 나이 : " + result.getString("age") + ", 주소 : "
                    + result.getString("address"));
        }
        conn.close();
    }
}