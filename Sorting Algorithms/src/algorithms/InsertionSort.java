package algorithms;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Nyk
 *
 */
public class InsertionSort extends SortingAlgorithm {

	@Override
	public long sort(long[] array) {
		System.out.println("Insertion Sort");
		Instant start = Instant.now();
		
		for(int i = 0; i < array.length - 1; i++) {			
			int j = i + 1;
			long number = array[j]; // Number to be positioned
			
			// Placing a cluttered sequence number in the ordered sequence
			while(j > 0 && number < array[j-1]) {
				array[j] = array[j-1];
				j--;
			}
			
			array[j] = number;
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
}
