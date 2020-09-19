package app;

import java.util.Arrays;

import algorithms.*;
import controllers.ArraysController;
import controllers.GeradorDeSequencias;

public class App {

	public static void main(String[] args) {
		
		long[][] arraysLength50 = new long[5][];
		long[][] arraysLength100 = new long[5][];
		long[][] arraysLength1000 = new long[5][];
		long[][] arraysLength10000 = new long[5][];
		long[][] arraysLength100000 = new long[5][];

		for (int i = 0; i < arraysLength50.length; i++) {
			arraysLength50[i] = GeradorDeSequencias.geradorCinco(50);
			arraysLength100[i] = GeradorDeSequencias.geradorCinco(100);
			arraysLength1000[i] = GeradorDeSequencias.geradorCinco(1000);
			arraysLength10000[i] = GeradorDeSequencias.geradorCinco(10000);
			arraysLength100000[i] = GeradorDeSequencias.geradorCinco(100000);
		}
		
		FacadeAlgorithms facadeAlgorithms = new FacadeAlgorithms();
		facadeAlgorithms.setAlgoritmoRecursivo(new QuickSort());
		facadeAlgorithms.setAlgoritmo(new HeapSort());
		
		ArraysController arraysController = new ArraysController(facadeAlgorithms);
		
		/*
		 * long[] array1 = GeradorDeSequencias.geradorCinco(1000000);
		 * System.out.println(facadeAlgorithms.sort(array1, true));
		 * 
		 * long[] array2 = GeradorDeSequencias.geradorCinco(1000000);
		 *System.out.println(facadeAlgorithms.sort(array2));
		 */
		
		//arraysController.showArrays(arraysLength100000);
		//System.out.println();
		System.out.println(Arrays.toString(arraysController.sort(arraysLength100000)));
		//System.out.println();
		//arraysController.showArrays(arraysLength10000);
	}
}