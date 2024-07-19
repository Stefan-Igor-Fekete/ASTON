package geometry;

public class Circle extends Figure {
    private double radius;

    public Circle(String typeOFFigure, double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor,typeOFFigure);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}


