//실행 클래스
public class Main{
    //이 클래스와 동일한 폴더 내, address.txt 파일을 PersonManager에게 넘겨줌
    public static void main(String[] args) throws Exception{
        PersonManager manager = new PersonManager("address.txt");
        String keys[] = manager.getKeys();
        for(int i = 0 ; i<keys.length;i++){
            Person person = manager.getPerson(keys[i]);
            System.out.println(person.getValue("name"));
        }
    }
}