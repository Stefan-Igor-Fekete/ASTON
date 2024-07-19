package geometry;

public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(String typeOfFigure, double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor,typeOfFigure);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
