import operations.StringUtils;
import printed_publications.PhoneBook;


public class Main {
    public static void main(String[] args) {
        String[] words = {
                "Зефир", "Человек", "Зефир", "Любит", "Человек", "Человек",
                "Город", "Зефир", "Игорь", "Человек", "Игорь", "Паук",
                "Персик", "Город", "Зефир", "Персик", "Любит", "Игорь",
        };

        System.out.println("\nПервое задание: ");
        StringUtils stringUtils = new StringUtils();
        System.out.println("Количестчво повторений слов: \n" + stringUtils.getWordCount(words));
        System.out.println("\nСлова из которых состоит массив: \n" + stringUtils.getUniqueWords(words));
        System.out.println("\nВторое задание: ");
        PhoneBook phoneDirectory = new PhoneBook();
        phoneDirectory.addSub("Паша", "+375259874545");
        phoneDirectory.addSub("Паша", "+375336522147");
        phoneDirectory.addSub("Даша", "+9379992");
        System.out.println("Все номера Паши: " + phoneDirectory.getSub("Паша"));
        System.out.println("Все номера Даши: " + phoneDirectory.getSub("Даша"));
        System.out.println("Все номера Маши: " + phoneDirectory.getSub("Маша"));
    }
}