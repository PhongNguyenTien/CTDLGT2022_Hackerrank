package BT6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    public static void printArray(List<Integer> list)
    {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    public static void insertionSort1(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++)
        {
            int temp = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > temp)
            {
                arr.set(j + 1, arr.get(j));
                j--;
                printArray(arr);
            }
            arr.set(j + 1, temp);
        }
        printArray(arr);
    // Write your code here
    }

}

public class Insertion_Sort_Part_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}

