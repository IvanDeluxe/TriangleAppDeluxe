package net.ivan.triangleappdeluxe;

public class Triangle {
    //sides of the triangle
    public final double a;
    public final double b;
    public final double c;

    //area of the triangle
    public final double area;

    //public constructor that sets values of sides and area
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        area = calculateArea();
    }

    //calculates and returns area of the triangle
    private double calculateArea() {
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
