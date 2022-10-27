package BT5;

import java.io.*;
import java.util.*;

public class Simple_Text_Editor {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        
        String s = "";
        
        Stack<String> top = new Stack<String>();
        top.push(s);
        
        String options;
        while(Q > 0){
            //System.out.println(s.length());
            options = br.readLine();
            if(options.charAt(0) == '1'){
                s = s.concat(options.substring(2, options.length()));
                top.push(s);
            }
            else if(options.charAt(0) == '2'){
                int K;
                K = Integer.parseInt(options.substring(2, options.length()));
                K = s.length() - K;
                s = s.substring(0, K);
                top.push(s);
            }
            else if(options.charAt(0) == '3'){
                int Kth;
                Kth = Integer.parseInt(options.substring(2, options.length()));
                System.out.println(s.charAt(Kth - 1));
            }
            else if(options.charAt(0) == '4'){
                String data = top.pop();
                s = top.peek();                
            }
            Q--;
        }
    }
}

