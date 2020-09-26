package algorithms;

import java.time.Duration;
import java.time.Instant;

public class FacadeAlgorithms {
	
	private SortingAlgorithm algoritmo;
	
	public SortingAlgorithm getAlgoritmo() {
		return algoritmo;
	}
	public void setAlgoritmo(SortingAlgorithm algoritmo) {
		this.algoritmo = algoritmo;
	}

	public long sort(long[] vetor) {
		return algoritmo.sort(vetor);
	}
	
	public long sortWithMerge(long[] array) {
		System.out.println("Merge Sort");
		Instant start = Instant.now();
		algoritmo.sortWithMerge(array, 0, array.length - 1);
		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
	
	public long sort(long[] vetor, boolean isPivotRandom) {
		if(isPivotRandom) {
			
			Instant inicio = Instant.now();
			algoritmo.sortRandomPivot(vetor, 0, vetor.length-1);
			Instant fim = Instant.now();

			Duration duracao = Duration.between(inicio, fim);
			long duracaoEmMilissegundos = duracao.toMillis();
			return duracaoEmMilissegundos;
		}
		
		Instant inicio = Instant.now();
		algoritmo.sortFirstElementPivot(vetor, 0, vetor.length-1);
		Instant fim = Instant.now();

		Duration duracao = Duration.between(inicio, fim);
		long duracaoEmMilissegundos = duracao.toMillis();
		return duracaoEmMilissegundos;
	}
	
	public long sortWithShell(long[] array, boolean isFirstWay) {
		return algoritmo.sort(array, isFirstWay);
	}
}


















