package reader;

/*
 * Util provides helper methods to manipulate the data
 */


import java.util.concurrent.ConcurrentHashMap;

public class Util {
	
	// normalizes to our spec...which currently is only removing spaces
	public static String normalize(String str) {
		str = str.replaceAll("\\s+","");
		return str;
	}
	
	// grab the age from a tuple pair
	public static Integer getAge(String str) {
		String[] vals = str.split(",");
		return Integer.parseInt(vals[1]);
	}
	
	// print final age counts
	public static void printMap(ConcurrentHashMap<Integer, Integer> map) {
		System.out.println("Age | Count");
		System.out.println("-----------");
		// TODO: sort by value
		map.forEach((key,val) -> {
			System.out.printf("%s : %s\n", key, val);
		});
	}

}
	
