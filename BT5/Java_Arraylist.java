package BT5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Java_Arraylist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
            int length = sc.nextInt();
            for (int j = 0; j < length; j++) {
                int value = sc.nextInt();
                arr[i].add(value);
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y > arr[x - 1].size())
            {
                System.out.println( "ERROR!");
            }
            else
            {
                System.out.println(arr[x - 1].get(y - 1));
            }
        }
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}

