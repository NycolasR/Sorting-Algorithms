package algorithms;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Nyk
 *
 */
public class HeapSort implements AlgoritmoDeOrdenacao {

	public long sort(long[] vetor) {
		System.out.println("Heap Sort");
		Instant inicio = Instant.now();
		
		int f = vetor.length - 1;
		
		// Chamando o método para cada um dos elementos que fazem
		// parte do vetor (de trás p/ a frente)
		for(int i = f; i >= 0; i--) {
			buildHeap(vetor, i, f);
		}
		
		while(f > 0) {
			
			// Troca-se o elemento raiz pelo último da Heap Tree
			long aux = vetor[f];
			vetor[f] = vetor[0];
			vetor[0] = aux;
			
			// Reorganizar a Heap Tree
			// f-- porque o último elemento já está ordenado
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
			// Variável para guardar o índice do elemento que
			// deve ser a raiz da Heap Tree
			int maior = i;
			
			// Posições dos filhos de i
			int e = 2*i+1;
			int d = 2*i+2;
			
			// Identificando qual dos três é o maior
			if(e <= f && vetor[e] > vetor[maior]) {
				maior = e;
			}
			if(d <= f && vetor[d] > vetor[maior]) {
				maior = d;
			}
			
			// Se o maior ainda for i, não se troca os elementos
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
