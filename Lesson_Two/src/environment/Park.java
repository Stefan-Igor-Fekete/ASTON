package environment;

import java.util.ArrayList;
import java.util.List;

public class Park {
    List<Attractions> attractions = new ArrayList<>();

    public List<Attractions> addAttractionToList(String nameOfAttraction, String workingTime, int attractionPrice) {
        attractions.add(new Attractions(nameOfAttraction, workingTime, attractionPrice));
        return attractions;
    }

    public void getListOfAllAttractions() {
        for (Park.Attractions attraction : attractions) {
            System.out.println(attraction.toString());
            System.out.println();
        }
    }

    public class Attractions {
        private final String attractionName;
        private final String hoursOfWorking;
        private final int oneUsePrice;

        public Attractions(String name, String workingHours, int price) {
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
