package datastructure;

import databases.ConnectToSqlDB;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		//DON'T KNOW HOW TO ADD TO MySQL DB <---------------------- NEED HELP!
		Map<String, List<String>> countries = new HashMap<String, List<String>>();

		//List of Asian countries
		List<String> asianCountries = new ArrayList<>();
		asianCountries.add("Bangladesh");
		asianCountries.add("Turkey");
		asianCountries.add("Malaysia");
		asianCountries.add("Pakistan");

		//List of European countries
		List<String> europeanCountries = new ArrayList<>();
		europeanCountries.add("Albania");
		europeanCountries.add("Bosnia");
		europeanCountries.add("France");
		europeanCountries.add("Germany");

		//putting the two list into the countries object
		countries.put("Asian", asianCountries);
		countries.put("European", europeanCountries);
		//printing out all the key and their values
		for(Map.Entry<String, List<String>> inst:countries.entrySet()) {
			System.out.println(inst.getKey()+ " "+ inst.getValue());
		}
		//to print out only one key and its values
		System.out.println("Printing only one key and its Values: " + countries.get("blow"));
		//with Iterators
		String iteratorMessage = "Printing key and Values using the Iterator Interface: ";
		for(int x = 1; x<iteratorMessage.length(); x++){
			System.out.print("-");
		}
		System.out.println();

		System.out.println(iteratorMessage);

		Iterator<Map.Entry<String, List<String>>> itr = countries.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, List<String>> entry = itr.next();
			System.out.println("Key Name: " + entry.getKey() + ", Values of Key: " + entry.getValue());
		}

	}

}
