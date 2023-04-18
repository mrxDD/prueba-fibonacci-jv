package uy.jv.prueba.Fibonacci;


public class Fibonacci {

	// se calcula numero fibonacci
	public static int getFib (Integer n) {

		if (n == null) {
			return 0;
		}

		else if (n <= 1)  {
			return n;
		} 
		
		return getFib(n - 1) + getFib(n - 2);
	}

}
