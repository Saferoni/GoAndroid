package com.pavelsafronov.test;

/**
 * Created by pavelsafronov on 25.11.16.
 */

public class Triangle {
    private double a = 20;
    private double b = 20;
    private double c = 20;



    public static double area(double a, double b, double c){
        double p = (a + b + c)/2;
        double ar = Math.sqrt((p * (p - a) * (p - b) * (p - c)));
        return ar;
    }

    //public double height (double a, double b, double c){
    //    double height;
    //    height = Math.sqrt((p * (p - a) * (p - b) * (p - c)))/a;
    //    return height;
    //}


    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

