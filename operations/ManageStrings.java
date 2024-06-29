package operations;

public class ManageStrings {
    public void printThreeWords() {
        System.out.println("\nПервое задание:");
        System.out.println("Orange\n" + "Banana\n" + "Apple");
    }

    public void printStringMultipleTimes(String str, int count) {
        System.out.println("\nВосьмое задание:");
        for (int i = 0; i < count; i++) {
            System.out.print(str + " ");
        }
    }
}
