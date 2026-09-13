package com.matematicas.combinatoria;

public class Combinatoria {

	// Función auxiliar para calcular el factorial
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("El número no puede ser negativo.");
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // 1. Permutaciones sin repetición: P(n) = n!
    public static long permutaciones(int n) {
        return factorial(n);
    }

    // 2. Variaciones sin repetición: V(n, k) = n! / (n - k)!
    public static long variaciones(int n, int k) {
        if (k > n || k < 0) return 0;
        long resultado = 1;
        for (int i = 0; i < k; i++) {
            resultado *= (n - i);
        }
        return resultado;
    }

    // 3. Variaciones con repetición: VR(n, k) = n^k
    public static long variacionesConRepeticion(int n, int k) {
        return (long) Math.pow(n, k);
    }

    // 4. Combinaciones sin repetición: C(n, k) = n! / (k! * (n - k)!)
    public static long combinaciones(int n, int k) {
        if (k > n || k < 0) return 0;
        if (k > n - k) {
            k = n - k; // Propiedad de simetría para optimizar
        }
        long numerador = 1;
        long denominador = 1;
        for (int i = 1; i <= k; i++) {
            numerador *= (n - k + i);
            denominador *= i;
        }
        return numerador / denominador;
    }

    // 5. Combinaciones con repetición: CR(n, k) = C(n + k - 1, k)
    public static long combinacionesConRepeticion(int n, int k) {
        return combinaciones(n + k - 1, k);
    }
}
