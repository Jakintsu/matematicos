package com.matematicas.geometria3D;

public class Geometria3D {
	
	// Cubo: V = a³
    public static double volumenCubo(double lado) {
        return Math.pow(lado, 3);
    }

    // Ortoedro / Prisma rectangular: V = largo * ancho * alto
    public static double volumenOrtoedro(double largo, double ancho, double alto) {
        return largo * ancho * alto;
    }

    // Esfera: V = (4/3) * π * r³
    public static double volumenEsfera(double radio) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    // Cilindro: V = π * r² * h
    public static double volumenCilindro(double radio, double altura) {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    // Cono: V = (1/3) * π * r² * h
    public static double volumenCono(double radio, double altura) {
        return (1.0 / 3.0) * Math.PI * Math.pow(radio, 2) * altura;
    }

    // Pirámide regular: V = (1/3) * Área_Base * h
    public static double volumenPiramide(double areaBase, double altura) {
        return (1.0 / 3.0) * areaBase * altura;
    }

    // Toro (Dona): V = 2 * π² * R * r²
    // R: radio mayor (centro del toro al centro del tubo)
    // r: radio menor (radio del tubo)
    public static double volumenToro(double radioMayor, double radioMenor) {
        return 2 * Math.pow(Math.PI, 2) * radioMayor * Math.pow(radioMenor, 2);
    }

}
