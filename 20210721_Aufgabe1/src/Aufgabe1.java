import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// lib to create json from string
import com.google.gson.Gson;

public class Aufgabe1 {

	public static String pathFile1 = "C:\\Projekte\\Arvato_Aufgaben\\20210721_Aufgabe1\\src\\Liste1";
	public static String pathFile2 = "C:\\Projekte\\Arvato_Aufgaben\\20210721_Aufgabe1\\src\\Liste2";
	
	static List<String> list1 = new ArrayList<String>();
	static List<String> list2 = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
		
		list1 = readFile(pathFile1);
		list2 = readFile(pathFile2);
		printJson();
	}
	
	/*
	 * reads the file line by line and separates the words after a comma
	 * 
	 * @param path corresponds to the path of the file to be read
	 */
	public static List<String> readFile (String path) throws IOException {
		
		List<String> words = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	//Separation the words at the comma
		    	String[] parts = line.split(", ");
		    	for(int i = 0; i < parts.length; i++) {
		    		words.add(parts[i]);
		    	}
		    }
		}
		return words;
	}
	
	/*
	 * create Json-String from custom Obj
	 * 
	 * @param JsonObj obj custom object 
	 */
	public static String createJson(JsonObj obj) throws IOException{
		
		String json = new Gson().toJson(obj);
		return json;
	}
	
	/*
	 * print the json
	 */
	public static void printJson() throws IOException {
		
		JsonObj obj = new JsonObj();
		obj.setValues(list1, list2);
		System.out.println(createJson(obj));
	}
}