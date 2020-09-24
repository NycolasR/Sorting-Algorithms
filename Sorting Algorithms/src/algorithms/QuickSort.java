package algorithms;

import java.util.Random;

/**
 * @author Nyk
 *
 */
public class QuickSort extends SortingAlgorithm {
	
	@Override
	public void sortFirstElementPivot(long[] array, int i, int f) {
		
		// Pivô: primeiro elemento
		long pivot = array[i];
		
		// índices "E" e "D"
		int e = i, d = f;
		
		// Enquanto "E" e "D" não se cruzarem 
		while(e <= d) {
			
			// Enquanto "E" não passar do limite e
			// o vetor[e] for menor ou igual ao pivô
			while(e <= f && array[e] < pivot)
				e++;
			
			// Enquanto "D" não passar do limite e
			// o vetor[d] for maior ou igual ao pivô
			while(d >= i && array[d] > pivot)
				d--;
			
			// Se não se cruzaram, troca-se seus valores
			if(e <= d) {
				long aux = array[e];
				array[e] = array[d];
				array[d] = aux;
				
				// Atualiza-se o "E" e o "D"
				e++;
				d--;
			}
		}
		
		// Se os elementos se cruzarem, faz-se as chamadas recursivas
		if(e < f) {
			// .. para de i até e
			sortFirstElementPivot(array, e, f);
		}
		if(d > i) {			
			// .. para de d até f 
			sortFirstElementPivot(array, i, d);
		}
	}
	
	public void sortRandomPivot(long[] array, int i, int f) {
		int e = i, d = f;
		
		Random random = new Random();
		long pivot = array[e + random.nextInt(d - e + 1)];
		
		while(e <= d) {
			while(e <= f && array[e] < pivot)
				e++;
			while(d >= i && array[d] > pivot)
				d--;
			
			if(e <= d) {
				long aux = array[e];
				array[e] = array[d];
				array[d] = aux;
				
				e++;
				d--;
			}
		}
		
		if(e < f) 
			sortRandomPivot(array, e, f);
		if(d > i)
			sortRandomPivot(array, i, d);
	}
}
