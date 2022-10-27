package BT13;

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



class Node implements Comparable<Node> {
    public int index;
    public int shortestPath;
    public List<Integer> adjNodes;
    public boolean isChecked;
    
    public Node(int x) {
        this.index = x;
        this.shortestPath = Integer.MAX_VALUE;
        this.adjNodes = new LinkedList<>();
        this.isChecked = false;
    }
    
    public int compareTo(Node other) {
        return this.shortestPath - other.shortestPath;
    }
}

class Result {
    public static int[][] distances;
    public static Node[] nodes;
    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        nodes = new Node[n + 1];
        distances = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        for (List<Integer> list : edges) {
            int u = list.get(0);
            int v = list.get(1);
            int length = list.get(2);
            if (distances[u][v] == 0) {
                nodes[u].adjNodes.add(v);
                nodes[v].adjNodes.add(u);
            }
            if (distances[u][v] == 0 || length < distances[u][v]) {
                distances[u][v] = length;
                distances[v][u] = length;
            }
            
        }
        Node curNode = nodes[s];
        curNode.isChecked = true;
        curNode.shortestPath = 0;
        while(true) {
            for (int i : curNode.adjNodes) {
                if (distances[curNode.index][i] != 0 && nodes[i].isChecked == false) {
                    int newDistance = curNode.shortestPath + distances[curNode.index][i];
                    if (newDistance < nodes[i].shortestPath) {
                        pq.remove(nodes[i]);
                        nodes[i].shortestPath = newDistance;
                        pq.add(nodes[i]);
                    }
                }
                
            }
            curNode.isChecked = true;
            
            if (pq.size() > 0) {
                curNode = pq.poll();
            }
            else {
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                if (nodes[i].shortestPath == Integer.MAX_VALUE) {
                    result.add(-1);
                }
                else {
                    result.add(nodes[i].shortestPath);
                }
            }
        }
        
        return result;
        
    // Write your code here

    }

}
class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

}

class IOUtils {
    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readInt();
        return array;
    }

}

public class Dijkstra_Shortest_Reach_2 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int t = in.readInt();
        while (t > 0) {
            int n = in.readInt();
            int m = in.readInt();
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> e = new ArrayList<>();
                e.add(in.readInt());
                e.add(in.readInt());
                e.add(in.readInt());
                edges.add(e);
            }
            int start = in.readInt();
            var result = Result.shortestReach(n, edges, start);
            for (Integer integer : result) {
                out.print(integer + " ");
            }
            out.printLine();
            t--;
        }
        out.flush();
        out.close();
    }
}

