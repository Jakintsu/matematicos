package com.matematicas.vectores;

public class Vectores {

	// ==========================================
    // VECTOR 2D (Clase tradicional)
    // ==========================================
    public static class Vector2D {
        private final double x;
        private final double y;

        // Constructor
        public Vector2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Getters
        public double getX() { return x; }
        public double getY() { return y; }

        // Métodos matemáticos
        public Vector2D sumar(Vector2D v) {
            return new Vector2D(this.x + v.x, this.y + v.y);
        }

        public Vector2D restar(Vector2D v) {
            return new Vector2D(this.x - v.x, this.y - v.y);
        }

        public Vector2D multiplicar(double escalar) {
            return new Vector2D(this.x * escalar, this.y * escalar);
        }

        public double magnitud() {
            return Math.sqrt(x * x + y * y);
        }

        public double productoEscalar(Vector2D v) {
            return (this.x * v.x) + (this.y * v.y);
        }

        public Vector2D normalizar() {
            double mag = magnitud();
            if (mag == 0) {
                throw new ArithmeticException("No se puede normalizar el vector nulo.");
            }
            return new Vector2D(x / mag, y / mag);
        }

        // toString para ver el vector bonito en consola
        @Override
        public String toString() {
            return "Vector2D(" + x + ", " + y + ")";
        }
    }

    // ==========================================
    // VECTOR 3D (Clase tradicional)
    // ==========================================
    public static class Vector3D {
        private final double x;
        private final double y;
        private final double z;

        public Vector3D(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() { return x; }
        public double getY() { return y; }
        public double getZ() { return z; }

        public Vector3D sumar(Vector3D v) {
            return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
        }

        public Vector3D restar(Vector3D v) {
            return new Vector3D(this.x - v.x, this.y - v.y, this.z - v.z);
        }

        public Vector3D multiplicar(double escalar) {
            return new Vector3D(this.x * escalar, this.y * escalar, this.z * escalar);
        }

        public double magnitud() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        public double productoEscalar(Vector3D v) {
            return (this.x * v.x) + (this.y * v.y) + (this.z * v.z);
        }

        public Vector3D productoVectorial(Vector3D v) {
            double nuevoX = (this.y * v.z) - (this.z * v.y);
            double nuevoY = (this.z * v.x) - (this.x * v.z);
            double nuevoZ = (this.x * v.y) - (this.y * v.x);
            return new Vector3D(nuevoX, nuevoY, nuevoZ);
        }

        public Vector3D normalizar() {
            double mag = magnitud();
            if (mag == 0) {
                throw new ArithmeticException("No se puede normalizar el vector nulo.");
            }setValue:
            return new Vector3D(x / mag, y / mag, z / mag);
        }

        @Override
        public String toString() {
            return "Vector3D(" + x + ", " + y + ", " + z + ")";
        }
    }
	
}
