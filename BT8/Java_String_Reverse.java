package BT8;

import java.io.*;
import java.util.*;

public class Java_String_Reverse {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A=sc.next();
        for (int i = 0; i <= A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        /* Enter your code here. Print output to STDOUT. */
        
    }
}




