// 이벤트를 받기위해 리스너를 만듬
// 나중에 어디서든지 받을 수 있게 하기 위함
public interface MyEventListener{
    public void complete(long size);
    //public void complete(ArrayList list);
}