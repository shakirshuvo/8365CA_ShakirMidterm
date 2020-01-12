package string.problems;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        String word1 = "racecar";
        String word2 = "Mom";
        String word3 = "Hello";
        String word4 = "abba";

        System.out.println(isPalindrome(word1)); //true
        System.out.println(isPalindrome(word2)); // true
        System.out.println(isPalindrome(word3)); // false
        System.out.println(isPalindrome(word4)); // true
    }

    public static boolean isPalindrome(String word) { // Mom
        String actualWord = word.toLowerCase(); // mom
        String reversedWord = "";
        for (int i = actualWord.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord + actualWord.charAt(i);
        }
        return actualWord.equals(reversedWord);

    }

    public static boolean isPalindromeWith2Pointers(String word) {
        String actualWord = word.toLowerCase();
        int startingPointer = 0;
        int endingPointer = endingPointer = word.length()-1;
        while (startingPointer < endingPointer) {
            if (word.charAt(startingPointer) !=word.charAt(endingPointer)) {
                return false;
            }
            startingPointer++;
            endingPointer--;
        }
        return true;
    }
}
