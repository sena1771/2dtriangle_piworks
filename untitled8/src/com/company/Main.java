package com.company;
import java.nio.file.*;

import static java.util.Arrays.stream;
public class Main {



    public static void main(String[] args) throws Exception {
        //reads the file and transform it to the 2 dimensional int array
        int[][] my = Files.lines(Paths.get("triangle_3" ))
                .map(str -> stream(str.trim().split("\\s+")) //detects the spaces too
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);


        //finds the max route and calculates the sum value


        for (int i = my.length - 2; i >= 0; i--) {  //loops row length-1 times

            for (int j = 0; j < my[i].length; j++) { //column

                if ((prime(my[i][j]))==1) //not accepts the none prime numbers
                    my[i][j]=0;



                if((i==my.length-2) && prime(my[i+1][j+1])==1) //checks the last row if it includes prime number,previous row's diagonal
                    my[i+1][j+1]=0;
                if((i==my.length-2)&& prime(my[i+1][j])==1) //checks the last row again but that time previous row's under
                    my[i+1][j]=0;


                my[i][j] += Math.max(my[i + 1][j], my[i + 1][j + 1]); //calculates max sum value
            }}
        System.out.println(my[0][0]);

    }


    static int prime(int a) { //method which finds whether a number is prime or not
        for(int i=2;i<a;i++){
            if(a%i==0)
                return 0;
        }
        if(a<=2)
            return (a==2)? 1:0;

        return 1;
    }

}
