package com.zjffdu.topcoder.srm529;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KingSort {

	private static Map<String, Integer> map = new HashMap<String, Integer>();

	static {
		String[] romans = new String[] { "I", "II", "III", "IV", "V", "VI",
				"VII", "VIII","IX" };
		for (int i = 0; i < 9; ++i) {
			map.put(romans[i], i + 1);
			map.put("X" + romans[i], i + 1 + 10);
			map.put("XX" + romans[i], i + 1 + 20);
			map.put("XXX" + romans[i], i + 1 + 30);
			map.put("XL" + romans[i], i + 1 + 30);
		}

		map.put("X", 10);
		map.put("XX", 20);
		map.put("XXX", 30);
		map.put("XL", 40);
		map.put("L", 50);
	}

	public String[] getSortedList(String[] kings) {

		List<String> list = Arrays.asList(kings);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String name1, String name2) {
				String[] tokens1 = name1.split("\\s");
				String[] tokens2 = name2.split("\\s");
				if (tokens1[0].equals(tokens2[0])) {
					return compareOrdinal(tokens1[1], tokens2[1]);
				} else {
					return tokens1[0].compareTo(tokens2[0]);
				}
			}

			private int compareOrdinal(String ord1, String ord2) {
				int value1 = map.get(ord1);
				int value2 = map.get(ord2);
				if (value1 > value2) {
					return 1;
				} else if (value1 < value2) {
					return -1;
				} else {
					return 0;
				}
			}

		});

		return list.toArray(new String[0]);
	}

	public static void main(String[] args) {
		KingSort sort = new KingSort();
		String[] result = sort
				.getSortedList(new String[] { "Philippe VI", "Jean II",
						"Charles V", "Charles VI", "Charles VII", "Louis XI" });
		for (String item : result) {
			System.out.println(item);
		}
	}
}
