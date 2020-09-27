package algorithms;

import java.time.Duration;
import java.time.Instant;

public class CountingSort extends SortingAlgorithm {
	
	@Override
	public long sort(long[] array) {
		System.out.println("Counting Sort");
		Instant start = Instant.now();
		
		long bigger = bigger(array);
		
		int totRepetitions = totDigits(bigger);
		
		for(int decimalPlace = 1; decimalPlace <= totRepetitions; decimalPlace++) {
			
			// preenchendo a frequência absoluta
			long[] absoluteFrequency = new long[10];
			for(long k: array) {
				int digit = getDigit(decimalPlace, k);
				absoluteFrequency[digit]++;
			}
			
			// preenchendo a frequência acumulada
			long[] accumulatedFrequency = new long[10];
			for(int i = 1; i < absoluteFrequency.length; i++) {
				accumulatedFrequency[i] = absoluteFrequency[i-1] + accumulatedFrequency[i-1];
			}
			
			// reorganizando os elementos considerando a casa decimal da vez
			long[] copy = array.clone();
			for(long k: copy) {
				int digit = getDigit(decimalPlace, k);
				int destiny = (int) accumulatedFrequency[digit]++;
				array[destiny] = k;
			}
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
	
	private int getDigit(int i, long number) {
		return (int) number / ((int) Math.pow(10, i-1)) % 10;
	}
	
	private long bigger(long[] array) {
		long bigger = 0;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] > bigger) bigger = array[i];
		}
		
		return bigger;
	}

	private int totDigits(long number) {
		return Long.toString(number).length();
	}
}
