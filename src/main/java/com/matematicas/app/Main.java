
package com.matematicas.app;

import java.util.Scanner;
import com.matematicas.geometria3D.Geometria3D;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Álgebra");
            System.out.println("2. Geometría 3D");
            System.out.println("3. Matrices");
            System.out.println("4. Salir");
            System.out.print("Selecciona una categoría: ");

            int opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuAlgebra(scanner);
                    break;
                case 2:
                    menuGeometria(scanner);
                    break;
                case 3:
                    menuMatrices(scanner);
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    // --- SUBMENÚ DE ÁLGEBRA ---
    private static void menuAlgebra(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- SUBMENÚ: ÁLGEBRA ---");
            System.out.println("1. Calcular MCD");
            System.out.println("2. Calcular MCM");
            System.out.println("3. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
               
                   
            }
        }
    }

    // --- SUBMENÚ DE GEOMETRÍA ---
    private static void menuGeometria(Scanner scanner) {
        System.out.println("\n--- SUBMENÚ: GEOMETRÍA 3D ---");
        System.out.println("1. Volumen de Esfera");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            System.out.print("Introduce el radio: ");
            double r = scanner.nextDouble();
            System.out.printf("Volumen: %.2f\n", Geometria3D.volumenEsfera(r));
        }
    }

    // --- SUBMENÚ DE MATRICES ---
    private static void menuMatrices(Scanner scanner) {
        System.out.println("\n--- SUBMENÚ: MATRICES ---");
        System.out.println("Funcionalidad en desarrollo...");
    }

    
}