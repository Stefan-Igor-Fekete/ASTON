package geometry;

import geometry.calculations.Shape;

import java.awt.*;

public class Rectangle implements Shape {
    private double width;
    private double height;
    private Color fillColor;
    private Color borderColor;
    private String typeOfFigure;

    public Rectangle(String typeOfFigure, double width, double height, Color fillColor, Color borderColor) {
        this.typeOfFigure = typeOfFigure;
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
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
        System.out.println("Тип фигуры: " +getFigureType());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
