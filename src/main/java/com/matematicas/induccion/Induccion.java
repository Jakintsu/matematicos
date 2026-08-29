package com.matematicas.induccion;

/**
 * Paquete con formulas demostradas por inducción matemática
 */

public class Induccion {
	/**
     * Aqui aplicamos la fórmula de inducción matemática, considerando a 0 como
     * número par. La suma de los n primeros pares,comenzado por 0 es n*(n-1)
     * @param n
     * @return
     */
    public static long sumaPares(long n) {
    	if (n <= 0) {
            return 0; 
        }
        
        return n * (n - 1);
    }
   
    /**
     * Lo mismo que en el caso anterior, usamos la inducción matemática, que 
     * nos dice que la suma de los n primeros impares, comenzando por 1 es n al cuadrado
     * @param n
     * @return
     */
    public static long sumaImpares(long n) {
        if (n <= 0) {
            return 0; 
        }
        
        return n * n;
    }
    
    public static long sumaNaturales(long n) {
        return (n <= 0) ? 0 : n * (n + 1) / 2;
    }
    
    public static long sumaCuadrados(long n) {
        return (n <= 0) ? 0 : n * (n + 1) * (2 * n + 1) / 6;
    }
    
    public static long sumaCubos(long n) {
        if (n <= 0) return 0;
        long sumaBase = n * (n + 1) / 2;
        return sumaBase * sumaBase;
    }
    
    public static double sumaProgresionGeometrica(double a, double r, int n) {
        if (n <= 0) return 0;
        if (r == 1) return a * n; // Evita división por cero si r = 1
        return a * (Math.pow(r, n) - 1) / (r - 1);
    }
}
