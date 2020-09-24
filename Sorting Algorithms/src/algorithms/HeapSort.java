package algorithms;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Nyk
 *
 */
public class HeapSort extends SortingAlgorithm {
	
	@Override
	public long sort(long[] array) {
		System.out.println("Heap Sort");
		Instant start = Instant.now();
		
		int f = array.length - 1;
		
		// Chamando o método para cada um dos elementos que fazem
		// parte do vetor (de trás p/ a frente)
		for(int i = f; i >= 0; i--) {
			buildHeap(array, i, f);
		}
		
		while(f > 0) {
			
			// Troca-se o elemento raiz pelo último da Heap Tree
			long aux = array[f];
			array[f] = array[0];
			array[0] = aux;
			
			// Reorganizar a Heap Tree
			// f-- porque o último elemento já está ordenado
			buildHeap(array, 0, --f);
		}
		
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
	
	// Para organizar um vetor como uma Heap Tree
	public static void buildHeap(long[] array, int i, int f) {
		
		while(i <= f) {
			// Variável para guardar o índice do elemento que
			// deve ser a raiz da Heap Tree
			int maior = i;
			
			// Posições dos filhos de i
			int e = 2*i+1;
			int d = 2*i+2;
			
			// Identificando qual dos três é o maior
			if(e <= f && array[e] > array[maior]) {
				maior = e;
			}
			if(d <= f && array[d] > array[maior]) {
				maior = d;
			}
			
			// Se o maior ainda for i, não se troca os elementos
			if(maior != i) {
				long aux = array[maior];
				array[maior] = array[i];
				array[i] = aux;
				
				i = maior;
			} else {
				return;
			}
		}
	}
}
