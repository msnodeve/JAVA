import java.util.*;
import java.io.*;

public class Person implements Serializable{
	private HashMap<String,String> maps;

	public Person() {
		maps = new HashMap<String,String>();
	}

	public Person(String str) {
		maps = new HashMap<String,String>();
		String parsedData[] = str.split("/");

		for(int i=0;i<parsedData.length;i++) {
			String inputData[] = parsedData[i].split("=");
			maps.put(inputData[0],inputData[1]);
		}
	}

	public String getData(String key) {
		return maps.get(key);
	}

	public void setData(String key, String value) {
		maps.put(key,value);
	}

	public String getGender() {
		int gender=Integer.parseInt(getData("jumin").substring(7,8));
		if(gender==1 || gender==3)
			return "male";
		else
			return "female";
	}

	public int getYear() {
		int year = Integer.parseInt(getData("jumin").substring(0,2));
		int gender=Integer.parseInt(getData("jumin").substring(7,8));

		if(gender==1 || gender==2)
			return 1900+year;
		else
			return 2000+year;
	}

	public int getMonth() {
		int month = Integer.parseInt(getData("jumin").substring(2,4));
		return month;
	}

	public int getDay() {
		return Integer.parseInt(getData("jumin").substring(4,6));
	}

	public int getAge() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR)-getYear();
	}

}