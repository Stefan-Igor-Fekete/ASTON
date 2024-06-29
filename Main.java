import operations.ManageArrays;
import operations.ManageNumbers;
import operations.ManageStrings;

public class Main {
    public static void main(String[] args) {
        int CHUNK_FOR_ALL_ARRAYS = 20;
        final int ELEVEN_TASK_ARRAY_COUNT = 100;
        int fiveTaskFirstNumber = 3, fiveTaskSecondNumber = 12;
        int sixTaskNumber = 0;
        int sevenTaskNumber = -200;
        int eightTaskNumber = 17;
        String eightTaskWord = "ASTON";
        int nineTaskNumber = 2024;
        int[] arrayTenTask = {0, 1, 0, 1, 1, 0};
        int[] arrayElevenTask = new int[ELEVEN_TASK_ARRAY_COUNT];
        int[] arrayTwelveTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int arraySizeFourteenthTask = 13;
        int initialValueFourteenthTask = 15;
        ManageStrings stringTasks = new ManageStrings();
        stringTasks.printThreeWords();
        ManageNumbers numberTasks = new ManageNumbers();
        numberTasks.checkSumSign();
        numberTasks.printColor();
        numberTasks.compareNumbers();
        numberTasks.twoTrueOrFalseNumbers(fiveTaskFirstNumber, fiveTaskSecondNumber);
        numberTasks.checkNumber(sixTaskNumber);
        numberTasks.isNegativeNumber(sevenTaskNumber);
        stringTasks.printStringMultipleTimes(eightTaskWord, eightTaskNumber);
        numberTasks.isLeapYear(nineTaskNumber);
        ManageArrays arrayTasks = new ManageArrays();
        arrayTasks.zeroToOneOneToZero(arrayTenTask, CHUNK_FOR_ALL_ARRAYS);
        arrayTasks.emptyArray(arrayElevenTask, CHUNK_FOR_ALL_ARRAYS);
        arrayTasks.arrayMultipliedOnSix(arrayTwelveTask);
        arrayTasks.createAndFillDiagonal1();
        arrayTasks.generateArray(arraySizeFourteenthTask, initialValueFourteenthTask);
    }
}