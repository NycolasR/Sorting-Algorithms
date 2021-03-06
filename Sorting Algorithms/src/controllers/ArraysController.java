package controllers;

import java.util.Arrays;

import algorithms.FacadeAlgorithms;

/**
 * @author Nyk
 *
 */
public class ArraysController {
	
	private FacadeAlgorithms facadeOrdenadores;
	
	public ArraysController(FacadeAlgorithms facadeOrdenadores) {
		this.facadeOrdenadores = facadeOrdenadores;
	}
	
	public double[] sort(long[][] arrays) {
		// [0 - 5]: tempos para ordenar cada array.
		// [6]: media dos 5 tempos
		double[] milliseconds = new double[6];
		
		// Somatória dos tempos
		double total = 0;
		
		for(int i = 0; i < arrays.length; i++) {	
			milliseconds[i] = facadeOrdenadores.sort(arrays[i]);
			total += milliseconds[i]; 
		}
		
		milliseconds[5] = total / 5;
		
		return milliseconds;
	}
	
	public double[] sortWithMerge(long[][] arrays) {
		// [0 - 5]: tempos para ordenar cada array.
		// [6]: media dos 5 tempos
		double[] milliseconds = new double[6];
		
		// Somatória dos tempos
		double total = 0;
		
		for(int i = 0; i < arrays.length; i++) {	
			milliseconds[i] = facadeOrdenadores.sortWithMerge(arrays[i]);
			total += milliseconds[i]; 
		}
		
		milliseconds[5] = total / 5;
		
		return milliseconds;
	}
	
	public double[] sortWithShell(long[][] arrays,  boolean isFirstWay) {
		// [0 - 5]: tempos para ordenar cada array.
		// [6]: media dos 5 tempos
		double[] milliseconds = new double[6];
				
		// Somatória dos tempos
		double total = 0;
				
		for(int i = 0; i < arrays.length; i++) {	
			milliseconds[i] = facadeOrdenadores.sortWithShell(arrays[i], isFirstWay);
			total += milliseconds[i]; 
		}
				
		milliseconds[5] = total / 5;
				
		return milliseconds;
	}
	
	public double[] sort(long[][] arrays, boolean isPivotRandom) {
		
		if (isPivotRandom)
			System.out.println("Quick Sort - Pivô aleatório ");
		else
			System.out.println("Quick Sort - Pivô 1º Elemento ");
		
		// [0 - 5]: tempos para ordenar cada array.
		// [6]: media dos 5 tempos
		double[] milliseconds = new double[6];
		
		// Somatória dos tempos
		double total = 0;
		
		for(int i = 0; i < arrays.length; i++) {	
			milliseconds[i] = facadeOrdenadores.sort(arrays[i], isPivotRandom);
			total += milliseconds[i]; 
		}
		
		milliseconds[5] = total / 5;
		
		return milliseconds;
	}
	
	public void showArrays(long[][] arrays) {
		for (int i = 0; i < arrays.length; i++) {			
			System.out.println(Arrays.toString(arrays[i]));
		}
	}
}
