import animal.Animal;
import animal.Cat;
import animal.Dog;
import geometry.Circle;
import geometry.Figure;
import geometry.Rectangle;
import geometry.Triangle;
import tableware.Bowl;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");
        Figure circle = new Circle("Круг", 36, "Black", "Pink");
        Figure rectangle = new Rectangle("Прямоугольник",6, 10, "Orange", "Cyan");
        Figure triangle = new Triangle("Треугольник",4, 4, 4, "Red", "Blue");

        System.out.println("\nПервое задание:");
        dogBobik.run(150);
        dogBobik.swim(5);
        Cat cat = new Cat();
        catMurzik.run(150);
        catMurzik.swim(5);
        Bowl bowl = new Bowl(0);
        bowl.addFood(46);
        Cat[] cats = {catMurzik, catBarsik};
        catMurzik.eat(bowl, 12);
        catBarsik.eat(bowl,45);
        cat.isTheCatFull(cats);
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("\nВторое задание:");
        circle.printCharacteristics();
        rectangle.printCharacteristics();
        triangle.printCharacteristics();
    }
}