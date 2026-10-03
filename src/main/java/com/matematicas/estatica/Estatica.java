package com.matematicas.estatica;

public class Estatica {

	// Constante de aceleración de la gravedad estándar (m/s^2)
    public static final double GRAVEDAD_ESTANDAR = 9.81;

    // ==========================================
    // 1. ESTÁTICA DE SÓLIDOS (Mecánica)
    // ==========================================

    /**
     * Calcula la Fuerza de Fricción Estática Máxima.
     * F_s = mu_s * N
     * @ponente muS Coeficiente de fricción estática (sin unidades)
     * @ponente normal Fuerza normal (en Newtons)
     * @return Fuerza máxima de fricción estática (en Newtons)
     */
    public static double fuerzaFriccionEstaticaMax(double muS, double normal) {
        if (muS < 0 || normal < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos.");
        }
        return muS * normal;
    }

    /**
     * Calcula el Torque o Momento de una fuerza (caso perpendicular: tau = r * F * sin(theta)).
     * @param distanciaBrazo Distancia desde el eje de giro al punto de aplicación (en metros)
     * @param fuerza Magnitud de la fuerza aplicada (en Newtons)
     * @param anguloGrados Ángulo entre el vector distancia y la fuerza (en grados)
     * @return Torque (en Newton-metro, N*m)
     */
    public static double calcularTorque(double distanciaBrazo, double fuerza, double anguloGrados) {
        double radianes = Math.toRadians(anguloGrados);
        return distanciaBrazo * fuerza * Math.sin(radianes);
    }
}
