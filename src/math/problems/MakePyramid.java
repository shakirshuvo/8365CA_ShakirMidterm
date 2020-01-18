package math.problems;

import java.util.Scanner;

public class MakePyramid {
    public static void main(String[] args) {

        /*   Implement a large Pyramid of stars in the screen with java.

                              *
                             * *
                            * * *
                           * * * *
                          * * * * *
                         * * * * * *

        */

        Scanner sc = new Scanner(System.in);

        System.out.println("How many rows you want?");
        int rowNum = sc.nextInt();
        //this for loop will be in charge of making sure that we have the proper count of rows
        for(int i = 1; i <= rowNum; i++){
            for(int j = rowNum; j >i; j--){
                //adding the spaces before the asterisk
                System.out.print(" ");
            }
            int x = i;
            //this will print our the asterisks depending on the rowNum value
            while(x > 0){
                System.out.print("* ");
                x--;
            }
            //end line after the each row
            System.out.println();
        }

    }

  }
