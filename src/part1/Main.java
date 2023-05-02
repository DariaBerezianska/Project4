package part1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //recursive method for sum
        System.out.println("part1.1");
        System.out.println("sum from 1 to 7 = " + sum1toN(7));
        //recursive method for power
        System.out.println("part1.2");
        System.out.println("2^3 = " + power(2, 3));
    }

    //part 1.1 recursive method for sum
    public static int sum1toN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum1toN(n - 1);
        }
    }

    //part 1.2 recursive method for power
    public static double power(double x, int n) {
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }

}

