package com.matematicas.matrices;

public class Matrices {
	
	public static void rellenarMatrizSecuencial1D(int[][] matriz) {
	    if (matriz == null) {
	        throw new IllegalArgumentException("Parametro no válido.");
	    }

	    int k = 0; // Se declara fuera para reflejar su ámbito global en la matriz

	    for (int i = 0; i < matriz.length; i++) {
	        // Validación adicional por si la fila es nula (matriz irregular)
	        if (matriz[i] == null) continue;

	        for (int j = 0; j < matriz[i].length; j++) {
	            matriz[i][j] = k;
	            k++;
	        }
	    }
	}
	public void rellenarMatrizSecuencia12D(int[][] matriz) {
	    // 1. Validar que la matriz no sea nula ni esté vacía (0 filas)
	    if (matriz == null || matriz.length == 0) {
	        throw new IllegalArgumentException("La matriz no puede ser nula ni estar vacía.");
	    }

	    // 2. Determinar el número máximo de columnas de forma segura
	    int maxColumnas = 0;
	    for (int[] fila : matriz) {
	        if (fila != null && fila.length > maxColumnas) {
	            maxColumnas = fila.length;
	        }
	    }

	    int k = 0; // Contador de la secuencia

	    // 3. Recorrido seguro por columnas
	    for (int j = 0; j < maxColumnas; j++) {
	        for (int i = 0; i < matriz.length; i++) {
	            // Validar que la fila existe y que la columna j está dentro del rango de esta fila
	            if (matriz[i] != null && j < matriz[i].length) {
	                matriz[i][j] = k++;
	            }
	        }
	    }
	    
	    
	}
	
	
	public static int[][] obtenerMatrizIdentidad(int dimension) {
	    if (dimension <= 0) {
	        throw new IllegalArgumentException("La dimensión debe ser un entero positivo mayor que cero. Valor recibido: " + dimension);
	    }

	    int[][] matriz = new int[dimension][dimension];

	    for (int i = 0; i < dimension; i++) {
	        matriz[i][i] = 1;
	    }

	    return matriz;
	}
	
	public static int[][] obtenerMatrizProducto(int[][] m1, int[][] m2) {
	    // 1. Validaciones básicas contra objetos nulos o matrices sin filas
	    if (m1 == null || m2 == null || m1.length == 0 || m2.length == 0) {
	        throw new IllegalArgumentException("Las matrices no pueden ser nulas ni estar vacías.");
	    }
	    
	    // 2. Comprobar que m1[0] y m2[0] no sean nulos antes de acceder a .length
	    if (m1[0] == null || m2[0] == null) {
	        throw new IllegalArgumentException("Las matrices contienen filas no inicializadas (null).");
	    }

	    int filasM1 = m1.length;
	    int colsM1 = m1[0].length;
	    int filasM2 = m2.length;
	    int colsM2 = m2[0].length;

	    // 3. Validación de la regla de dimensión para la multiplicación: cols(M1) == filas(M2)
	    if (colsM1 != filasM2) {
	        throw new IllegalArgumentException(
	            String.format("Dimensiones incompatibles para multiplicación: M1 tiene %d columnas y M2 tiene %d filas.", colsM1, filasM2)
	        );
	    }

	    int[][] matrizProducto = new int[filasM1][colsM2];

	    // 4. Optimización de bucles i - k - j (Cache-Friendly Loop Ordering)
	    for (int i = 0; i < filasM1; i++) {
	        for (int k = 0; k < colsM1; k++) {
	            int valorM1 = m1[i][k];
	            for (int j = 0; j < colsM2; j++) {
	                matrizProducto[i][j] += valorM1 * m2[k][j];
	            }
	        }
	    }

	    return matrizProducto;
	}
	
	// TRANSPUESTA DE UNA MATRIZ (Intercambia filas por columnas)
    public static double[][] transponer(double[][] a) {
        int filas = a.length;
        int columnas = a[0].length;
        double[][] resultado = new double[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[j][i] = a[i][j];
            }
        }
        return resultado;
    }
    
 //TRAZA DE UNA MATRIZ (Suma de la diagonal principal)
    public static double traza(double[][] a) {
        double suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i][i];
        }
        return suma;
    }
	
}
