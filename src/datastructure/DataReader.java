package datastructure;

import databases.ConnectToSqlDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReader {

	public static void main(String[] args) throws IOException {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class.
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		//Had to comment this because the source path was not found!
		//String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";
		String textFile = "C:\\Users\\Shakir\\Documents\\Midterm\\MidtermJuly2019\\src\\data\\self-driving-car";
		BufferedReader br = null;
		//try and catch method to see if the file exists or not
		try {
			br = new BufferedReader(new FileReader(textFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("BufferedReader File Not Found!");
		}
		//creating a LinkedLis and Stack obj
		LinkedList<String> list = new LinkedList<>();
		Stack<String> stack = new Stack<String>();
		//declaring a empty string
		String st = "";
		//replacing the period with empty spaces using replace()
		while((st = br.readLine()) != null){
			String [] indWords = st.replace(",", "").replace("!", "").replace(".", "").split(" ");
			for(String s:indWords){
				list.add(s);
				stack.push(s);
			}
		}
		//if you want to check the list and stack values
		//		Iterator<String> it = list.listIterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//		Iterator<String> it2 = stack.listIterator();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//		}

		//FIFO from LinkedLIst
		System.out.println(list.getFirst()); //prints out he first value inserted in the LinkedList
		System.out.println("Removing first Value of: " + list.removeFirst()); //removes the first value inside the LinkedList
		System.out.println("Updated first Value becomes: " + list.getFirst()); //the second value ("cars") added ot the LinkedList will become the first value
		//Empty space between LinkedList and Stack
		System.out.println();
		//Stack FILO
		System.out.println(stack.peek());//this will show the last value added ot the stack
		System.out.println("POP! the last value will now disappear!" + stack.pop());
		System.out.println("New last value is: " + stack.peek());//the new last value in the stack

//				Iterator<String> it = list.listIterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}

		//printing the value of LinkedList
		ArrayList<String> arrList = LinkedListToArrayList(list);
		try{
			ConnectToSqlDB conn = new ConnectToSqlDB();
			conn.insertDataFromStringArrayListToSqlTable(arrList, "String", "stringValue");
		}catch (Exception e){
			System.out.println("Connection Failed!");
		}


	}

	public static ArrayList<String> LinkedListToArrayList(LinkedList<String> list){
		ArrayList<String> arrList = new ArrayList<>();
		Iterator<String> it = list.listIterator();
		while(it.hasNext()) {
			arrList.add(it.next());
		}
		return arrList;
	}

}
