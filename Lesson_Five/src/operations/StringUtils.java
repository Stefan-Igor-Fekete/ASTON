package operations;

import java.util.*;

public class StringUtils {

    public Set<String> getUniqueWords(String[] words) {
        return new HashSet<>(Arrays.asList(words));
    }
    public Map<String, Integer> getWordCount(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

}

