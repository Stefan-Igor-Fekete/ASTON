package printed_publications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> directory;

    public PhoneBook() {
        directory = new HashMap<>();
    }

    public void addSub(String surname, String phoneNumber) {
        if (!directory.containsKey(surname)) {
            directory.put(surname, new ArrayList<>());
        }
        directory.get(surname).add(phoneNumber);
    }

    public List<String> getSub(String surname) {
        return directory.getOrDefault(surname, new ArrayList<>());
    }
}
