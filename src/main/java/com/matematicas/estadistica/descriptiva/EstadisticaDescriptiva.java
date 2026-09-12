package com.matematicas.estadistica.descriptiva;

import java.util.Arrays;

public class EstadisticaDescriptiva {
	
	public static double media(double[] datos) {
        double suma = 0.0;
        for (double d : datos) {
            suma += d;
        }
        return suma / datos.length;
    }

    public static double mediana(double[] datos) {
        double[] copia = datos.clone();
        Arrays.sort(copia);
        int n = copia.length;
        if (n % 2 == 0) {
            return (copia[n / 2 - 1] + copia[n / 2]) / 2.0;
        } else {
            return copia[n / 2];
        }
    }

    public static double varianza(double[] datos) {
        double m = media(datos);
        double sumaCuadrados = 0.0;
        for (double d : datos) {
            sumaCuadrados += Math.pow(d - m, 2);
        }
        return sumaCuadrados / (datos.length - 1); // Varianza muestral (n - 1)
    }

    public static double desviacionEstandar(double[] datos) {
        return Math.sqrt(varianza(datos));
    }

    public static double covarianza(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los vectores deben tener la misma longitud.");
        }
        double mediaX = media(x);
        double mediaY = media(y);
        double suma = 0.0;
        for (int i = 0; i < x.length; i++) {
            suma += (x[i] - mediaX) * (y[i] - mediaY);
        }
        return suma / (x.length - 1);
    }

    /**
     * Calcula la asimetría muestral ajustada (Fisher-Pearson tipo G1 con corrección de sesgo).
     */
    public static double asimetria(double[] datos) {
        int n = datos.length;
        if (n < 3) {
            throw new IllegalArgumentException("Se requieren al menos 3 datos para calcular la asimetría.");
        }
        double m = media(datos);
        double s = desviacionEstandar(datos);
        
        double sumaCubos = 0.0;
        for (double d : datos) {
            sumaCubos += Math.pow((d - m) / s, 3);
        }
        
        // Factor de corrección para muestras finitas
        double factor = (n * 1.0) / ((n - 1) * (n - 2));
        return factor * sumaCubos;
    }

    /**
     * Calcula la curtosis muestral en exceso (el valor para una distribución normal es 0).
     */
    public static double curtosisEnExceso(double[] datos) {
        int n = datos.length;
        if (n < 4) {
            throw new IllegalArgumentException("Se requieren al menos 4 datos para calcular la curtosis.");
        }
        double m = media(datos);
        double s = desviacionEstandar(datos);
        
        double sumaCuartas = 0.0;
        for (double d : datos) {
            sumaCuartas += Math.pow((d - m) / s, 4);
        }
        
        // Fórmula de corrección insesgada para muestras finitas (tipo G2)
        double term1 = ((n * (n + 1.0)) / ((n - 1) * (n - 2) * (n - 3))) * sumaCubosOInutil(sumaCuartas); // se ajusta con factores de Fisher
        // Aplicando la fórmula exacta de exceso de curtosis muestral:
        double factor1 = (n - 1.0) / ((n - 2) * (n - 3));
        double factor2 = ((3.0 * Math.pow(n - 1, 2)) / ((n - 2) * (n - 3)));
        
        // Versión estándar utilizada en librerías científicas (como Apache Commons Math / R):
        double sum4 = 0.0;
        for (double d : datos) {
            sum4 += Math.pow(d - m, 4);
        }
        double sum2 = 0.0;
        for (double d : datos) {
            sum2 += Math.pow(d - m, 2);
        }
        
        double c1 = (n * (n + 1.0) / ((n - 1.0) * (n - 2) * (n - 3))) * (sum4 / Math.pow(sum2 / n, 2));
        double c2 = (3.0 * Math.pow(n - 1.0, 2)) / ((n - 2) * (n - 3));
        
        return c1 - c2;
    }
    
    // Método auxiliar nombrado para claridad dentro del ejemplo de suma de cuartas potencias
    private static double sumaCubosOInutil(double val) {
        return val;
    }

}
