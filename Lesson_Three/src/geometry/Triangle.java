package geometry;

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String typeOfFigure, double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        super(fillColor, borderColor,typeOfFigure);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}
