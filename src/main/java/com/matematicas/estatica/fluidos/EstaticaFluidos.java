package com.matematicas.estatica.fluidos;

public class EstaticaFluidos {
	
	public static final double GRAVEDAD_ESTANDAR = 9.81;
	/**
     * Calcula la Presión Hidrostática a una profundidad dada.
     * P = rho * g * h
     * @param densidadFluido Densidad del fluido (en kg/m^3)
     * @param alturaProfundidad Profundidad o altura de la columna de fluido (en metros)
     * @return Presión hidrostática (en Pascales, Pa)
     */
    public static double presionHidrostatica(double densidadFluido, double alturaProfundidad) {
        return presionHidrostatica(densidadFluido, alturaProfundidad, GRAVEDAD_ESTANDAR);
    }

    /**
     * Versión sobrecargada permitiendo especificar una gravedad diferente (ej. en otro planeta).
     */
    public static double presionHidrostatica(double densidadFluido, double alturaProfundidad, double gravedad) {
        if (densidadFluido < 0 || alturaProfundidad < 0) {
            throw new IllegalArgumentException("La densidad y la altura deben ser positivas.");
        }
        return densidadFluido * gravedad * alturaProfundidad;
    }

    /**
     * Calcula la Fuerza de Empuje (Principio de Arquímedes).
     * E = rho_fluido * V_sumergido * g
     * @param densidadFluido Densidad del fluido desplazado (en kg/m^3)
     * @param volumenSumergido Volumen del objeto sumergido (en m^3)
     * @return Fuerza de empuje hacia arriba (en Newtons, N)
     */
    public static double fuerzaEmpujeArquimedes(double densidadFluido, double volumenSumergido) {
        return densidadFluido * volumenSumergido * GRAVEDAD_ESTANDAR;
    }

    /**
     * Calcula la fuerza resultante en una prensa hidráulica (Principio de Pascal).
     * F2 = F1 * (A2 / A1)
     * @param fuerza1 Fuerza aplicada en el émbolo menor (en Newtons)
     * @param area1 Área del émbolo menor (en m^2)
     * @param area2 Área del émbolo mayor (en m^2)
     * @return Fuerza resultante en el émbolo mayor (en Newtons)
     */
    public static double prensaHidraulicaFuerza2(double fuerza1, double area1, double area2) {
        if (area1 <= 0) {
            throw new IllegalArgumentException("El área del émbolo menor debe ser mayor a cero.");
        }
        return fuerza1 * (area2 / area1);
    }

}
