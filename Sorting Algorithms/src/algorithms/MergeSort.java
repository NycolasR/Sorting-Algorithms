package algorithms;

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

	public void merge(long array[], int left, int middle, int right) { 
        // Obtendo o tamanho dos subarrays a serem intercalados 
        int n1 = middle - left + 1; 
        int n2 = right - middle; 
  
        // Criação dos arrays temporários
        long Left[] = new long[n1]; 
        long Right[] = new long[n2]; 
  
        // Respectivos valores copiados para os arrays temporários
        for (int i = 0; i < n1; ++i) 
            Left[i] = array[left + i]; 
        for (int j = 0; j < n2; ++j) 
            Right[j] = array[middle + 1 + j];
        
        /* Intercalando os arrays temporários */
        // Indices iniciais do primeiro e segundo subarrays 
        int i = 0, j = 0; 
  
        // Indicice inicial do array intercalado 
        int k = left; 
        while (i < n1 && j < n2) { 
            if (Left[i] <= Right[j]) { 
                array[k] = Left[i]; 
                i++; 
            } else { 
                array[k] = Right[j]; 
                j++; 
            } 
            k++; 
        } 
  
        // Copia dos elementos restantes de Left[] se existirem
        while (i < n1) { 
            array[k] = Left[i]; 
            i++; 
            k++; 
        } 
  
        // Copia dos elementos restantes de Right[] se existirem
        while (j < n2) { 
            array[k] = Right[j]; 
            j++; 
            k++; 
        }
    }




//	private long[] merge(long[] array, int start, int middle, int end) {
//		long s = System.currentTimeMillis();
//		long[] arrayAux = Arrays.copyOf(array, array.length);
//		System.out.println(System.currentTimeMillis() - s);
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
