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
	
	public long[] sort(long[][] arrays) {
		// [0 - 5]: tempos para ordenar cada array.
		// [6]: média dos 5 tempos
		long[] milliseconds = new long[6];
		
		// Somatória dos tempos
		long total = 0;
		
		for(int i = 0; i < arrays.length; i++) {	
			milliseconds[i] = facadeOrdenadores.sort(arrays[i]);
			total += milliseconds[i]; 
		}
		
		milliseconds[5] = total / 5;
		
		return milliseconds;
	}
	
	public double[] sort(long[][] arrays, boolean isPivotRandom) {
		// [0 - 5]: tempos para ordenar cada array.
		// [6]: média dos 5 tempos
		double[] milliseconds = new double[6];
		
		// Somatória dos tempos
		double total = 0;
		
		for(int i = 0; i < arrays.length; i++) {	
			milliseconds[i] = facadeOrdenadores.sort(arrays[i], 0, arrays[i].length - 1, isPivotRandom);
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
