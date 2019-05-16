import java.util.HashMap;

// PersonManager로부터 받은 한줄을 Person 클래스가 알아서 HashMap에 저장
public class Person {
    private HashMap<String, String> datas;
    
    public Person(String str) {
        datas = new HashMap<>();
        String data[] = str.split("/");
        for (int i = 0; i < data.length; i++) {
            String value[] = data[i].split("=");
            datas.put(value[0], value[1]);
        }
    }

    public String getValue(String key) {
        return datas.get(key);
    }
}