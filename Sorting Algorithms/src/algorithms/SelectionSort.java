package algorithms;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Nyk
 *
 */
public class SelectionSort implements SortingAlgorithm {
	
	public long sort(long[] vetor) {
		System.out.println("Selection Sort");
		Instant inicio = Instant.now();
		
		for (int i = 0; i < vetor.length; i++) {			
			// Identificando o índice de menor elemento de um vetor
			int indiceMenor = i; // assume-se que o menor é o i-ésimo
			
			// A iteração em busca do menor valor deve acontecer após
			// a posição do i, pois este trecho já está ordenado
			for (int j = i+1; j < vetor.length; j++) {
				if(vetor[j] < vetor[indiceMenor])
					indiceMenor = j;
			}
			
			// troca do i-ésimo valor com o menor valor encontrado
			long aux = vetor[i];
			vetor[i] = vetor[indiceMenor];
			vetor[indiceMenor] = aux;
		}
		
		Instant fim = Instant.now();

		Duration duracao = Duration.between(inicio, fim);
		long duracaoEmMilissegundos = duracao.toMillis();
		return duracaoEmMilissegundos;
	}
}
