package animal;

import animal.Animal;
import tableware.Bowl;

public class Cat extends Animal {

    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        catCount++;
        this.satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFood() >= foodAmount) {
            bowl.decreaseFood(foodAmount);
            this.satiety = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не хватает еды в миске.");
        }
    }

    public void isTheCatFull(Cat[] catArray) {
        for (Cat cat : catArray) {
            System.out.println(cat.name + " сыт: " + cat.isSatiety());
        }
    }

    public static int getCatCount() {
        return catCount;
    }
}

