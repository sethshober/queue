package reader;

/* 
 * This create a hashmap for the values and a queue.
 * The queue holds the tuples from the input.
 * A producer and consumer thread is spun up.
 * The producer reads in the data and puts it onto the queue.
 * The consumer reads data off the queue, manipulates the data and outputs it.
 *
 * TODOs: Optimization: Test different thread counts/pools acting as consumer. 
 *                      Test different data structures.
 *                     
 *            Refactor: Potentially use Executor class
 *                      which would allow futures.
 *                      Should we be storing strings or integers?
 *                      
 *                      Right now the app just hangs waiting for input.
 *                      It would be good to handle a shutdown scenario,
 *                      which would properly shut down threads and close readers.
 *                     
 *                  UX: Prompt instructions. Sort Output.
 */


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> ageCountMap = new ConcurrentHashMap<Integer, Integer>();
	    ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	    
	    ExecutorService producer = Executors.newFixedThreadPool(1);
	    ExecutorService consumer = Executors.newFixedThreadPool(1);
	    
	    producer.submit(() -> new Producer(queue).run());
	    consumer.submit(() -> new Consumer(queue, ageCountMap).run());
	}
}
	