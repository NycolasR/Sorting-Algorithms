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
	
	private void merge(long arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        long L[] = new long[n1]; 
        long R[] = new long[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
	
//	private long[] merge(long[] array, int start, int middle, int end) {
//		long[] arrayAux = Arrays.copyOf(array, array.length);
//		
//		int i = start;
//		int j = middle + 1;
//		int pos = i;
//		
//		// i = varável de controle para posições do array1
//		// j = varável de controle para posições do array2
//		while(i <= middle && j <= end) {
//			if(arrayAux[i] < arrayAux[j]) {
//				array[pos] = arrayAux[i];
//				i++;
//			} else {
//				array[pos] = arrayAux[j];
//				j++;
//			}
//			
//			pos++;
//		}
//		
//		// Caso ainda existam elementos não posicionados em um dos arrays,
//		// todo o restante do array deve ser adicionado ao array resultante
//		while(i <= middle) 
//			array[pos++] = arrayAux[i++];
//		while(j < end)
//			array[pos++] = arrayAux[j++];
//		
//		return array;
//	}
}
