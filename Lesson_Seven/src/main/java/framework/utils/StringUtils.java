package framework.utils;

public class StringUtils {
    public static String lineWithoutHyphenation(String neededString) {
        return neededString.replace("\n", " ");
    }
}
