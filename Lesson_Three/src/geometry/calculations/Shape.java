package geometry.calculations;

import java.awt.Color;

public interface Shape {
    double getPerimeter();
    double getArea();
    Color getFillColor();
    Color getBorderColor();
    String getFigureType();
    void printShapeDetails();
}
