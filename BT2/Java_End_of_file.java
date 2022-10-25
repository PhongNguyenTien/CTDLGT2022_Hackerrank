package BT2;

import java.util.Scanner;

public class Java_End_of_file {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            System.out.println(index + " " + s);
            index++;
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
