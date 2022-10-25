package BT2;

import java.util.Scanner;

public class Java_Static_Initializer_Block {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int B = sc.nextInt();
        int H = sc.nextInt();
        if (B > 0 && H > 0)
        {
            System.out.print(B * H);
        }
        else
        {
            System.out.print("java.lang.Exception: Breadth and height must be positive");
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
