package BT7;

import java.io.*;
import java.util.*;

public class Quicksort_In_Place {
    public static int partition(int a[], int low, int high) {
        int n = a.length;
        int i = low;
        int pivot = a[high];
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = a[high];
        a[high] = temp;
        for (int k = 0; k < n; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();
        return i;
    }
    
    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int key = partition(a, low, high);
        quickSort(a, low, key - 1);
        quickSort(a, key + 1, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        quickSort(a, 0, n - 1);
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}

