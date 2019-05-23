import java.sql.*;
import java.util.*;
import java.net.*;
import java.io.*;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;



public class GetAddressFromServletJSON extends PersonManager {

	private String urlString;
	private Person person;

	public GetAddressFromServletJSON(String urlString,Person person, MyEventListener listener) throws Exception {
		super();
		this.urlString=urlString;
		this.listener=listener;
		this.person=person;
	}

	public void run() {
		try{
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
					System.out.println(fieldName+"="+node.get(fieldName).asText());
					person.setData(fieldName,node.get(fieldName).asText());
				}
				persons.add(person);
			}
			setData(persons);
			complete(this);
		}catch(Exception e) {System.out.println(e);}
	}
}

