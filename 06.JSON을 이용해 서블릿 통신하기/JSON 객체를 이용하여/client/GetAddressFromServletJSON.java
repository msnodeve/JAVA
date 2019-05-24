import java.sql.*;
import java.util.*;
import java.net.*;
import java.io.*;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

// PersonManager 자식 클래스
public class GetAddressFromServletJSON extends PersonManager{
    private String urlString;
    private Person person;

    // Client에서 넘겨받은 파라미터값으로 만든 생성자
    public GetAddressFromServletJSON(String urlString,Person person, MyEventListener listener) throws Exception {
		super();
		this.urlString=urlString;
		this.listener=listener;
		this.person=person;
    }
    // PersonManager가 Thread를 상속받았기 때문
    public void run() {
		try{
            //JSON 형태로 변환
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			JsonFactory factory = new JsonFactory();
			JsonGenerator generator = factory.createGenerator(connection.getOutputStream());

			generator.writeStartObject();
			String keys[]=person.getKeys();
			for(int i=0;i<keys.length;i++)
				generator.writeStringField(keys[i],person.getData(keys[i]));
			generator.writeEndObject();
			generator.close();

			ObjectMapper mapper = new ObjectMapper();
			JsonNode nodes = mapper.readTree(connection.getInputStream());
			System.out.println(nodes.size());
			ArrayList<Person> persons = new ArrayList<Person>();
			for(int i=0;i<nodes.size();i++) {
				JsonNode node = nodes.get(i);
				Iterator<String> fieldNames = node.fieldNames();
				Person person = new Person();
				while(fieldNames.hasNext()) {
					String fieldName = fieldNames.next();
					person.setData(fieldName,node.get(fieldName).asText());
				}
				persons.add(person);
			}
			setData(persons);
			complete(this);
		}catch(Exception e) {System.out.println(e);}
	}
}