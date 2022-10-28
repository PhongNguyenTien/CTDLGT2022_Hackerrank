package BT11;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Node implements Comparable<Node> {
    public int value;
    public int index;
    
    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
    
    public Node() {
        
    }
    
    @Override
    public int compareTo(Node other) {
        if (this.value < other.value) return -1;
        if (this.value > other.value) return 1;
        if (this.index < other.index) return -1;
        if (this.index > other.index) return 1;
        return 0;
    }
}

public class Find_the_Running_Median  {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Node> treeSet = new TreeSet<Node>();
        treeSet.add(new Node(Integer.MIN_VALUE, 0));
        treeSet.add(new Node(Integer.MAX_VALUE, n + 1));
        Node midNode = new Node(Integer.MIN_VALUE, 0);
        for (int i = 1; i <= n; ++i) {
            Node node = new Node(sc.nextInt(), i);
            treeSet.add(node);
            if (i % 2 == 1) {
                if (midNode.compareTo(node) < 0) midNode = treeSet.higher(midNode);
                System.out.println((double) midNode.value);
            } else {
                if (midNode.compareTo(node) > 0) midNode = treeSet.lower(midNode);
                System.out.println(((double) midNode.value + (double) treeSet.higher(midNode).value) / 2);
            }
        }
    }
}

