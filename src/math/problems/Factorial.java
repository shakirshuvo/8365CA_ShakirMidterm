package math.problems;

/**
 * Created by mrahman on 04/02/18.
 */
public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */

        System.out.println(findFactorialUsingRecursion(5));
        System.out.println(findFactorialUsingIteration(5));
    }

    // Factorial using recursion:
    public static int findFactorialUsingRecursion(int n) {
        if (n <= 1)
            return 1;
        else
            return n * findFactorialUsingRecursion(n - 1);

    }

    // Factorial using Iteration
    public static int findFactorialUsingIteration(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;


        }
        return result;

    }
}