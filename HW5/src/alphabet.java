import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
	private Set<Character> english_alphabet = new LinkedHashSet<Character>();
	private Map<Character, Map<Character, Character>> map = new HashMap<Character,  Map<Character, Character>>();
	
	public alphabet() {
		// do not edit this method
		fill_english_alphabet();
		fill_map();
	}
	
	private void fill_english_alphabet() {
		// do not edit this method
		for(char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
		    english_alphabet.add(c);
		}
	}
	
	private void fill_map() {
		Iterator<Character> rowIterator = english_alphabet.iterator();
		int shift = 0;
		while (rowIterator.hasNext()) {
			char rowChar = rowIterator.next();
			Map<Character, Character> columnMap = new HashMap<>();
			Iterator<Character> colIterator = english_alphabet.iterator();
			for (int i = 0; i < shift; i++) {
				colIterator.next(); // Skip characters to achieve the left shift
			}
			for (char colChar : english_alphabet) {
				if (!colIterator.hasNext()) {
					colIterator = english_alphabet.iterator(); // Wrap around
				}
				columnMap.put(colChar, colIterator.next());
			}
			map.put(rowChar, columnMap);
			shift++;
		}
	}

	public void print_map() {
		// do not edit this method
		System.out.println("*** Viegenere Cipher ***\n\n");
		System.out.println("    " + english_alphabet);
		System.out.print("    ------------------------------------------------------------------------------");
		for(Character k: map.keySet()) {
			System.out.print("\n" + k + " | ");
			System.out.print(map.get(k).values());
		}
		System.out.println("\n");
		
	}

	public Map get_map() {
		return map;
	}
}