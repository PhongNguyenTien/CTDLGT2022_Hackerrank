package BT3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String stringHour = s.substring(0, 2);
        int hour = Integer.parseInt(stringHour);
        String session = s.substring(8, 10);
        if (s == "12:00:00AM") return "00:00:00";
        if (s == "12:00:00PM") return "12:00:00";
        if (session.equals("AM") && stringHour.equals("12")) {
            stringHour = "00";
        }
        if (session.equals("PM") && hour > 0 && hour < 12) {
            hour += 12;
            stringHour = Integer.toString(hour);
        }
        return stringHour + s.substring(2, 8);
    // Write your code here

    }

}

public class Time_Conversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

