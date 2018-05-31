package net.ivan.triangleappdeluxe;

import java.text.DateFormat;
import java.util.Calendar;

public class Triangle {
    //sides of the triangle
    public final double a;
    public final double b;
    public final double c;

    //area of the triangle
    public final double area;

    //time and date of triangle creation
    public final String time;
    public final String date;

    //public constructor that sets values of sides, area and time
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        area = calculateArea();

        time = DateFormat.getTimeInstance(DateFormat.SHORT).format(Calendar.getInstance().getTime());
        date = DateFormat.getDateInstance(DateFormat.SHORT).format(Calendar.getInstance().getTime());
    }

    //calculates and returns area of the triangle
    private double calculateArea() {
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
