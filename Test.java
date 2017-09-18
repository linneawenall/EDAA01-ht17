package textproc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String[]args){
	Set<Integer> nbrs = new HashSet<Integer>();
	//List<Integer> nbrs = new ArrayList<Integer>();
	for(int i=0; i<100; i+=10){
		nbrs.add(i);
		nbrs.add(i);
	
	}
	for(int a : nbrs){
		System.out.println(a);
	}
	}
}

