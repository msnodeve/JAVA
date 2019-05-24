import java.util.*;

// 이 인터페이스를 상속 받으면 complete 함수를 구현 해야함
public interface MyEventListener {
	public void complete(Object object);
	public void complete(String message);
}