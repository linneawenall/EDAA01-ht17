package textproc;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultiWordCounter implements TextProcessor {
	Map<String, Integer> m = new HashMap<String, Integer>();

	public MultiWordCounter(String[] s) {
		for (String p : s) {
			m.put(p, 0);
		}

		// TextProcessor r = new MultiWordCounter(landskap);//Vad menas??
	}

	public void process(String key) {
		if (m.containsKey(key)) {
			int temp = m.get(key) + 1;
			m.put(key, temp);
		}
	}

	@Override
	public void report() {
		for (String key : m.keySet()) {
			System.out.println(key + ":" + m.get(key));

		}

	}
}
