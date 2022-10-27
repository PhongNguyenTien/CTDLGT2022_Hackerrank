package BT12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static int m;
    public static int n;
    public static boolean[][] wasTravelled = new boolean[10][10];
    
    public static boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
    
    public static int DFS(List<List<Integer>> matrix, int i, int j) {
        if (isValid(i, j) == false || matrix.get(i).get(j) == 0 || wasTravelled[i][j] == true) {
            return 0;
        }
        wasTravelled[i][j] = true;
        int countCell = 1;
        for (int k = -1; k <= 1; k++) {
            for (int k2 = -1; k2 <= 1; k2++) {
                countCell += DFS(matrix, i + k, j + k2);
            }
        }
        return countCell;
    }

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
        int max = 0;
        m = matrix.size();
        n = matrix.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wasTravelled[i][j] == false && matrix.get(i).get(j) == 1) {
                    max = Math.max(max, DFS(matrix, i, j));
                }
            }
        }
        
        return max;
    }
    // Write your code here
}

public class Connected_Cells_in_a_Grid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

