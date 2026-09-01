package com.matematicas.fisica.dinamica;

public class Dinamica {

	// Constante de gravedad estándar (m/s^2)
    private static final double GRAVEDAD = 9.81;

    /**
     * . Segunda Ley de Newton: Fuerza = masa * aceleración
     * @param masa en kg
     * @param aceleracion en m/s^2
     * @return Fuerza en Newtons (N)
     */
    public static double calcularFuerza(double masa, double aceleracion) {
        return masa * aceleracion;
    }

    /**
     * . Peso: P = masa * gravedad
     * @param masa en kg
     * @return Peso en Newtons (N)
     */
    public static double calcularPeso(double masa) {
        return masa * GRAVEDAD;
    }

    /**
     * . Fuerza de Fricción (Rozamiento): F_f = coeficiente * Normal
     * @param coeficienteFriccion coeficiente cinético o estático (adimencional)
     * @param normal fuerza normal en Newtons (N)
     * @return Fuerza de fricción en Newtons (N)
     */
    public static double calcularFuerzaFriccion(double coeficienteFriccion, double normal) {
        return coeficienteFriccion * normal;
    }

    /**
     * . Energía Cinética: Ec = 0.5 * masa * velocidad^2
     * @param masa en kg
     * @param velocidad en m/s
     * @return Energía cinética en Joules (J)
     */
    public static double calcularEnergiaCinetica(double masa, double velocidad) {
        return 0.5 * masa * Math.pow(velocidad, 2);
    }

    /**
     * . Energía Potencial Gravitatoria: Ep = masa * gravedad * altura
     * @param masa en kg
     * @param altura en metros (m)
     * @return Energía potencial en Joules (J)
     */
    public static double calcularEnergiaPotencial(double masa, double altura) {
        return masa * GRAVEDAD * altura;
    }

    /**
     * . Trabajo mecánico: W = Fuerza * distancia * cos(ángulo)
     * @param fuerza en Newtons (N)
     * @param distancia en metros (m)
     * @param anguloGrados ángulo de aplicación de la fuerza en grados
     * @return Trabajo en Joules (J)
     */
    public static double calcularTrabajo(double fuerza, double distancia, double anguloGrados) {
        double anguloRadianes = Math.toRadians(anguloGrados);
        return fuerza * distancia * Math.cos(anguloRadianes);
    }
}
