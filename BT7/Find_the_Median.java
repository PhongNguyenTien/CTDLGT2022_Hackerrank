package BT7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int partition(List<Integer> arr, int lo, int hi) {
        int n = arr.size();
        int pivot = arr.get(lo);
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (pivot > arr.get(++i)) {
                if (i == hi) break;
            }
            while (pivot < arr.get(--j)) {
                if (j == lo) break;
            }
            if (i >= j) break;
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
        int temp = arr.get(lo);
        arr.set(lo, arr.get(j));
        arr.set(j, temp);
        if (j == n / 2) {
            return pivot;
        }
        else if (j < n / 2) {
            return partition(arr, j + 1, hi);
        }
        else {
            return partition(arr, lo, j - 1);
        }
    }
    public static int findMedian(List<Integer> arr) {
        return partition(arr, 0, arr.size() - 1);
    // Write your code here

    }
}
public class Find_the_Median {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

