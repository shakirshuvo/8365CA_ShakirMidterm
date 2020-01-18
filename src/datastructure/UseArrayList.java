package datastructure;

import databases.ConnectToSqlDB;

import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

public class UseArrayList {

	public static void main(String[] args) throws SQLException {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 *
		 */
		Stack<Integer> stackObj = new Stack<Integer>();

		//Adding  values using push() method
		stackObj.add(23);
		stackObj.add(42);
		stackObj.add(76);
		stackObj.add(18);
		stackObj.add(95);
		stackObj.add(12);
		stackObj.add(105);
		stackObj.add(32);
		stackObj.add(85);
		stackObj.add(99);

		System.out.println("Peeking into the top value using the peek() method: " + stackObj.peek());
		//when popping the last value and using the while look to read all... value 99 should not print
		System.out.println("Using pop() method to remove the last added value: " + stackObj.pop());
		System.out.println("Peeking into the top value after pop() using the peek() method: " + stackObj.peek());
//		System.out.println("Searching for value that DON'T exist using search() method: " + stackObj.search(32));
//		System.out.println("Searching for value that DO EXIST using search() method: " + stackObj.search(42));

		//value 99 should not exist due to popping the last value ---> stack LIFO or last in first out
//		Iterator iterator = stackObj.iterator();
//		while (iterator.hasNext()){
//			System.out.print(iterator.next() + " ");
//		}

		List<Integer> stackArr = new ArrayList<Integer>();
		//creating size int b/c doesn't work in the for loop: ~ for(int i = 0; i <stackObj.size(); i++)...
		//why doesn't it work? <-----------------------------------------
		int size = stackObj.size();
		for(int i = 0; i < size; i++){
			int temp = stackObj.pop();
			stackArr.add(temp);
		}
		System.out.println(stackArr);

		//sorting the data
		Collections.sort(stackArr);

		try{
			ConnectToSqlDB conn = new ConnectToSqlDB();
			conn.insertDataFromIntegerArrayListToSqlTable(stackArr, "usearraylist_to_sql", "arrVal");
		}catch (Exception e){
			e.getStackTrace();
		}

	}

}
