package reader;

/*
 * The Consumer reads data off the queue,
 * manipulates it, and adds the data to a
 * hashtable of ages and counts.
 * It runs in its own thread
 * 
 * TODO: Move output elsewhere.
 *       The consumer should only manipulate data.
 */


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable {
	ConcurrentHashMap<Integer, Integer> ageCountMap;
	ConcurrentLinkedQueue<String> queue;
	
	Consumer(ConcurrentLinkedQueue<String> queue, ConcurrentHashMap<Integer, Integer> ageCountMap){
		this.queue = queue;
		this.ageCountMap = ageCountMap;
	}

	public void run() {
		String str;
		while ((str = queue.poll()) != null) {
			str = Util.normalize(str);
			int age = Util.getAge(str);
			   
			if (ageCountMap.containsKey(age)) {
				int ageCount = ageCountMap.get(age);
				ageCountMap.put(age, ageCount + 1 );
			} else {
			    ageCountMap.put(age, 1);
			}
			
			Util.printMap(ageCountMap);
	    }
	       try {
	    	   // FIXME: Let's be smarter about our thread use
	    	   // and not just call run over and over
	    	   Thread.currentThread().sleep(500);
	    	   run();
	       } catch (Exception ex) {
	    	   ex.printStackTrace();
	       }
	   }
}	   

		   
