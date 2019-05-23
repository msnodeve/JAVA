import java.util.*;
import java.io.*;
import java.net.*;

public class PersonManager extends Thread {

	protected HashMap<String,Person> address;
	protected MyEventListener listener;

	public PersonManager() {
		address = new HashMap<String,Person>();
	}

	public void setData(ArrayList list) {
		for(int i=0;i<list.size();i++) {
			Person person = (Person)list.get(i);
			address.put(person.getData("name"),person);
		}
	}

	public Person getPerson(String key) {
		return address.get(key);
	}

	public String[] getKeys() {
		Set<String> keySet = address.keySet();
		String keys[] = (String [])keySet.toArray(new String[0]);

		return keys;
	}

	protected void complete(PersonManager manager) {
		listener.complete(manager);
	}

	protected void complete(String message) {
		listener.complete(message);
	}
}





