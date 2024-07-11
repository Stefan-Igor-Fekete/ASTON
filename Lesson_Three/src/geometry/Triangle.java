package geometry;

import geometry.calculations.Shape;

import java.awt.*;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private Color fillColor;
    private Color borderColor;
    private String typeOfFigure;

    public Triangle(String typeOfFigure, double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
        this.typeOfFigure = typeOfFigure;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    @Override
    public String getFigureType() {
        return typeOfFigure;
    }

    @Override
    public void printShapeDetails() {
        System.out.println("Тип фигуры: " + getFigureType());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
