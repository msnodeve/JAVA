import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// Person에서 넘겨준 Data를 Manager에서 Thread를 돌려 객체하나를 Map에저장
public class PersonManager extends Thread{
    protected HashMap<String, Person> maps;
	protected MyEventListener listener;

    public PersonManager(){
        maps = new HashMap<>();
    }

	public void setData(ArrayList list) {
		for(int i=0;i<list.size();i++) {
			Person person = (Person)list.get(i);
			maps.put(person.getData("name"),person);
		}
	}

	public Person getPerson(String key) {
		return maps.get(key);
	}

	public String[] getKeys() {
		Set<String> keySet = maps.keySet();
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