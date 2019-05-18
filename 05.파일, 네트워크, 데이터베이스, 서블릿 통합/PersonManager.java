import java.util.*;
import java.io.*;
import java.net.*;

// Person 객체를 관리해주며 객체를 생성할때 Thread를 통해 저장
public class PersonManager extends Thread{
    protected HashMap<String, Person> maps;
    protected MyEventListener listener;

    public PersonManager(){
        maps = new HashMap<>();
    }

    public Person getPerson(String key){
        return maps.get(key);
    }

    public String[] getKeys(){
        Set<String> keySet = maps.keySet();
        String keys[] = (String[])keySet.toArray(new String[0]);
        return keys;
    }

    protected void complete(PersonManager manager){
        listener.complete(manager, getName());
    }
    protected void complete(ArrayList<Person> list){
        listener.complete(list, getName());
    }
}