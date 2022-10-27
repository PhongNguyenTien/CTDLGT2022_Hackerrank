package BT11;

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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    /* using hash table (map) and sort */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer key : brr) {
            map.put(key, 0);
        }
        for (Integer key : brr) {
            map.put(key, map.get(key) + 1);
        }
        for (Integer key : arr) {
            map.put(key, map.get(key) - 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    /* using counting sort */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> count = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Integer i : brr) {
            if (max < i) {
                max = i;
            }
        }
        for (int i = 0; i <= max; i++) {
            count.add(0);
        }
        for (Integer i : brr) {
            count.set(i, count.get(i) + 1);
        }
        for (Integer i : arr) {
            count.set(i, count.get(i) - 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            if (count.get(i) > 0) {
                result.add(i);
            }
        }
        return result;
    // Write your code here

    }

}

public class Missing_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

