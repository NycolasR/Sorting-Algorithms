package algorithms;

public class MergeSort extends SortingAlgorithm {
	@Override
	public long sort(long[] array, int i, int m, int f) {
		return super.sort(array);
	}
	
	private long[] merge(long[] array1, long[] array2) {
		long[] array = new long[array1.length + array2.length];
		
		int i = 0;
		int j = 0;
		int pos = 0;
		
		// i = varável de controle para posições do array1
		// j = varável de controle para posições do array2
		while(i < array1.length && j < array2.length) {
			if(array1[i] < array2[j]) {
				array[pos] = array1[i];
				i++;
			} else {
				array[pos] = array2[j];
				j++;
			}
			
			pos++;
		}
		
		// Caso ainda existam elementos não posicionados em um dos arrays,
		// todo o restante do array deve ser adicionado ao array resultante
		while(i < array1.length) 
			array[pos++] = array1[i++];
		while(j < array2.length)
			array[pos++] = array2[j++];
		
		return array;
	}
}
