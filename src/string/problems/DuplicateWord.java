package string.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// JAVA IS BEING PRINTED ONLY TWICE
/**
 * Created by mrahman on 04/22/17.
 */
public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        findDupicateWord(st);
    }

    public static void findDupicateWord(String st) {
        String words[] = st.split(" ");

        // Create one Hashmap. Key = words (String). Value = Number (Integer) of repetitive (count) words.
        Map<String, Integer> wordCount = new HashMap<String, Integer>();

        // Check each word in given array.
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word.toLowerCase(), wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);

            }

        }

        // Extract all the keys of map - wordCount:
        Set<String> wordsIsString = wordCount.keySet();

        // Loop through all the words in wordCount:
        for (String word : wordsIsString) {
            if (wordCount.get(word) > 1) {
                System.out.println(word + " : " + wordCount.get(word));
            }
        }
    }

}
