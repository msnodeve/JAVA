import java.util.ArrayList;

// 객체 저장이 완료되었을 경우 사용할 인터페이스
public interface MyEventListener{
    public void complete(ArrayList<Person> list, String threadName);
    public void complete(Object object, String threadName);
}