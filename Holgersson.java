
package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();

		Scanner s = new Scanner(new File("../lab1/nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		Scanner stopwords = new Scanner(new File("undantagsord.txt"));

		// TextProcessor p = new SingleWordCounter("nils");
		// TextProcessor p2 = new SingleWordCounter("norge");
		// TextProcessor p3 = new MultiWordCounter(REGIONS);
		TextProcessor r = new GeneralWordCounter(stopwords);
		List<TextProcessor> list = new ArrayList<TextProcessor>();
		// list.add(p);
		// list.add(p2);
		// list.add(p3);
		list.add(r);

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			for (TextProcessor b : list) {
				b.process(word);

				// for (int i = 0; i < list.size(); i++) {
				// list.get(i).process(word);
				// }
			}
		}

		s.close();

		for (TextProcessor c : list) {
			c.report();

			// for (int i = 0; i < list.size(); i++) { //ekvivalent med
			// foreach-sats
			// list.get(i).report();
			// }
		}

		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
		// tid1: 613.404974 ms, tid2: 567.0238 ms, tid3: 537.777424 ms, medeltid:572,73
	}
}
