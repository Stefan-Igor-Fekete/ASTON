package operations;

public class ManageArrays {

    public void zeroToOneOneToZero(int[] array, int chunk) {
        System.out.println("\nДесятое задание:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
                System.out.print(array[i] + " ");
            } else if (array[i] == 1) {
                array[i] = 0;
                System.out.print(array[i] + " ");
            } else if ((i + 1) % chunk == 0) {
                System.out.println();
            }
        }
    }

    public void emptyArray(int[] array, int chunk) {
        System.out.println("\n\nОдинадцатое задание:");
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
            if ((i + 1) % chunk == 0) {
                System.out.println();
            }
        }
    }

    public void arrayMultipliedOnSix(int[] array) {
        System.out.println("\nДвенадцатое задание:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
            System.out.print(array[i] + " ");
        }
    }

    public void createAndFillDiagonal1() {
        System.out.println("\n\nТринадцатое задание:");
        int arraySize = 10;
        int[][] table = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (i == j || arraySize - i == j + 1) {
                    table[i][j] = table[i][arraySize - i - 1] = 1;
                } else {
                    table[i][j] = 0;
                }
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void generateArray(int len, int initialValue) {
        System.out.println("\nЧетырнадцатое задание:");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }
}
