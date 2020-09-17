package algorithms;

import java.time.Duration;
import java.time.Instant;

public class FacadeAlgorithms {
	
	private AlgoritmoDeOrdenacao algoritmo;
	private AlgoritmoDeOrdenacaoRecursivo algoritmoRecursivo;
	
	public AlgoritmoDeOrdenacao getAlgoritmo() {
		return algoritmo;
	}
	public void setAlgoritmo(AlgoritmoDeOrdenacao algoritmo) {
		this.algoritmo = algoritmo;
	}

	public AlgoritmoDeOrdenacaoRecursivo getAlgoritmoRecursivo() {
		return algoritmoRecursivo;
	}
	public void setAlgoritmoRecursivo(AlgoritmoDeOrdenacaoRecursivo algoritmoRecursivo) {
		this.algoritmoRecursivo = algoritmoRecursivo;
	}

	public long sort(long[] vetor) {
		return algoritmo.sort(vetor);
	}
	
	public long sort(long[] vetor, int i, int f, boolean isPivotRandom) {
		if(isPivotRandom) {
			
			Instant inicio = Instant.now();
			algoritmoRecursivo.sortRandomPivot(vetor, i, f);
			Instant fim = Instant.now();

			Duration duracao = Duration.between(inicio, fim);
			long duracaoEmMilissegundos = duracao.toMillis();
			return duracaoEmMilissegundos;
		}
		
		Instant inicio = Instant.now();
		algoritmoRecursivo.sortFirstElementPivot(vetor, i, f);
		Instant fim = Instant.now();

		Duration duracao = Duration.between(inicio, fim);
		long duracaoEmMilissegundos = duracao.toMillis();
		return duracaoEmMilissegundos;
	}
}
