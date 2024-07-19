package geometry;

import geometry.calculations.AreaCalculate;
import geometry.calculations.PerimeterCalculate;

public abstract class Figure implements AreaCalculate, PerimeterCalculate {
    protected String fillColor;
    protected String borderColor;
    protected String typeOfFigure;

    public Figure(String fillColor, String borderColor, String typeOfFigure) {
        this.typeOfFigure = typeOfFigure;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printCharacteristics() {
        System.out.println("Тип фигуры: " + typeOfFigure);
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor + "\n");
    }
}

