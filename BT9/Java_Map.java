package BT9;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Java_Map {
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            map.put(name, phone);
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            System.out.println(map.containsKey(s) ? s + "=" + map.get(s) : "Not found");
		}
	}
}




