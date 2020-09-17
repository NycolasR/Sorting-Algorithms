package algorithms;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Nyk
 *
 */
public class BubbleSort implements SortingAlgorithm {
	
	public long sort(long[] vetor) {
		System.out.println("Bubble Sort");
		Instant inicio = Instant.now();
		
		// Se n�o houveram mudan�as, o array j� est� ordenado
		boolean hasChanged = true;
		
		while (hasChanged) {
			hasChanged = false;
			
			// Contador para que o �ltimo elemento n�o seja analizado
			int j = 0;
			
			for (int i = 0; i < vetor.length -1 - j; i++) {
				
				if(vetor[i] > vetor[i+1]) {
					// Troca do valor com seu sucessor
					long aux = vetor[i];
					vetor[i] = vetor[i+1];
					vetor[i+1] = aux;
					hasChanged = true;			
				}
			}
			j++;
		}
		
		Instant fim = Instant.now();

		Duration duracao = Duration.between(inicio, fim);
		long duracaoEmMilissegundos = duracao.toMillis();
		return duracaoEmMilissegundos;
	}	
}
