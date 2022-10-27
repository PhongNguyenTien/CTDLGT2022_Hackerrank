package BT5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Java_List {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = sc.nextInt();
            list.add(arr[i]);
        }
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++)
        {
            String query = sc.next();
            if (query.equals("Insert"))
            {
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);
            }
            if (query.equals("Delete"))
            {
                int index = sc.nextInt();
                list.remove(index);
            }
            
        }
        for (int i = 0; i < list.size() - 1; i++)
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.print(list.get(list.size() - 1));
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}

