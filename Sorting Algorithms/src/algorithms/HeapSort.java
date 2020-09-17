package algorithms;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Nyk
 *
 */
public class HeapSort implements SortingAlgorithm {

	public long sort(long[] vetor) {
		System.out.println("Heap Sort");
		Instant inicio = Instant.now();
		
		int f = vetor.length - 1;
		
		// Chamando o m�todo para cada um dos elementos que fazem
		// parte do vetor (de tr�s p/ a frente)
		for(int i = f; i >= 0; i--) {
			buildHeap(vetor, i, f);
		}
		
		while(f > 0) {
			
			// Troca-se o elemento raiz pelo �ltimo da Heap Tree
			long aux = vetor[f];
			vetor[f] = vetor[0];
			vetor[0] = aux;
			
			// Reorganizar a Heap Tree
			// f-- porque o �ltimo elemento j� est� ordenado
			buildHeap(vetor, 0, --f);
		}
		
		
		Instant fim = Instant.now();

		Duration duracao = Duration.between(inicio, fim);
		long duracaoEmMilissegundos = duracao.toMillis();
		return duracaoEmMilissegundos;
	}
	
	// Para organizar um vetor como uma Heap Tree
	public static void buildHeap(long[] vetor, int i, int f) {
		
		while(i <= f) {
			// Vari�vel para guardar o �ndice do elemento que
			// deve ser a raiz da Heap Tree
			int maior = i;
			
			// Posi��es dos filhos de i
			int e = 2*i+1;
			int d = 2*i+2;
			
			// Identificando qual dos tr�s � o maior
			if(e <= f && vetor[e] > vetor[maior]) {
				maior = e;
			}
			if(d <= f && vetor[d] > vetor[maior]) {
				maior = d;
			}
			
			// Se o maior ainda for i, n�o se troca os elementos
			if(maior != i) {
				long aux = vetor[maior];
				vetor[maior] = vetor[i];
				vetor[i] = aux;
				
				i = maior;
			} else {
				return;
			}
		}
	}
}
