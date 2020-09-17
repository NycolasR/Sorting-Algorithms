package controllers;
import java.util.Arrays;
import java.util.UUID;

public class GeradorDeSequencias {

	public static long[] geradorUm(int t) {
		long[] v = new long[t];
		for(int i = 0; i < t; i++) {
			v[i] = 100000000000000l + (long)(Math.random()*900000000000000l);
		}
		return v;
	}
	
	public static  long[] geradorDois(int t) {
		long[] v = new long[t];
		for(int i = 0; i < t; i++) {
			v[i] = 100 + (long)(Math.random()*900);
		}
		return v;
	}

	public static  long[] geradorTres(int t) {
		long[] v = new long[t];
		for(int i = 0; i < t; i++) {
			v[i] = (long)(Math.random()*1000);
		}
		Arrays.sort(v);
		int f = (int) (t*0.1);
		while (f > 0) {
			int i = (int)(Math.random()*t);
			int j = (int)(Math.random()*t);
			trocar(v, i, j);
			f--;
		}
		
		return v;
	}

	public static  long[] geradorQuatro(int t) {
		long[] v = new long[t];
		for(int i = 0; i < t; i++) {
			v[i] = (long)(Math.random()*1000);
		}
		Arrays.sort(v);
		
		for(int i = 0, j = (int)Math.ceil(t/2); i < t/2; i++, j++) {
			trocar(v, i, j);
		}
		
		return v;
	}
	

	public static  long[] geradorCinco(int t) {
		long[] v = new long[t];
		for(int i = 0; i < t; i++) {
			v[i] = (long)(Math.random()*1000);
		}
		Arrays.sort(v);
		
		for(int i = 0; i < t/2; i++) {
			trocar(v, i, t-1-i);
		}
		
		return v;
	}
	
	
	public static  String[] geradorSeis(int t) {
		String[] v = new String[t];
		
		for(int i = 0; i < t; i++) {
			UUID uuid = UUID.randomUUID();
			String myRandom = uuid.toString();
			v[i] = myRandom.substring(0,20);		
		}
		return v;
	}
	
	public static  long[] geradorSete(int t) {
		long[] v = new long[t];
		for(int i = 0; i < t; i++) {
			v[i] = (long)(Math.random()*2);
		}
		return v;
	}
	public static  long[] geradorOito(int t) {
		long[] v = new long[t];
		long[] l = {0, Long.MAX_VALUE/2, Long.MAX_VALUE,};
		for(int i = 0; i < t; i++) {
			v[i] = l[(int)(Math.random()*3)];
		}
		return v;
	}

	public static String[] geradorNove(int t) {
		String[] v = new String[t];

		
		for(int i = 0; i < t; i++) {
			UUID uuid = UUID.randomUUID();
			String myRandom = uuid.toString();
			v[i] = myRandom.substring(0,5);		
		}
		Arrays.sort(v);
		int f = (int) (t*0.1);
		while (f > 0) {
			int i = (int)(Math.random()*t);
			int j = (int)(Math.random()*t);
			String aux = v[i];
			v[i]=v[j];
			v[j] = aux;
			f--;
		}
		
		return v;
	}
	
	
	private static void trocar(long[] v, int i, int j) {
		long aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(GeradorDeSequencias.geradorCinco(10)));
	}
	
}

