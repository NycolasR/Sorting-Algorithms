package algorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class RadixSort extends SortingAlgorithm {
	
	@Override
	public long sort(long[] array) {
		System.out.println("Radix Sort");
		Instant start = Instant.now();
		
		List[] aux = new List[10];
		
		long bigger = bigger(array);
		
		// A quantidade de repetições corresponde a 
		// quantidade de dígitos do maior número
		// que fizer parte da sequência.
		// Variável usada para controlar o laço mais externo.
		int totRepetitions = totDigits(bigger);
		
		for(int i = 1; i <= totRepetitions; i++) {
			
			for (int j = 0; j < aux.length; j++) {	
				aux[j] = new ArrayList<Long>();
			}
			
			for(long number: array) {
				int digit = getDigit(i, number);
				aux[digit].add(number);
			}
			
			int pos = 0;
			
			for(List<Long> list: aux) {
				for(long number: list) {
					array[pos++] = number;
				}
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
