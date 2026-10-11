package com.matematicas.optica;

public class Optica {
	
	// ==========================================
    // CONSTANTES FÍSICAS
    // ==========================================
    public static final double VELOCIDAD_LUZ = 299792458.0; // m/s (c)
    public static final double CONSTANTE_PLANCK = 6.62607015e-34; // J·s (h)
    public static final double INDICE_REFRACCION_VACIO = 1.0;
    public static final double INDICE_REFRACCION_AIRE = 1.000293;

    // ==========================================
    // FÓRMULAS DE ÓPTICA GEOMÉTRICA
    // ==========================================

    /**
     * 1. Ley de Snell (Refracción)
     * n1 * sin(theta1) = n2 * sin(theta2)
     * @param n1 Índice de refracción del medio 1
     * @param n2 Índice de refracción del medio 2
     * @param anguloIncidenciaGrados Ángulo de incidencia en grados
     * @return Ángulo de refracción en grados
     */
    public static double leyDeSnell(double n1, double n2, double anguloIncidenciaGrados) {
        double theta1Rad = Math.toRadians(anguloIncidenciaGrados);
        double sinTheta2 = (n1 * Math.sin(theta1Rad)) / n2;
        
        if (sinTheta2 > 1.0 || sinTheta2 < -1.0) {
            throw new IllegalArgumentException("Reflexión total interna: el ángulo excede el límite crítico.");
        }
        
        return Math.toDegrees(Math.asin(sinTheta2));
    }

    /**
     * 2. Ecuación de las lentes delgadas / espejos esféricos
     * 1/f = 1/do + 1/di
     * Calcula la distancia focal (f) conociendo la distancia del objeto y de la imagen.
     */
    public static double calcularDistanciaFocal(double distanciaObjeto, double distanciaImagen) {
        return 1.0 / ((1.0 / distanciaObjeto) + (1.0 / distanciaImagen));
    }

    /**
     * Calcula la distancia de la imagen (di) conociendo la focal y la distancia del objeto.
     */
    public static double calcularDistanciaImagen(double focal, double distanciaObjeto) {
        return 1.0 / ((1.0 / focal) - (1.0 / distanciaObjeto));
    }

    /**
     * 3. Aumento lateral (magnificación)
     * m = -di / do  (o bien hi / ho)
     */
    public static double calcularAumentoLateral(double distanciaImagen, double distanciaObjeto) {
        return -distanciaImagen / distanciaObjeto;
    }

    // ==========================================
    // FÓRMULAS DE ÓPTICA ONDULATORIA Y FÓTONICA
    // ==========================================

    /**
     * 4. Índice de refracción a partir de la velocidad de la luz en el medio
     * n = c / v
     * @param velocidadEnMedio Velocidad de la luz en el medio (m/s)
     */
    public static double calcularIndiceRefraccion(double velocidadEnMedio) {
        if (velocidadEnMedio <= 0 || velocidadEnMedio > VELOCIDAD_LUZ) {
            throw new IllegalArgumentException("La velocidad debe ser mayor a 0 y menor o igual que la velocidad de la luz.");
        }
        return VELOCIDAD_LUZ / velocidadEnMedio;
    }

    /**
     * 5. Energía de un fotón por frecuencia
     * E = h * f
     * @param frecuencia Frecuencia en Hertz (Hz)
     * @return Energía en Joules (J)
     */
    public static double energiaFotonPorFrecuencia(double frecuencia) {
        return CONSTANTE_PLANCK * frecuencia;
    }

    /**
     * 6. Energía de un fotón por longitud de onda
     * E = (h * c) / lambda
     * @param longitudOndaMetros Longitud de onda en metros (m)
     * @return Energía en Joules (J)
     */
    public static double energiaFotonPorLongitudOnda(double longitudOndaMetros) {
        if (longitudOndaMetros <= 0) {
            throw new IllegalArgumentException("La longitud de onda debe ser mayor a 0.");
        }
        return (CONSTANTE_PLANCK * VELOCIDAD_LUZ) / longitudOndaMetros;
    }

    /**
     * 7. Ley de Malus (Polarización de la luz)
     * I = I0 * cos^2(theta)
     * @param intensidadInicial Intensidad inicial (I0)
     * @param anguloGrados Ángulo entre los ejes de polarización en grados
     * @return Intensidad resultante (I)
     */
    public static double leyDeMalus(double intensidadInicial, double anguloGrados) {
        double rad = Math.toRadians(anguloGrados);
        return intensidadInicial * Math.pow(Math.cos(rad), 2);
    }

}
