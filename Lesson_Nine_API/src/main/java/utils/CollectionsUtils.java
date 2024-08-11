package utils;

import java.util.HashSet;
import java.util.Set;

public class CollectionsUtils {

    public static Set<String> getDynamicFields() {
        Set<String> dynamicFields = new HashSet<>();
        dynamicFields.add("x-forwarded-proto");
        dynamicFields.add("x-amzn-trace-id");
        dynamicFields.add("postman-token");
        dynamicFields.add("x-request-start");
        return dynamicFields;
    }
}
