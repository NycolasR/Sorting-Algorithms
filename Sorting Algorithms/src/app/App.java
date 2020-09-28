package app;

import java.util.Arrays;
import java.util.List;

import algorithms.*;
import controllers.ArraysController;
import controllers.GeradorDeSequencias;

public class App {

	public static void main(String[] args) {
		
		long[][] arraysLength50 = new long[5][];
		long[][] arraysLength100 = new long[5][];
		long[][] arraysLength500 = new long[5][];
		
		
		long[][] arraysLength1000 = new long[5][];
		long[][] arraysLength5000 = new long[5][];
		
		long[][] arraysLength10000 = new long[5][];
		long[][] arraysLength25000 = new long[5][];
		long[][] arraysLength50000 = new long[5][];
		long[][] arraysLength75000 = new long[5][];
		
		long[][] arraysLength100000 = new long[5][];
		long[][] arraysLength170000 = new long[5][];
		long[][] arraysLength250000 = new long[5][];

		for (int i = 0; i < arraysLength50.length; i++) {
			arraysLength50[i] = GeradorDeSequencias.geradorCinco(50);
			arraysLength100[i] = GeradorDeSequencias.geradorCinco(100);
			arraysLength500[i] = GeradorDeSequencias.geradorCinco(500);
			
			arraysLength1000[i] = GeradorDeSequencias.geradorCinco(1000);
			arraysLength5000[i] = GeradorDeSequencias.geradorCinco(5000);
			
			arraysLength10000[i] = GeradorDeSequencias.geradorCinco(10000);
			arraysLength25000[i] = GeradorDeSequencias.geradorCinco(25000);
			arraysLength50000[i] = GeradorDeSequencias.geradorCinco(50000);
			arraysLength75000[i] = GeradorDeSequencias.geradorCinco(75000);
			
			arraysLength100000[i] = GeradorDeSequencias.geradorCinco(100000);
			arraysLength170000[i] = GeradorDeSequencias.geradorCinco(170000);
			arraysLength250000[i] = GeradorDeSequencias.geradorCinco(250000);
		}
		
		FacadeAlgorithms facadeAlgorithms = new FacadeAlgorithms();
//		facadeAlgorithms.setAlgoritmo(new RadixSort());
		
		long s = System.currentTimeMillis();
		List[] aux = new List[10];
		System.out.println(System.currentTimeMillis() - s);
		
		ArraysController arraysController = new ArraysController(facadeAlgorithms);
		
//		long[] array = {11, 24, 12, 15, 78, 17, 95, 97, 55, 10, 99, 123};
		
//		MergeSort mg = new MergeSort();
//		mg.sortWithMerge(array, 0, array.length-1);
//		System.out.println(Arrays.toString(array));
		
//		arraysController.showArrays(arraysLength5000);
//		System.out.println();
		System.out.println(Arrays.toString(arraysController.sort(arraysLength250000)));
//		System.out.println();
//		arraysController.showArrays(arraysLength5000);
		
	}
}