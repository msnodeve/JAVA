import java.net.*;
import java.io.*;
import java.util.*;

//URL을 통해서 Servlet HTTP 통신을 하는 클래스
public class Client{
    public static void main(String[] args) throws Exception{
        // Tomcat의 GetServletDB 별명을 가진 클래스를 실행
        URL url = new URL("http://192.168.177.129/GetServletDB");
        // Servlet에서 보내준 Stream을 객체로 받아 출력하기 위함
        ObjectInputStream in = new ObjectInputStream(url.openStream());
        ArrayList persons = (ArrayList)in.readObject();

        // 받은 데이터 모두 출력
        for (int i = 0; i < persons.size(); i++) {
            Person person = (Person) persons.get(i);
            System.out.println("학번 : " + person.getHakbun() + ", 이름 : " + person.getName() + ", 나이 : " + person.getAge()
                    + ", 전화번호 : " + person.getTel() + ", 주민등록번호 : " + person.getJumin() + ", 주소 : "
                    + person.getAddress());
        }
        
    }
}