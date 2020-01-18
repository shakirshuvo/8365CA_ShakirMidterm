package string.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);
        //implement

        //these are the key value of the given String
        System.out.println(wordNLength.keySet());
        // Use this to find out the max value of the key. Then, we will use it to call the value
        int max = 0;
        for(int biggestKey: wordNLength.keySet()) {
            max = Math.max(max, biggestKey);
        }
        //printing out the max key and its value
        System.out.println("Longest Word: " + max + " " + wordNLength.get(max));
    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        //implement
        // A sentence can be split into single word by adding it into an array of String
        // and taking the wordGiven parameter and splitting it into words.
        // Words are split after spaces ( " " )
        String [] words = wordGiven.split(" ");

        // Enhanced for loop to add the word and its size into the Map
        for (String s: words) {
            // Map uses key and value. So, we pass the length of the word as the key and the word itself as the value
            map.put(s.length(), s);
        }

        // Once every key and word value is inserted into map we will return it.
        return map;
    }
}
