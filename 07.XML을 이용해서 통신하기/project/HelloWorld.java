package myhello;

import java.util.ArrayList;

import javax.jws.WebService;
@WebService(targetNamespace = "http://webservice.class.gmail.com")
public class HelloWorld implements IHelloWorld{

    @Override
    public String sayHello(String str){
        return str+" from Web Service";
    }

    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setName("이방원");
        person.setAge(20);
        return person;
    }
    
    @Override
    public String putPerson(Person person){
        return person.getName();
    }

    @Override
    public ArrayList<Person> getPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setName("이성계");
        person.setAge(40);
        persons.add(person);
        person = new Person();
        person.setName("이도");
        person.setAge(50);
        persons.add(person);
        return persons;
    }

    @Override
    public ArrayList<String> putPersons(ArrayList<Person> persons) {
        ArrayList<String> list = new ArrayList<>();
        list.add(persons.get(0).getName());
        list.add(persons.get(1).getName());
        return list;
    }
}