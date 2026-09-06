package com.matematicas.conicas;

public class Conicas {
	
	// ==========================================
    // 1. ELIPSES (Ecuación canónica: ((x-h)^2 / a^2) + ((y-k)^2 / b^2) = 1)
    // ==========================================

    /**
     * Calcula la distancia focal (c) de una elipse.
     * Fórmula: c = sqrt(|a^2 - b^2|)
     */
    public static double ellipseFocalDistance(double a, double b) {
        return Math.sqrt(Math.abs((a * a) - (b * b)));
    }

    /**
     * Calcula la excentricidad de una elipse (e = c / a).
     * Nota: 'a' representa el semieje mayor.
     */
    public static double ellipseEccentricity(double a, double b) {
        double semiMajor = Math.max(a, b);
        double semiMinor = Math.min(a, b);
        double c = ellipseFocalDistance(semiMajor, semiMinor);
        return c / semiMajor;
    }

    /**
     * Verifica si un punto (x, y) pertenece a una elipse centrada en (h, k).
     * Se incluye una tolerancia para mitigar errores de precisión en punto flotante.
     */
    public static boolean isPointOnEllipse(double x, double y, double h, double k, double a, double b, double tolerance) {
        double termX = Math.pow(x - h, 2) / (a * a);
        double termY = Math.pow(y - k, 2) / (b * b);
        return Math.abs((termX + termY) - 1.0) <= tolerance;
    }

    /**
     * Genera un punto paramétrico de la elipse dado un ángulo t (en radianes).
     * x = h + a * cos(t), y = k + b * sin(t)
     */
    public static double[] ellipseParametricPoint(double h, double k, double a, double b, double t) {
        double x = h + a * Math.cos(t);
        double y = k + b * Math.sin(t);
        return new double[]{ x, y };
    }


    // ==========================================
    // 2. HIPÉRBOLAS (Ecuación canónica: ((x-h)^2 / a^2) - ((y-k)^2 / b^2) = 1)
    // ==========================================

    /**
     * Calcula la distancia focal (c) de una hipérbola.
     * Fórmula: c = sqrt(a^2 + b^2)
     */
    public static double hyperbolaFocalDistance(double a, double b) {
        return Math.sqrt((a * a) + (b * b));
    }

    /**
     * Calcula la excentricidad de una hipérbola (e = c / a). Siempre es mayor que 1.
     */
    public static double hyperbolaEccentricity(double a, double b) {
        double c = hyperbolaFocalDistance(a, b);
        return c / a;
    }

    /**
     * Devuelve las pendientes de las dos asíntotas de una hipérbola horizontal.
     * Pendientes: m1 = b/a y m2 = -b/a
     */
    public static double[] hyperbolaAsymptoteSlopes(double a, double b) {
        double m = b / a;
        return new double[]{ m, -m };
    }

    /**
     * Verifica si un punto (x, y) pertenece a la hipérbola horizontal centrada en (h, k).
     */
    public static boolean isPointOnHyperbola(double x, double y, double h, double k, double a, double b, double tolerance) {
        double termX = Math.pow(x - h, 2) / (a * a);
        double termY = Math.pow(y - k, 2) / (b * b);
        return Math.abs((termX - termY) - 1.0) <= tolerance;
    }


    // ==========================================
    // 3. PARÁBOLAS (Ecuación canónica: (y-k)^2 = 4p(x-h))
    // ==========================================

    /**
     * Calcula las coordenadas (x, y) del foco de una parábola horizontal con vértice (h, k) y parámetro focal p.
     */
    public static double[] parabolaFocus(double h, double k, double p) {
        double focusX = h + p;
        double focusY = k;
        return new double[]{ focusX, focusY };
    }

    /**
     * Calcula la ecuación de la recta directriz para una parábola horizontal.
     * Retorna el valor constante de x: x = h - p
     */
    public static double parabolaDirectrixX(double h, double p) {
        return h - p;
    }

    /**
     * Calcula el valor de la coordenada y de la parábola dada una x (asumiendo apertura horizontal).
     * Retorna un arreglo con las dos ramas (positiva y negativa), o null si x no es válida.
     */
    public static double[] parabolaYValues(double x, double h, double k, double p) {
        double inner = 4.0 * p * (x - h);
        if (inner < 0) {
            return null; // Fuera del dominio de la parábola
        }
        double sqrtVal = Math.sqrt(inner);
        return new double[]{ k + sqrtVal, k - sqrtVal };
    }

}
