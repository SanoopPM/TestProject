package scripts;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<>();
		al.add("White");
		al.add("Red");
		al.add("Blue");
		
		System.out.println(al);
		
		for(String s : al)
		{
			if(s.contains("Red"))
			{
				al.remove(s);
			}
			System.out.println(s);
		}
		
		System.out.println("----------");
		System.out.println(al);

	}

}
