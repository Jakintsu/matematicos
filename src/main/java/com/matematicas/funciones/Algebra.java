package com.matematicas.funciones;

import java.util.Arrays;

public class Algebra {
	/*
	 * La notación ... significa que se espera un número
	 * arbitrario de paránetros (0 o más)
	 */
	public static int sumaTotal(int ... numeros) {
		
		int suma = 0;
		
		for(int num: numeros) {
			suma += num;
		}
		
		return suma;
	}
	 
	public static double mediaAritmetica(double ... numeros) {
		double suma = 0.0;
		
		for(double num: numeros) {
			suma += num;
		}
		
		return suma/numeros.length;
	}
	
	/*
     * Cálculo de la serie de Fibonacci (Recursivo).
     * Nota: Reservado para valores pequeños debido a su complejidad O(2^n).
     */
    public static int fibonacciRecursivo(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("El índice no puede ser negativo: " + pos);
        }
        if (pos == 0 || pos == 1) {
            return 1;
        }
        return fibonacciRecursivo(pos - 1) + fibonacciRecursivo(pos - 2);
    }

    /*
     * Cálculo de la serie de Fibonacci (Iterativo O(n)).
     */
    public static int fibonacciIterativo(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("El índice no puede ser negativo: " + pos);
        }

        int ultimo = 1, penultimo = 1, respuesta = 1;

        for (int n = 1; n < pos; n++) {
            respuesta = ultimo + penultimo;
            penultimo = ultimo;
            ultimo = respuesta;
        }

        return respuesta;
    }
    
    public static boolean esPrimo(int numero) {
        // Caso base: números menores o iguales a 1 no son primos
        if (numero <= 1) {
            return false;
        }
        // El 2 y el 3 son primos
        if (numero <= 3) {
            return true;
        }
        // Elimina todos los pares mayores que 2 y los múltiplos de 3
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }

        // Comprueba solo impares con el paso de 6 (6k ± 1)
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    
    public static void ordenarTernaNumeros(double a, double b, double c) {
    	double temporal;
    	
    	if(a>b) {
    		temporal = a;
    		a=b;
    		b = temporal;
    	}
    	
    	if(a>c) {
    		temporal = a;
    		a = c;
    		c = temporal;
    			
    	}
    	
    	if(b>c) {
    		temporal = b;
    		b = c;
    		c = temporal;
    		
    	}
    }
    /*
     * Devuelve terna ordenada
     */
    public static double[] ordenarTerna(double a, double b, double c) {
        // Math.min y Math.max evitan tener que hacer intercambios manuales con variables temporales
        double minimo = Math.min(a, Math.min(b, c));
        double maximo = Math.max(a, Math.max(b, c));
        double medio = (a + b + c) - minimo - maximo; // El sobrante es el valor central

        return new double[]{minimo, medio, maximo};
    }
    
    /*
     * Método para calcular la potencia (casi equivalente a Math.pow
     */
    
    public static  double potencia(double a, int b) {
    	double resultado = 1;
    	
    	if(a == 0) {
    		if(b == 0) {
    			resultado = 1;
    	}else if(b<0) {
    		resultado = Double.POSITIVE_INFINITY;
    	}else {
    		resultado = 0;
    	}
    	}else if(b == 0) {
    		resultado = 1;
    	}else if(b<0) {
    		for(int i = 0; i < -b; i++)
    			resultado*=a;
    		resultado = 1/resultado;
    	}else {
    		for(int i = 0; i < b; i++)
    			resultado*=a;
    	}
    	
    	return resultado;
    	
    }
    
    public static double potenciaMejorado(double a, int b) {
        // Caso especial: indeterminación 0^0 convencionalmente devuelve 1.0
        if (a == 0 && b == 0) {
            return 1.0;
        }
        
        long exp = b; // Evita desbordamiento de entero si b == Integer.MIN_VALUE al cambiar de signo
        if (exp < 0) {
            a = 1.0 / a;
            exp = -exp;
        }

        double resultado = 1.0;
        while (exp > 0) {
            // Si el exponente actual es impar, acumula la base
            if ((exp & 1) == 1) {
                resultado *= a;
            }
            a *= a;      // Eleva la base al cuadrado
            exp >>= 1;   // Divide el exponente entre 2 (desplazamiento de bits)
        }

        return resultado;
    }
    /**
     * Aunque no se comprueba que los factores sean primos. Se divide por
     * todos los números crecientemente, de esa forma, si el factor no es primo,
     * ya se habrá factorizado por uno de sus factores el número, por lo que en realidad
     * nunca será divisible por un número no primo
     * @param numeroInicial
     */
    public static void factoresPrimos(long numeroInicial) {
    	if(numeroInicial > 1) {
    		int factorPrimo = 2;
    		long numero = 0;
    		numero = numeroInicial;
    		
    		while(factorPrimo <= numero) {
    			if(numero % factorPrimo == 0) {
    				numero /= factorPrimo;
    				System.out.print(factorPrimo + " * ");
    			}else {
    				//Si ya hemos probado con el 2, saltamos de dos en dos para probar
    				//con los impares
    				factorPrimo  = (factorPrimo == 2)?3:factorPrimo+2;
    			}
    		}
    		//Imprimimos el último factor sobrante
    		if(numero>1) {
    			System.out.print(numero);
    		}
    		System.out.println();
    	}else {
    		System.out.println("El numero debde ser mayor a 1");
    	}
    }
    
    
   /**
    * Usamos setAll, más eficiente que ir rellenando valores con un bucle
    * @param arr
    */

    public static  void completarconPares(int[] arr) {
        if (arr == null) return;

        Arrays.setAll(arr, i -> i * 2);
    }
    
    public long sumaElementosArray(int[] arr) {
        if (arr == null) return 0; // Protege contra NullPointerException

        long suma = 0; // Cambiado a long para evitar overflow
        for (int num : arr) {
            suma += num;
        }
        return suma;
    }
    
  
    /**
     * Si el número es muy elevado, puede producir un overflow
     * @param numPotencias
     * @return
     */
    public int[] arrayPotencias2(int numPotencias) {
        if (numPotencias <= 0) return new int[0];

        int[] potencias2 = new int[numPotencias];
        Arrays.setAll(potencias2, i -> 1 << i);
        return potencias2;
    }
    
    public int[] arrayMultiplicado(int[] arr, int factor) {
        if (arr == null) return new int[0];

        return Arrays.stream(arr)
                     .map(x -> x * factor)
                     .toArray();
    }
    
    public static long mcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // . MCM de dos números: (a * b) / mcd(a, b)
    // Se divide primero para evitar desbordamiento de entero (overflow)
    public static long mcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a) * (Math.abs(b) / mcd(a, b));
    }

    // MCD de VARIOS números (usando varargs)
    public static long mcdVarios(long... numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("Debe proporcionar al menos un número.");
        }
        long resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            resultado = mcd(resultado, numeros[i]);
            if (resultado == 1) break; // Optimización: Si el MCD llega a 1, no va a bajar más
        }
        return resultado;
    }
}