package algorithms;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Nyk
 *
 */
public class ShellSort extends SortingAlgorithm {
	
	@Override
	public long sort(long[] array, int[] hs) {
		System.out.println("Shell Sort");
		Instant start = Instant.now();
		
		for(int h: hs) {
			for(int i = 0; (i+h) < array.length; i++) { // (i+h) para não passar dos limites do array
				int j = i + h;
				long number = array[j];
				
				while((j-h) >= 0 && number < array[j-h]) { // (j-h) para não passar dos limites do array
					array[j] = array[j-h];
					j = j - h;
				}
				
				array[j] = number;
			}
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
}
