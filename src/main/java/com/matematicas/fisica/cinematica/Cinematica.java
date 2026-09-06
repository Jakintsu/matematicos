package com.matematicas.fisica.cinematica;

public class Cinematica {
	
	// Constante de aceleración de la gravedad (m/s^2)
    public static final double GRAVEDAD = 9.80665;

    // ==========================================
    // 1. MOVIMIENTO RECTILÍNEO UNIFORME (MRU)
    // ==========================================

    /**
     * Posición en MRU: x = x0 + v * t
     */
    public static double posicionMRU(double x0, double v, double t) {
        return x0 + (v * t);
    }

    /**
     * Velocidad media: v = (x - x0) / t
     */
    public static double velocidadMediaMRU(double x0, double x, double t) {
        if (t == 0) throw new IllegalArgumentException("El tiempo no puede ser cero.");
        return (x - x0) / t;
    }

    // ==========================================
    // 2. MOVIMIENTO UNIFORMEMENTE VARIADO (MRUV)
    // ==========================================

    /**
     * Velocidad final dada aceleración y tiempo: vf = v0 + a * t
     */
    public static double velocidadFinalMRUV(double v0, double a, double t) {
        return v0 + (a * t);
    }

    /**
     * Posición en MRUV: x = x0 + v0 * t + 0.5 * a * t^2
     */
    public static double posicionMRUV(double x0, double v0, double a, double t) {
        return x0 + (v0 * t) + (0.5 * a * Math.pow(t, 2));
    }

    /**
     * Velocidad final independiente del tiempo: vf^2 = v0^2 + 2 * a * (x - x0)
     */
    public static double velocidadFinalSinTiempoMRUV(double v0, double a, double deltaX) {
        double vfCuadrado = Math.pow(v0, 2) + (2 * a * deltaX);
        if (vfCuadrado < 0) {
            throw new ArithmeticException("Imposible calcular velocidad real: resultado negativo dentro de la raíz.");
        }
        return Math.sqrt(vfCuadrado);
    }

    /**
     * Aceleración promedio: a = (vf - v0) / t
     */
    public static double aceleracionMedia(double v0, double vf, double t) {
        if (t == 0) throw new IllegalArgumentException("El tiempo no puede ser cero.");
        return (vf - v0) / t;
    }

    // ==========================================
    // 3. CAÍDA LIBRE Y TIRO VERTICAL
    // ==========================================

    /**
     * Tiempo de caída libre desde reposo (v0=0): t = sqrt(2 * h / g)
     */
    public static double tiempoCaidaLibre(double altura) {
        if (altura < 0) throw new IllegalArgumentException("La altura no puede ser negativa.");
        return Math.sqrt((2 * altura) / GRAVEDAD);
    }

    /**
     * Altura máxima en tiro vertical hacia arriba: h_max = v0^2 / (2 * g)
     */
    public static double alturaMaximaTiroVertical(double v0) {
        return Math.pow(v0, 2) / (2 * GRAVEDAD);
    }

    // ==========================================
    // 4. TIRO PARABÓLICO (MOVIMIENTO 2D)
    // ==========================================

    /**
     * Alcance horizontal máximo (rango): R = (v0^2 * sin(2 * anguloRad)) / g
     * @param v0 Velocidad inicial (m/s)
     * @param anguloGrados Ángulo de lanzamiento en grados sexagesimales
     */
    public static double alcanceMaximoParabolico(double v0, double anguloGrados) {
        double rad = Math.toRadians(anguloGrados);
        return (Math.pow(v0, 2) * Math.sin(2 * rad)) / GRAVEDAD;
    }

    /**
     * Tiempo total de vuelo en terreno llano: t_vuelo = (2 * v0 * sin(anguloRad)) / g
     */
    public static double tiempoVueloParabolico(double v0, double anguloGrados) {
        double rad = Math.toRadians(anguloGrados);
        return (2 * v0 * Math.sin(rad)) / GRAVEDAD;
    }

    /**
     * Componentes de la velocidad inicial (Vx, Vy)
     * Retorna un array de dos elementos: [0] -> Vx, [1] -> Vy
     */
    public static double[] componentesVelocidad(double v0, double anguloGrados) {
        double rad = Math.toRadians(anguloGrados);
        double vx = v0 * Math.cos(rad);
        double vy = v0 * Math.sin(rad);
        return new double[]{vx, vy};
    }

}
