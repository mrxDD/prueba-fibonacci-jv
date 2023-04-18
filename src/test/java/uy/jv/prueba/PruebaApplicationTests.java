package uy.jv.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import uy.jv.prueba.Fibonacci.Fibonacci;


@SpringBootTest
class PruebaApplicationTests {

	// Se testea si el metodo que calcula un numero fibonacci es correcto para los valores del 0 al 10

	@Test
    public void testFibonacciResult() {

		int[] fiboNumbers= new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55} ;

		for (int i = 0; i <= 10; i++) {

			assertEquals(fiboNumbers[i], Fibonacci.getFib(i));
			
    	}

	}

	// Se testea que la funcion no retorne null en el caso de que se pase un valor no instanciado
	@Test
    public void FibonacciValueNotNull() {

		assertNotNull(Fibonacci.getFib(null), "No es null");

	}

}
