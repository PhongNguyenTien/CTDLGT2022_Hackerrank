package BT3;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        double length = arr.size();
        double countPositive = 0;
        double countNegative = 0;
        for (int i = 0; i < length; i++) {
            if (arr.get(i) > 0)
            {
                countPositive++;
            }
            else if (arr.get(i) < 0)
            {
                countNegative++;
            }
        }
        System.out.println(countPositive / length);
        System.out.println(countNegative / length);
        System.out.println(1 - countPositive / length - countNegative / length);
    // Write your code here

    }

}

public class Plus_Minus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

