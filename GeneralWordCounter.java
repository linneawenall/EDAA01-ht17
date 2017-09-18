package textproc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
	Map<String, Integer> m = new TreeMap<String, Integer>();
	Set<String> set = new HashSet<String>();

	public GeneralWordCounter(Scanner scan) {
		while (scan.hasNext()) {
			String temp = scan.next();
			set.add(temp);
			// System.out.println(temp);
			// System.out.println(set);
		}
		
		

	}

	public void process(String key) {
			if (!set.contains(key)) {
				if (m.containsKey(key)) {
						int temp = m.get(key) + 1;
						m.put(key, temp);
					}
				else{
					m.put(key, 1);
				}
			}
		}

	

	public void report() {
		for(String key : m.keySet()){
			if(m.get(key) >= 200){
			System.out.println(key + ":" + m.get(key));
		}
	}
	}
}
