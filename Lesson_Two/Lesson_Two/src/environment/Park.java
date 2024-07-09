package environment;

public class Park {
    public void showAllAttractions(Attraction[] array) {
        System.out.println("В парке доступны следующие аттракционы: ");
        for (Attraction listOfAttractions : array) {
            System.out.println(listOfAttractions.getAttractionName());
        }
    }

    public void infoAboutAttraction(Attraction[] array) {
        System.out.println("\nПодробная информация о каждом аттракционе: ");
        for (Attraction listOfAttractions : array) {
            System.out.println(listOfAttractions.toString());
        }
    }

    public class Attraction {
        private final String attractionName;
        private final String hoursOfWorking;
        private final int oneUsePrice;

        public String getAttractionName() {
            return attractionName;
        }

        public Attraction(String name, String workingHours, int price) {
            this.attractionName = name;
            this.hoursOfWorking = workingHours;
            this.oneUsePrice = price;
        }

        @Override
        public String toString() {
            return attractionName +
                    "\n- Время работы:" + hoursOfWorking +
                    "\n- Стоимость одного использования: " + oneUsePrice + ".";
        }
    }
}
