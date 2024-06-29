package operations;

public class ManageNumbers {

    public void checkSumSign() {
        System.out.println("\nВторое задание:");
        int a = 5, b = 10;
        System.out.println((a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

    public void printColor() {
        System.out.println("\nТретье задание:");
        int value = 101;
        String result;
        if (value <= 0) {
            result = "Красный";
        } else if (value < 101) {
            result = "Жёлтый";
        } else {
            result = "Зелёный";
        }
        System.out.println(result);
    }

    public void compareNumbers() {
        System.out.println("\nЧетвёртое задание:");
        int a = 4, b = 70;
        String result = (a >= b) ? "a>=b" : "a<b";
        System.out.println(result);
    }

    public void twoTrueOrFalseNumbers(int a, int b) {
        System.out.println("\nПятое задание:");
        int sum = a + b;
        System.out.println(sum >= 10 && sum <= 20);
    }

    public void checkNumber(int a) {
        System.out.println("\nШестое задание:");
        System.out.println((a >= 0) ? "Положительное число" : "Отрицательное число");
    }

    public void isNegativeNumber(int number) {
        System.out.println("\nСедьмое задание:");
        System.out.println(number < 0);
    }

    public void isLeapYear(int year) {
        System.out.println("\n\nДевятое задание:");
        boolean isLeap = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                }
            } else {
                isLeap = true;
            }
        }
        System.out.println(isLeap);
    }

}
