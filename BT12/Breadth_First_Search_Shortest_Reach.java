package BT12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> result = new ArrayList<>();
        Set<Integer>[] adjList = new HashSet[n];
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new HashSet<>();
            distance[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int v = edges.get(i).get(0);
            int w = edges.get(i).get(1);
            adjList[v - 1].add(w - 1);
            adjList[w - 1].add(v - 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        visited[s - 1] = true;
        queue.add(s - 1);
        
        while (queue.size() > 0) {
            s = queue.poll();
            if (distance[s] < 0) {
                distance[s] = 0;
            }
            Iterator<Integer> i = adjList[s].iterator();
            while (i.hasNext()) {
                int k = i.next();
                if (visited[k] == false) {
                    visited[k] = true;
                    queue.add(k);
                    distance[k] = distance[s] + 6;
                }    
            }
        }
        for (int i = 0; i < n; i++) {
            if (distance[i] != 0) {
                result.add(distance[i]);
            }
        }
        return result;
    }

}

public class Breadth_First_Search_Shortest_Reach {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> edgesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                    edgesRowItems.add(edgesItem);
                }

                edges.add(edgesRowItems);
            }

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> result = Result.bfs(n, m, edges, s);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

