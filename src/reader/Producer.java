package reader;

/*
 * The Producer reads in the data from stdin
 * and puts each tuple pair into the queue.
 * It runs in its own thread.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer implements Runnable {
	   ConcurrentLinkedQueue<String> queue;
	   
	   Producer(ConcurrentLinkedQueue<String> queue){
	      this.queue = queue;
	   }

	   private BufferedReader createReader() {
		   return new BufferedReader(new InputStreamReader(System.in));
	   }
	   
	   private void promptUser() {
		   System.out.println(
		       "Input ID and Age, separated by commas, and pairs separated by a new line.\n" +
			   "Example: 01,99");
	   }
	   
	   private void addInputToQueue(BufferedReader reader) {
		   String line = null;
		   try {
		       while ((line=reader.readLine()) != null) {
				   try {
					   queue.add(line);
				   } catch (Exception e) {
					   e.printStackTrace();
				   }
			   }
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public void run() {
		   BufferedReader reader = createReader();
		   promptUser();
		   addInputToQueue(reader);
	   }
}
