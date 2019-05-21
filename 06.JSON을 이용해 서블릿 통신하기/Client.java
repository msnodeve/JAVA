import java.net.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

//URL을 통해서 Servlet HTTP JSON통신을 하는 클래스
public class Client{
    public static void main(String[] args) throws Exception{
        // Tomcat의 ServletJson 별명을 가진 클래스를 실행
        URL url= new URL("http://192.168.177.129/ServletJson");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
        connection.setRequestMethod("POST");

        // JSON 형태로 객체를 보낼 준비
        ObjectMapper mapper = new ObjectMapper();
        ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
        String value="{\"name\":\"이모텝\", \"hakbun\":\"201431001\", \"age\":24, \"tel\":\"010-9295-3179\", \"jumin\":\"950430-1197430\", \"address\":\"부산시\"}";
        Map<String, Object> map = mapper.readValue(value, new TypeReference<Map<String, Object>>(){});
        // JSON 객체를 서버에 전달
        out.writeObject(map);
        out.flush();

        // Servlet에서 보내준 Stream을 객체로 받아 출력하기 위함
        ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
		ArrayList persons = (ArrayList)in.readObject();

        // 받은 데이터 모두 출력
		for(int i=0;i<persons.size();i++) {
            String person = (String)persons.get(i);
            map = mapper.readValue(person, new TypeReference<Map<String, Object>>(){});
            System.out.println("학번 : " + map.get("hakbun") + ", 이름 : " + map.get("name") + ", 나이 : " + map.get("age")
            + ", 전화번호 : " + map.get("tel") + ", 주민등록번호 : " + map.get("jumin") + ", 주소 : "
            + map.get("address"));
		}
    }
}