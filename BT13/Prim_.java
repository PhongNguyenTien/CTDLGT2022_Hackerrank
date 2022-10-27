package BT13;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    public static int prims(int n, List<List<Integer>> edges, int start) {
        int minCost = 0;
        int numEdges = edges.size();
        PriorityQueue<AdjNodeCost> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        List<AdjNodeCost>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < numEdges; i++) {
            list[edges.get(i).get(0)].add(new AdjNodeCost(edges.get(i).get(1), edges.get(i).get(2)));
            list[edges.get(i).get(1)].add(new AdjNodeCost(edges.get(i).get(0), edges.get(i).get(2)));
        }
        pq.add(new AdjNodeCost(start, 0));
        while(pq.size() > 0) {
            AdjNodeCost temp = pq.remove();
            int node = temp.getNode();
            int cost = temp.getCost();
            if (visited[node] == false) {
                minCost += cost;
                visited[node] = true;
                for (AdjNodeCost a : list[node]) {
                    int adjNode = a.getNode();
                    if (visited[adjNode] == false) {
                        pq.add(a);
                    }
                }
            }
        }
        return minCost;
    // Write your code here

    }

}

class AdjNodeCost implements Comparable<AdjNodeCost> {
    private int node;
    private int cost;
    
    public AdjNodeCost(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    
    public int getNode() {
        return node;
    }
    
    public int getCost() {
        return cost;
    }
    
    @Override
    public int compareTo(AdjNodeCost other) {
        return (this.cost - other.cost);
    }
}

public class Prim_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> edgesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                edgesRowItems.add(edgesItem);
            }

            edges.add(edgesRowItems);
        }

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

