package myhello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import java.util.ArrayList;

@WebService(targetNamespace = "http://webservice.class.gmail.com")
@SOAPBinding(style = Style.RPC)
public interface IHelloWorld{
    @WebMethod public String sayHello(String str);
    @WebMethod public Person getPerson();
    @WebMethod public String putPerson(Person person);
    @WebMethod public ArrayList<Person> getPersons();
    @WebMethod public ArrayList<String> putPersons(ArrayList<Person> persons);
}