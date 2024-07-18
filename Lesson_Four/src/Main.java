import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;
import operations.ManageArrays;


public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"0", "67", "5"},
                {"4", "3", "4", "1"},
                {"7", "8", "4", "6"},
                {"5", "7", "10", "64"}
        };

        ManageArrays manageArrays = new ManageArrays();
        try {
            int result = manageArrays.sumArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage());
        }
    }
}