package BT5;

import java.io.*;
import java.util.*;

public class Queue_using_Two_Stacks {

    public static void main(String[] args) {
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int option;
        for (int i = 0; i < q; i++)
        {
            option = sc.nextInt();
            if (option == 1)
            {
                int value = sc.nextInt();
                mainStack.push(value);
            }
            if (option == 2)
            {
                if (secondStack.empty())
                {
                    while (!mainStack.empty())
                    {
                        secondStack.push(mainStack.pop());
                    }
                }
                secondStack.pop();
            }
            if (option == 3)
            {
                if (secondStack.empty())
                {
                    while (!mainStack.empty())
                    {
                        secondStack.push(mainStack.pop());
                    }
                }
                System.out.println(secondStack.peek());
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}

