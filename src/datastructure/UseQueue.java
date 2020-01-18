package datastructure;

import databases.ConnectToSqlDB;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 */
		//Queue is the same as Stack but its FIFO ---> first in first out
		Queue<String> q = new LinkedList<>();
		q.add("First");
		q.add("Second");
		q.add("Third");
		q.add("Fourth");
		//checking the first value that was put to the queue
		System.out.println("Checking the first value using peek(): " + q.peek());
		System.out.println("Removing the first value using remove(): " + q.remove());
		//printing values of queue using Iterator
		Iterator<String > itr = q.iterator();
		System.out.println("Using Iterator to print the values of stack!");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		try {
			ConnectToSqlDB conn = new ConnectToSqlDB();
			while(itr.hasNext()) {
				String a = itr.next();
				conn.insertDataFromStringToSqlTable(a, "useQueue", "strValue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
