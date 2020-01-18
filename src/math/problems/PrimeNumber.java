package math.problems;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */


		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */

		int counter = 0;

		List<Integer> list = new ArrayList<>();
		for (int i = 2; i < 1000000; i++) {
			if (isPrime(i)) {
				list.add(i);
				System.out.println(i);
				counter++;

			}
		}
		/*for (Integer in : list)
			System.out.println(in);*/
		//List<String> lowestValue = new ArrayList<String>();
		//ConnectDB connectDB = new ConnectDB();


		try {
			//connectDB.insertDataFromArrayListToMySql(list, "mathPrime", "number");
			//lowestValue = connectDB.readDataBase("mathPrime", "number");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Data is reading from the Table (mathPrime) and displaying to the console");
		//for (String st : lowestValue) {
		//System.out.println(st);
		System.out.println("total number of prime numbers" + counter);
	}
// created the Static Method outside the Main Method.



	public static boolean isPrime ( int number){
		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= number; i = i + 2) {
			if (number % i == 0) {
				return false;
			}

		}
		return true;
	}
}




