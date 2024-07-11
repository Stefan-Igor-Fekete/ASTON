package geometry;

import geometry.calculations.Shape;

import java.awt.*;

public class Circle implements Shape {
    private double radius;
    private Color fillColor;
    private Color borderColor;
    private String typeOfFigure;

    public Circle(String typeOfFigure, double radius, Color fillColor, Color borderColor) {
        this.typeOfFigure = typeOfFigure;
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
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
