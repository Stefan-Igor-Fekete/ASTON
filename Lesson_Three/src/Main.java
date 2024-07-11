import animal.Animal;
import animal.Cat;
import animal.Dog;
import geometry.Circle;
import geometry.Triangle;
import geometry.Rectangle;
import geometry.calculations.Shape;
import tableware.Bowl;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");
        Shape circle = new Circle("Круг",5, Color.RED, Color.BLACK);
        Shape rectangle = new Rectangle("Прямоугольник",4, 6, Color.GREEN, Color.BLUE);
        Shape triangle = new Triangle("Треугольник",3, 4, 5, Color.YELLOW, Color.MAGENTA);
        System.out.println("\nПервое задание:");
        dogBobik.run(150);
        dogBobik.swim(5);
        catMurzik.run(150);
        catMurzik.swim(5);
        Bowl bowl = new Bowl(0);
        bowl.addFood(46);
        Cat[] cats = {catMurzik, catBarsik};
        catMurzik.eat(bowl, 12);
        catMurzik.isTheCatFull(cats);
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("\nВторое задание:");
        circle.printShapeDetails();
        rectangle.printShapeDetails();
        triangle.printShapeDetails();
    }
}