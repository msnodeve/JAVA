import java.util.*;
import java.io.Serializable;

public class Person implements Serializable {

	private HashMap<String,String> data;

	public Person() {
		data = new HashMap<String,String>();
	}

	public Person(String str) {
		data = new HashMap<String,String>();
		String parsedData[] = str.split("/");

		for(int i=0;i<parsedData.length;i++) {
			String inputData[] = parsedData[i].split("=");
			data.put(inputData[0],inputData[1]);
		}
	}

	public String getData(String key) {
		return data.get(key);
	}

	public void setData(String key, String value) {
		data.put(key,value);
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

	public String[] getKeys() {
		Set<String> keys = data.keySet();
		return (String[]) keys.toArray(new String[0]);
	}
/*
	public String getHakbun() {
		return data.get("hakbun");
	}
	public String getName() {
		return data.get("name");
	}
	public String getTel() {
		return data.get("tel");
	}
	public String getJumin() {
		return data.get("jumin");
	}
	public String getAddress() {
		return data.get("address");
	}
*/

}










