package com.matematicas.trigonometria;

public class Trigonometria {
	
	// ==========================================
    // 1. SUMA Y RESTA DE ÁNGULOS
    // ==========================================

    /**
     * Seno de la suma: sin(a + b) = sin(a)cos(b) + cos(a)sin(b)
     */
    public static double sinSum(double a, double b) {
        return Math.sin(a) * Math.cos(b) + Math.cos(a) * Math.sin(b);
    }

    /**
     * Seno de la resta: sin(a - b) = sin(a)cos(b) - cos(a)sin(b)
     */
    public static double sinDiff(double a, double b) {
        return Math.sin(a) * Math.cos(b) - Math.cos(a) * Math.sin(b);
    }

    /**
     * Coseno de la suma: cos(a + b) = cos(a)cos(b) - sin(a)sin(b)
     */
    public static double cosSum(double a, double b) {
        return Math.cos(a) * Math.cos(b) - Math.sin(a) * Math.sin(b);
    }

    /**
     * Coseno de la resta: cos(a - b) = cos(a)cos(b) + sin(a)sin(b)
     */
    public static double cosDiff(double a, double b) {
        return Math.cos(a) * Math.cos(b) + Math.sin(a) * Math.sin(b);
    }

    /**
     * Tangente de la suma: tan(a + b) = (tan(a) + tan(b)) / (1 - tan(a)tan(b))
     */
    public static double tanSum(double a, double b) {
        double tanA = Math.tan(a);
        double tanB = Math.tan(b);
        return (tanA + tanB) / (1.0 - (tanA * tanB));
    }


    // ==========================================
    // 2. TRANSFORMACIÓN DE SUMAS Y RESTAS A PRODUCTOS
    // ==========================================

    /**
     * Suma de senos: sin(a) + sin(b) = 2 * sin((a+b)/2) * cos((a-b)/2)
     */
    public static double sumOfSines(double a, double b) {
        return 2.0 * Math.sin((a + b) / 2.0) * Math.cos((a - b) / 2.0);
    }

    /**
     * Resta de senos: sin(a) - sin(b) = 2 * cos((a+b)/2) * sin((a-b)/2)
     */
    public static double diffOfSines(double a, double b) {
        return 2.0 * Math.cos((a + b) / 2.0) * Math.sin((a - b) / 2.0);
    }

    /**
     * Suma de cosenos: cos(a) + cos(b) = 2 * cos((a+b)/2) * cos((a-b)/2)
     */
    public static double sumOfCosines(double a, double b) {
        return 2.0 * Math.cos((a + b) / 2.0) * Math.cos((a - b) / 2.0);
    }

    /**
     * Resta de cosenos: cos(a) - cos(b) = -2 * sin((a+b)/2) * sin((a-b)/2)
     */
    public static double diffOfCosines(double a, double b) {
        return -2.0 * Math.sin((a + b) / 2.0) * Math.sin((a - b) / 2.0);
    }


    // ==========================================
    // 3. FÓRMULAS DE ÁNGULO DOBLE
    // ==========================================

    /**
     * Seno del ángulo doble: sin(2a) = 2 * sin(a) * cos(a)
     */
    public static double sinDoubleAngle(double a) {
        return 2.0 * Math.sin(a) * Math.cos(a);
    }

    /**
     * Coseno del ángulo doble: cos(2a) = cos^2(a) - sin^2(a)
     */
    public static double cosDoubleAngle(double a) {
        double cosA = Math.cos(a);
        double sinA = Math.sin(a);
        return (cosA * cosA) - (sinA * sinA);
    }

    /**
     * Tangente del ángulo doble: tan(2a) = 2 * tan(a) / (1 - tan^2(a))
     */
    public static double tanDoubleAngle(double a) {
        double tanA = Math.tan(a);
        return (2.0 * tanA) / (1.0 - (tanA * tanA));
    }

}
