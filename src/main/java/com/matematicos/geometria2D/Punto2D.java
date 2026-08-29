package com.matematicos.geometria2D;

public class Punto2D {
	

	    private final double x;
	    private final double y;

	    public Punto2D(double x, double y) {
	        this.x = x;
	        this.y = y;
	    }

	    public double getX() { return x; }
	    public double getY() { return y; }

	    @Override
	    public String toString() {
	        return "(" + x + ", " + y + ")";
	    }
	}


