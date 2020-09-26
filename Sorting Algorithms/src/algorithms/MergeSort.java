package algorithms;

import java.util.Arrays;

public class MergeSort extends SortingAlgorithm {
	@Override
	public void sortWithMerge(long[] array, int i, int f) {
		
		if(i < f) {
			int middle = (i + f) / 2;
			sortWithMerge(array, i, middle);
			sortWithMerge(array, middle+1, f);
			merge(array, i, middle, f);
		}
		
	}
	
	private long[] merge(long[] array, int start, int middle, int end) {
		long[] arrayAux = Arrays.copyOf(array, array.length);
		
		int i = start;
		int j = middle + 1;
		int pos = i;
		
		// i = varável de controle para posições do array1
		// j = varável de controle para posições do array2
		while(i <= middle && j <= end) {
			if(arrayAux[i] < arrayAux[j]) {
				array[pos] = arrayAux[i];
				i++;
			} else {
				array[pos] = arrayAux[j];
				j++;
			}
			
			pos++;
		}
		
		// Caso ainda existam elementos não posicionados em um dos arrays,
		// todo o restante do array deve ser adicionado ao array resultante
		while(i <= middle) 
			array[pos++] = arrayAux[i++];
		while(j < end)
			array[pos++] = arrayAux[j++];
		
		return array;
	}
}
