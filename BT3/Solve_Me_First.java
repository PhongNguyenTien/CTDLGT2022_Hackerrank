package BT3;

import java.util.*;

public class Solve_Me_First {

    static int solveMeFirst(int a, int b) {
        return a + b;
        // Hint: Type return a+b; below

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}
