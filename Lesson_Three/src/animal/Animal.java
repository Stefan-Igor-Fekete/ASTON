package animal;

public abstract class Animal {
    public String name;
    protected static int animalCount = 0;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getAnimalCount() {
        return animalCount;
    }
}