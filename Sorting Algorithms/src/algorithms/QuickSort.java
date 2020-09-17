package algorithms;

import java.util.Random;

/**
 * @author Nyk
 *
 */
public class QuickSort implements AlgoritmoDeOrdenacaoRecursivo {
	
	public void sortFirstElementPivot(long[] vetor, int i, int f) {
		
		// Piv�: primeiro elemento
		long pivot = vetor[i];
		
		// �ndices "E" e "D"
		int e = i, d = f;
		
		// Enquanto "E" e "D" n�o se cruzarem 
		while(e <= d) {
			
			// Enquanto "E" n�o passar do limite e
			// o vetor[e] for menor ou igual ao piv�
			while(e <= f && vetor[e] < pivot)
				e++;
			
			// Enquanto "D" n�o passar do limite e
			// o vetor[d] for maior ou igual ao piv�
			while(d >= i && vetor[d] > pivot)
				d--;
			
			// Se n�o se cruzaram, troca-se seus valores
			if(e <= d) {
				long aux = vetor[e];
				vetor[e] = vetor[d];
				vetor[d] = aux;
				
				// Atualiza-se o "E" e o "D"
				e++;
				d--;
			}
		}
		
		// Se os elementos se cruzarem, faz-se as chamadas recursivas
		if(e < f) {
			// .. para de i at� e
			sortFirstElementPivot(vetor, e, f);
		}
		if(d > i) {			
			// .. para de d at� f 
			sortFirstElementPivot(vetor, i, d);
		}
	}
	
	public void sortRandomPivot(long[] vetor, int i, int f) {
		int e = i, d = f;
		
		Random random = new Random();
		long pivot = vetor[e + random.nextInt(d - e + 1)];
		
		while(e <= d) {
			while(e <= f && vetor[e] < pivot)
				e++;
			while(d >= i && vetor[d] > pivot)
				d--;
			
			if(e <= d) {
				long aux = vetor[e];
				vetor[e] = vetor[d];
				vetor[d] = aux;
				
				e++;
				d--;
			}
		}
		
		if(e < f) 
			sortRandomPivot(vetor, e, f);
		if(d > i)
			sortRandomPivot(vetor, i, d);
	}
}
