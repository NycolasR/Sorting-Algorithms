package algorithms;

import java.time.Duration;
import java.time.Instant;

public class FacadeAlgorithms {
	
	private SortingAlgorithm algoritmo;
	private RecursiveSortingAlgorithm algoritmoRecursivo;
	
	public SortingAlgorithm getAlgoritmo() {
		return algoritmo;
	}
	public void setAlgoritmo(SortingAlgorithm algoritmo) {
		this.algoritmo = algoritmo;
	}

	public RecursiveSortingAlgorithm getAlgoritmoRecursivo() {
		return algoritmoRecursivo;
	}
	public void setAlgoritmoRecursivo(RecursiveSortingAlgorithm algoritmoRecursivo) {
		this.algoritmoRecursivo = algoritmoRecursivo;
	}

	public long sort(long[] vetor) {
		return algoritmo.sort(vetor);
	}
	
	public long sort(long[] vetor, boolean isPivotRandom) {
		if(isPivotRandom) {
			
			Instant inicio = Instant.now();
			algoritmoRecursivo.sortRandomPivot(vetor, 0, vetor.length-1);
			Instant fim = Instant.now();

			Duration duracao = Duration.between(inicio, fim);
			long duracaoEmMilissegundos = duracao.toMillis();
			return duracaoEmMilissegundos;
		}
		
		Instant inicio = Instant.now();
		algoritmoRecursivo.sortFirstElementPivot(vetor, 0, vetor.length-1);
		Instant fim = Instant.now();

		Duration duracao = Duration.between(inicio, fim);
		long duracaoEmMilissegundos = duracao.toMillis();
		return duracaoEmMilissegundos;
	}
}
