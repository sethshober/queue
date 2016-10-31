package reader;

/*
 * Util provides helper methods to manipulate the data
 */


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

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
		map.forEach((key,val) -> {
			System.out.printf("%s : %s\n", key, val);
		});
	}
	
	// shutdown executor safely
	public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

}
	
