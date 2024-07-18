package operations;

import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class ManageArrays {

    public int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("массив должен быть размером 4x4");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("массив должен быть размером 4x4");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("меверные данные в ячейке: [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}