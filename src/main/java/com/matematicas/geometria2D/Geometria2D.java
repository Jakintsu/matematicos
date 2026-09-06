package com.matematicas.geometria2D;

public class Geometria2D {
	


	    // --- CÁLCULOS SOBRE PUNTOS Y LÍNEAS ---

	    // Distancia euclídea entre dos puntos: d = √((x₂ - x₁)² + (y₂ - y₁)²)
	    public static double distancia(Punto2D p1, Punto2D p2) {
	        return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
	    }

	    // Pendiente de la recta que pasa por dos puntos: m = (y₂ - y₁) / (x₂ - x₁)
	    // Lanza aritmética si la recta es vertical (x₂ - x₁ = 0)
	    public static double pendiente(Punto2D p1, Punto2D p2) {
	        double deltaX = p2.getX() - p1.getX();
	        if (deltaX == 0) {
	            throw new ArithmeticException("Pendiente indefinida (recta vertical).");
	        }
	        return (p2.getY() - p1.getY()) / deltaX;
	    }

	    // Punto medio entre dos puntos
	    public static Punto2D puntoMedio(Punto2D p1, Punto2D p2) {
	        double xm = (p1.getX() + p2.getX()) / 2.0;
	        double ym = (p1.getY() + p2.getY()) / 2.0;
	        return new Punto2D(xm, ym);
	    }

	    // --- ÁREAS ---

	    public static double areaCirculo(double radio) {
	        return Math.PI * Math.pow(radio, 2);
	    }

	    public static double areaRectangulo(double base, double altura) {
	        return base * altura;
	    }

	    public static double areaTriangulo(double base, double altura) {
	        return (base * altura) / 2.0;
	    }

	    // Área de un triángulo mediante la Fórmula de Herón (dados sus 3 lados)
	    public static double areaTrianguloHeron(double a, double b, double c) {
	        double s = (a + b + c) / 2.0; // Semiperímetro
	        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	    }

	    // --- PERÍMETROS ---

	    public static double perimetroCirculo(double radio) {
	        return 2 * Math.PI * radio;
	    }

	    public static double perimetroRectangulo(double base, double altura) {
	        return 2 * (base + altura);
	    }

	    public static double perimetroTriangulo(double a, double b, double c) {
	        return a + b + c;
	    }
	}


