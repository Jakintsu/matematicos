package com.matematicas.electricidad.estatica;

public class ElectroEstatica {
	// Constantes físicas fundamentales
    public static final double K_COULOMB = 8.9875517923e9; // N*m^2/C^2 (Constante de Coulomb)
    public static final double MU_0 = 4 * Math.PI * 1e-7;    // T*m/A (Permeabilidad magnética del vacío)

    // ==========================================
    // 1. FUNCIONES DE ELECTROESTÁTICA
    // ==========================================

    /**
     * Calcula la fuerza electrostática entre dos cargas puntuales (Ley de Coulomb).
     * @param q1 Carga 1 en Coulombs (C)
     * @param q2 Carga 2 en Coulombs (C)
     * @param r  Distancia entre las cargas en metros (m)
     * @return Fuerza en Newtons (N)
     */
    public static double coulombForce(double q1, double q2, double r) {
        if (r == 0) throw new IllegalArgumentException("La distancia no puede ser cero.");
        return K_COULOMB * Math.abs(q1 * q2) / (r * r);
    }

    /**
     * Calcula la magnitud del campo eléctrico generado por una carga puntual.
     * @param q Carga generadora en Coulombs (C)
     * @param r Distancia al punto en metros (m)
     * @return Campo eléctrico en N/C o V/m
     */
    public static double electricField(double q, double r) {
        if (r == 0) throw new IllegalArgumentException("La distancia no puede ser cero.");
        return K_COULOMB * Math.abs(q) / (r * r);
    }

    /**
     * Calcula el potencial eléctrico generado por una carga puntual a una distancia r.
     * @param q Carga en Coulombs (C)
     * @param r Distancia en metros (m)
     * @return Potencial eléctrico en Voltios (V)
     */
    public static double electricPotential(double q, double r) {
        if (r == 0) throw new IllegalArgumentException("La distancia no puede ser cero.");
        return K_COULOMB * q / r;
    }

}
