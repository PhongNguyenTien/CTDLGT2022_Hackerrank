package BT8;

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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        result.add((double)a.get(0));
        maxQueue.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            if (minQueue.size() < maxQueue.size()) {
                minQueue.add(a.get(i));
            }
            else {
                maxQueue.add(a.get(i));
            }
        // min.size <= max.size
        
            while (maxQueue.peek() > minQueue.peek()) {
                int biggerNum = maxQueue.poll();
                int smallerNum = minQueue.poll();
                minQueue.add(biggerNum);
                maxQueue.add(smallerNum);
            }
            if (maxQueue.size() > minQueue.size()) {
                result.add((double) maxQueue.peek() * 1.0);
            }
            else {
                double temp = (double) (minQueue.peek() + maxQueue.peek()) / 2.0;
                result.add(temp);
            }
        }
        return result;
        
    // Write your code here

    }

}

public class Find_the_Running_Median {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
