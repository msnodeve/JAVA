import java.util.ArrayList;

// 클라이언트에 해당하는 클래스
// MyEventListener를 상속받아
public class Client implements MyEventListener{
    public static void main(String[] args) throws Exception{
        Client client = new Client();

        //Person 객체 생성
        Person person = new Person();
        person.setData("hakbun", "20143119");
        person.setData("name", "Seok");
        person.setData("age", "25");
        person.setData("tel", "010-9295-3871");
        person.setData("jumin", "950431-1134579");
        person.setData("address", "김해시");

        PersonManager manager = new GetAddressFromServletJSON("http://192.168.177.129/AddressServletJSON",person,client);
        manager.start();

    }
    @Override
    public void complete(String message) {
        System.out.println(message);
    }
    @Override
    public void complete(Object object) {
        PersonManager manager = (PersonManager)object;
		System.out.println(manager.getKeys().length);
		
		String keys[] = manager.getKeys();
		for(int i=0;i<keys.length;i++)
			System.out.println(manager.getPerson(keys[i]).getData("name"));
    }
}