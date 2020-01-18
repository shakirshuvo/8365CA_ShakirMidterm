package string.problems;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.

    }


    //
    @Test
    public void testThatChecksIfTwoStringAreAnagram() {
        Boolean actuaAnagramOutcome = Anagram.areAnagram("CAT", "ACT");
        Boolean expectedAnagramOutcome = true;
        Assert.assertEquals(actuaAnagramOutcome, expectedAnagramOutcome);
    }

    @Test
    public void testThatChecksIfTwoStringAreNotAnagram() {
        Boolean actualAnagramOutcome = Anagram.areAnagram("CAT", "DAT");
        Boolean expectedAnagramOutcome = false;
        Assert.assertEquals(actualAnagramOutcome, expectedAnagramOutcome);
    }

//    @Test
//    public void testThatFindsTheLargestWordInAStringSentenceCorrectly() {
//        Map actualLargestWord = DetermineLargestWord.
//        String expectedLargestWord = "biological";
//        Assert.assertEquals(actualLargestWord, expectedLargestWord);
//    }

    @Test
    public void testThatChecksIfAStringIsAPalindrome() {
        Boolean actualPalindromeOutcome = Palindrome.isPalindrome("racecar");
        Boolean expectedPalindromeOutcome = true;
        Assert.assertEquals(expectedPalindromeOutcome, actualPalindromeOutcome);
    }

    @Test
    public void testThatChecksIfAStringIsNotAPalindrome() {
        Boolean actualPalindromeOutcome = Palindrome.isPalindrome("Hello");
        Boolean expectedPalindromeOutcome = false;
        Assert.assertEquals(expectedPalindromeOutcome, actualPalindromeOutcome);
    }
}

