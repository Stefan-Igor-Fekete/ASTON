import employees.Worker;
import environment.Park;


public class Main {
    public static void main(String[] args) {
        Worker[] workerArray = new Worker[5];
        Park park = new Park();
        Park.Attraction[] arrayOfAttractions = new Park.Attraction[3];
        Worker workerTask = new Worker("Stefan", "Beginner", "xiaominote4igor@gmail.com",
                "+375259478779", 850, 27);
        workerArray[0] = workerTask;
        workerArray[1] = new Worker("Petya", "Beginner", "petya@mail.ru",
                "+375258766998", 650, 23);
        workerArray[2] = new Worker("Vasyliy", "Beginner", "vasya@mail.ru",
                "+375258766934", 950, 32);
        workerArray[3] = new Worker("Misha", "Middle", "misha@mail.ru",
                "+375258763456", 550, 19);
        workerArray[4] = new Worker("Irina", "Senior", "irina@mail.ru",
                "+375258766938", 1149, 39);
        arrayOfAttractions[0] = park.new Attraction("Колесо обозрения", "08:30 - 22:30", 7);
        arrayOfAttractions[1] = park.new Attraction("Американские горки", "12:00 - 21:00", 12);
        arrayOfAttractions[2] = park.new Attraction("Тарзанка", "12:00 - 21:00", 8);

        System.out.println("\nПервое задание:\n\n" + workerTask);
        System.out.println("\n Второе задание:\n");
        workerTask.showAllWorkersSecondTask(workerArray);
        System.out.println("\n Третье задание:\n");
        park.showAllAttractions(arrayOfAttractions);
        park.infoAboutAttraction(arrayOfAttractions);
    }
}