package string.problems;

import java.util.Arrays;

/**
 * Created by mrahman on 04/22/17.
 */
public class Anagram {

    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".

        areAnagram("Cat", "ACT"); // true
        areAnagram("MARY", "ARMY"); // true
        areAnagram("Sum", "um"); //false
    }

    public static boolean areAnagram (String word1, String word2) { // word1: "bob", word2: "obb"
        // if both words are the same length
        if (word1.length() != word2.length()) {
            return false;
        }
        // process both words into chracter arrays
        char [] word1array = word1.toLowerCase().toCharArray(); // ['b', 'o', 'b']
        char [] word2array = word2.toLowerCase().toCharArray(); // ['o', 'b', 'b']

        Arrays.sort(word1array); // ['b', 'b', 'o']
        Arrays.sort(word2array); // ['b', 'b', 'o']

        for (int i=0; i < word1array.length; i++)  {
            if (word1array[i] != word2array[i]) {
                return false;
            }
        }
        return true;
    }
}
