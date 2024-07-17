package employees;

public class Worker {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Worker(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return name +
                "\n- Должность: " + position +
                "\n- E-mail: " + email +
                "\n- Номер телефона: " + phone +
                "\n- Оклад: " + salary + " руб." +
                "\n- Возраст: " + age + ".";
    }
    public void showAllWorkersSecondTask(Worker[] array) {
        for (Worker taskTwo : array) {
            System.out.println(taskTwo.toString());
        }
    }
}
