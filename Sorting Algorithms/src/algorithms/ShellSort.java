package algorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Nyk
 *
 */
public class ShellSort extends SortingAlgorithm {
	
	@Override
	public long sort(long[] array, boolean isFirstWay) {
		System.out.print("Shell Sort: ");
		System.out.println(isFirstWay ? "First Way" : "Second Way");
		
		ArrayList<Long> hs = isFirstWay ? this.calculateGapFirstWay(array) : this.calculateGapSecondWay(array);
		System.out.println(hs);
		Instant start = Instant.now();
		
		for(long h: hs) {
			int h_tmp = (int) h;
			for(int i = 0; (i+h) < array.length; i++) { // (i+h) para não passar dos limites do array
				int j = i + h_tmp;
				long number = array[j];
				
				while((j-h) >= 0 && number < array[j-h_tmp]) { // (j-h) para não passar dos limites do array
					array[j] = array[j-h_tmp];
					j = j - h_tmp;
				}
				
				array[j] = number;
			}
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
	
	private ArrayList<Long> calculateGapFirstWay(long[] array) {
		ArrayList<Long> hs = new ArrayList<Long>();
		
		for(long h = (long) (array.length / 2); h > 0; h /= 2) {
			hs.add(h);
		}
		
		return hs;
	}
	
	private ArrayList<Long> calculateGapSecondWay(long[] array) {
		ArrayList<Long> hs = new ArrayList<Long>();
		
		long h = 1;
		
		for(int k = 1; k < array.length; k++) {
			if(!hs.isEmpty() && hs.get(k-2) == h)
				break;
			
			hs.add(h);
			h = (long) (Math.pow(4, k) + 3 * Math.pow(2, k-1) + 1);
		}
		Collections.reverse(hs);
		return hs;
	}
}


















