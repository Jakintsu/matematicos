package com.matematicas.electricidad.magnetismo;

public class Magnetismo {
	
	/**
     * Calcula la fuerza magnética sobre una carga en movimiento (Fuerza de Lorentz).
     * @param q     Carga en Coulombs (C)
     * @param v     Velocidad de la carga en m/s
     * @param b     Magnitud del campo magnético en Teslas (T)
     * @param angle Ángulo entre el vector velocidad y el campo magnético (en grados)
     * @return Fuerza magnética en Newtons (N)
     */
    public static double magneticForceOnCharge(double q, double v, double b, double angle) {
        double angleRad = Math.toRadians(angle);
        return Math.abs(q) * v * b * Math.sin(angleRad);
    }

    /**
     * Calcula el campo magnético a una distancia r de un hilo conductor rectilíneo muy largo.
     * @param current Corriente eléctrica en Amperios (A)
     * @param r       Distancia radial al hilo en metros (m)
     * @return Campo magnético en Teslas (T)
     */
    public static double magneticFieldLongWire(double current, double r) {
        if (r == 0) throw new IllegalArgumentException("La distancia no puede ser cero.");
        return (MU_0 * current) / (2 * Math.PI * r);
    }

    /**
     * Calcula la fuerza magnética sobre un conductor rectilíneo por el que circula corriente.
     * @param current Corriente en Amperios (A)
     * @param length  Longitud del conductor en el campo en metros (m)
     * @param b       Campo magnético en Teslas (T)
     * @param angle   Ángulo entre la corriente y el campo magnético (en grados)
     * @return Fuerza en Newtons (N)
     */
    public static double magneticForceOnConductor(double current, double length, double b, double angle) {
        double angleRad = Math.toRadians(angle);
        return current * length * b * Math.sin(angleRad);
    }

}
