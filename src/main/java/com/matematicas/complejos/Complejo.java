package com.matematicas.complejos;

public class Complejo {
	
	// Atributos privados (inmutables, marcados como final)
    private final double real;
    private final double imaginario;

    // Constructor
    public Complejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    // Getters tradicionales
    public double getReal() {
        return real;
    }

    public double getImaginario() {
        return imaginario;
    }

    // ==========================================
    // OPERACIONES MATEMÁTICAS BÁSICAS
    // ==========================================

    // Suma: (a + bi) + (c + di) = (a + c) + (b + d)i
    public Complejo sumar(Complejo c) {
        double nuevoReal = this.real + c.getReal();
        double nuevoImaginario = this.imaginario + c.getImaginario();
        return new Complejo(nuevoReal, nuevoImaginario);
    }

    // Resta: (a + bi) - (c + di) = (a - c) + (b - d)i
    public Complejo restar(Complejo c) {
        double nuevoReal = this.real - c.getReal();
        double nuevoImaginario = this.imaginario - c.getImaginario();
        return new Complejo(nuevoReal, nuevoImaginario);
    }

    // Multiplicación: (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
    public Complejo multiplicar(Complejo c) {
        double nuevoReal = (this.real * c.getReal()) - (this.imaginario * c.getImaginario());
        double nuevoImaginario = (this.real * c.getImaginario()) + (this.imaginario * c.getReal());
        return new Complejo(nuevoReal, nuevoImaginario);
    }

    // División: (a + bi) / (c + di)
    public Complejo dividir(Complejo c) {
        double denominador = (c.getReal() * c.getReal()) + (c.getImaginario() * c.getImaginario());
        if (denominador == 0) {
            throw new ArithmeticException("División por cero en números complejos.");
        }
        double nuevoReal = ((this.real * c.getReal()) + (this.imaginario * c.getImaginario())) / denominador;
        double nuevoImaginario = ((this.imaginario * c.getReal()) - (this.real * c.getImaginario())) / denominador;
        return new Complejo(nuevoReal, nuevoImaginario);
    }

    // ==========================================
    // PROPIEDADES Y MÉTODOS ESPECIALES
    // ==========================================

    // Conjugado: a - bi
    public Complejo conjugado() {
        return new Complejo(this.real, -this.imaginario);
    }

    // Módulo (o valor absoluto): |z| = sqrt(a^2 + b^2)
    public double modulo() {
        return Math.sqrt((real * real) + (imaginario * imaginario));
    }

    // Argumento (fase o ángulo en radianes): atan2(b, a)
    public double argumento() {
        return Math.atan2(imaginario, real);
    }

    // ==========================================
    // REPRESENTACIÓN VISUAL
    // ==========================================

    @Override
    public String toString() {
        if (imaginario < 0) {
            return real + " - " + Math.abs(imaginario) + "i";
        } else if (imaginario == 0) {
            return String.valueOf(real);
        } else {
            return real + " + " + imaginario + "i";
        }
	

}
}
