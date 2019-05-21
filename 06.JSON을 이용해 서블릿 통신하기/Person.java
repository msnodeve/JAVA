import java.io.Serializable;

// Serializable을 통해 클래스를 직렬화 시켜 통신하고자 함
public class Person implements Serializable{
    public String name;
    public String hakbun;
    public int age;
    public String tel;
    public String jumin;
    public String address;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getHakbun(){
        return hakbun;
    }
    public void setHakbun(String hakbun){
        this.hakbun = hakbun;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public String getJumin(){
        return jumin;
    }
    public void setJumin(String jumin){
        this.jumin = jumin;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}