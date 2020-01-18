package math.problems;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */

        int sequence = 40;
        for (int i = 0; i <= sequence; i++) {
            System.out.println(fib(i));
        }
    }

    public static int fib(int num) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
}

