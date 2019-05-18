import java.io.*;

public class GetAddressFromFile extends PersonManager{
    private BufferedReader in;
    public GetAddressFromFile(String filename, MyEventListener listener) throws Exception{
        super();
        in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        this.listener = listener;
    }

    public void run(){
        try{
            String str="";
            while((str=in.readLine())!=null) {
                Person person = new Person(str);
                maps.put(person.getData("name"), person);
            }
            complete(this);
        }catch(Exception e) { }
    }
}