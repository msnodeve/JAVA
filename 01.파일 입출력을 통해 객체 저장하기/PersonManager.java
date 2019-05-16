import java.io.*;
import java.util.*;

// PersonManager 클래스는 Main으로 받은 filename을 알아서 읽어와 Person객체를 만들기 위해 Person에게 넘겨줌
public class PersonManager {
    private HashMap<String, Person> datas;

    public PersonManager(String filename) throws Exception {
        datas = new HashMap<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String str = "";
        while ((str = in.readLine()) != null) {
            Person person = new Person(str);
            datas.put(person.getValue("name"), person);
        }
    }

    public Person getPerson(String key){
        return datas.get(key);
    }
    public Person[] getPersons(){
        Collection<Person> persons = datas.values();
        return (Person []) persons.toArray(new Person[0]);
    }
    public String[] getKeys(){
        Set<String> keys = datas.keySet();
        return (String[])keys.toArray(new String[0]);
    }
}