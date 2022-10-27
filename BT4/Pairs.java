package BT4;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */
    public static int binarySearch(int key, int left, int right, List<Integer> arr)
    {
        int m = left + (right - left) / 2;
        if (left <= right)
        {
            if (arr.get(left) == key) return left;
            if (arr.get(right) == key) return right;
            if (arr.get(m) == key) return m;
            else if (arr.get(m) > key)
            {
                return binarySearch(key, left + 1, m - 1, arr);
            }
            else 
            {
                return binarySearch(key, m + 1, right - 1, arr);
            }
        }
        return -1;
    }
    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
        Collections.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (binarySearch(arr.get(i) + k, i + 1, arr.size() - 1, arr)  > 0)
            {
                count++;
            }
        }
        return count;

    }

}

public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

