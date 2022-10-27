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
     * Complete the 'introTutorial' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER V
     *  2. INTEGER_ARRAY arr
     */
    public static int binarySearch(int V, List<Integer> arr, int lo, int hi)
    {
        int mid = lo + (hi - lo) / 2;
        if (arr.get(mid) == V)
        {
            return mid;
        }
        if (arr.get(mid) < V)        
        {
            return binarySearch(V, arr, mid + 1, hi);
        }
        return binarySearch(V, arr, lo, mid - 1);
    }
    public static int introTutorial(int V, List<Integer> arr) {
        return binarySearch(V, arr, 0, arr.size() - 1);
    // Write your code here

    }

}

public class Intro_to_Tutorial_Challenges {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int V = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.introTutorial(V, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

