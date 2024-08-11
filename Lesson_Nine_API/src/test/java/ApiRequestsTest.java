import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requestsExecute.PostmanApiRequests;
import utils.LoadProperties;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ApiRequestsTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetRequest() throws IOException, JSONException {
        JsonNode expectedJson = objectMapper.readTree(LoadProperties.readJsonFromFile("expectedResponses.json", "getResponseParams"));
        Response response = PostmanApiRequests.sendGetRequest();
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
        SoftAssert softAssert = new SoftAssert();
        Set<String> dynamicFields = new HashSet<>();
        dynamicFields.add("x-forwarded-proto");
        dynamicFields.add("x-amzn-trace-id");
        dynamicFields.add("postman-token");
        Iterator<Map.Entry<String, JsonNode>> fields = expectedJson.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode expectedValue = field.getValue();
            JsonNode actualValue = actualJson.get(fieldName);
            if (actualValue != null && !dynamicFields.contains(fieldName)) {
                softAssert.assertEquals(actualValue.asText(), expectedValue.asText(), "Значение '" + fieldName + "' не соответствует ожидаемому!");
            } else if (dynamicFields.contains(fieldName)) {
                softAssert.assertNotNull(actualValue, "Поле '" + fieldName + "' отсутствует в ответе или пустое!");
            }
        }
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertAll();
    }

    @Test
    public void testPostRequest() throws IOException, JSONException {
        JsonNode expectedJson = objectMapper.readTree(LoadProperties.readJsonFromFile("expectedResponses.json", "postResponse"));
        String requestBody = "{\n    \"test\": \"value\"\n}";
        Response response = PostmanApiRequests.sendPostRequest(requestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
        SoftAssert softAssert = new SoftAssert();
        Set<String> dynamicFields = new HashSet<>();
        dynamicFields.add("x-forwarded-proto");
        dynamicFields.add("x-amzn-trace-id");
        dynamicFields.add("postman-token");
        Iterator<Map.Entry<String, JsonNode>> fields = expectedJson.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode expectedValue = field.getValue();
            JsonNode actualValue = actualJson.get(fieldName);
            if (actualValue != null && !dynamicFields.contains(fieldName)) {
                softAssert.assertEquals(actualValue.asText(), expectedValue.asText(), "Значение '" + fieldName + "' не соответствует ожидаемому!");
            } else if (dynamicFields.contains(fieldName)) {
                softAssert.assertNotNull(actualValue, "Поле '" + fieldName + "' отсутствует в ответе или пустое!");
            }
        }
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertAll();
    }

    @Test
    public void testPostRawTextRequest() throws IOException, JSONException {
        JsonNode expectedJson = objectMapper.readTree(LoadProperties.readJsonFromFile("expectedResponses.json", "postRawTextResponse"));
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = PostmanApiRequests.sendPostRawTextRequest(requestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
        SoftAssert softAssert = new SoftAssert();
        Set<String> dynamicFields = new HashSet<>();
        dynamicFields.add("x-forwarded-proto");
        dynamicFields.add("x-amzn-trace-id");
        dynamicFields.add("postman-token");
        dynamicFields.add("x-request-start");
        Iterator<Map.Entry<String, JsonNode>> fields = expectedJson.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode expectedValue = field.getValue();
            JsonNode actualValue = actualJson.get(fieldName);
            if (actualValue != null && !dynamicFields.contains(fieldName)) {
                softAssert.assertEquals(actualValue.asText(), expectedValue.asText(), "Значение '" + fieldName + "' не соответствует ожидаемому!");
            } else if (dynamicFields.contains(fieldName)) {
                softAssert.assertNotNull(actualValue, "Поле '" + fieldName + "' отсутствует в ответе или пустое!");
            }
        }
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertAll();
    }

    @Test
    public void testPutRequest() throws IOException, JSONException {
        JsonNode expectedJson = objectMapper.readTree(LoadProperties.readJsonFromFile("expectedResponses.json", "putResponse"));
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = PostmanApiRequests.sendPutRequest(requestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
        SoftAssert softAssert = new SoftAssert();
        Set<String> dynamicFields = new HashSet<>();
        dynamicFields.add("x-forwarded-proto");
        dynamicFields.add("x-amzn-trace-id");
        dynamicFields.add("postman-token");
        dynamicFields.add("x-request-start");
        Iterator<Map.Entry<String, JsonNode>> fields = expectedJson.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode expectedValue = field.getValue();
            JsonNode actualValue = actualJson.get(fieldName);
            if (actualValue != null && !dynamicFields.contains(fieldName)) {
                softAssert.assertEquals(actualValue.asText(), expectedValue.asText(), "Значение '" + fieldName + "' не соответствует ожидаемому!");
            } else if (dynamicFields.contains(fieldName)) {
                softAssert.assertNotNull(actualValue, "Поле '" + fieldName + "' отсутствует в ответе или пустое!");
            }
        }
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertAll();
    }

    @Test
    public void testPatchRequest() throws IOException, JSONException {
        JsonNode expectedJson = objectMapper.readTree(LoadProperties.readJsonFromFile("expectedResponses.json", "patchResponse"));
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = PostmanApiRequests.sendPatchRequest(requestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
        SoftAssert softAssert = new SoftAssert();
        Set<String> dynamicFields = new HashSet<>();
        dynamicFields.add("x-forwarded-proto");
        dynamicFields.add("x-amzn-trace-id");
        dynamicFields.add("postman-token");
        dynamicFields.add("x-request-start");
        Iterator<Map.Entry<String, JsonNode>> fields = expectedJson.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode expectedValue = field.getValue();
            JsonNode actualValue = actualJson.get(fieldName);
            if (actualValue != null && !dynamicFields.contains(fieldName)) {
                softAssert.assertEquals(actualValue.asText(), expectedValue.asText(), "Значение '" + fieldName + "' не соответствует ожидаемому!");
            } else if (dynamicFields.contains(fieldName)) {
                softAssert.assertNotNull(actualValue, "Поле '" + fieldName + "' отсутствует в ответе или пустое!");
            }
        }
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertAll();
    }


    @Test
    public void testDeleteRequest() throws IOException, JSONException {
        JsonNode expectedJson = objectMapper.readTree(LoadProperties.readJsonFromFile("expectedResponses.json", "deleteResponse"));
        Response response = PostmanApiRequests.sendDeleteRequest();
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
        SoftAssert softAssert = new SoftAssert();
        Set<String> dynamicFields = new HashSet<>();
        dynamicFields.add("x-forwarded-proto");
        dynamicFields.add("x-amzn-trace-id");
        dynamicFields.add("postman-token");
        dynamicFields.add("x-request-start");
        Iterator<Map.Entry<String, JsonNode>> fields = expectedJson.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode expectedValue = field.getValue();
            JsonNode actualValue = actualJson.get(fieldName);
            if (actualValue != null && !dynamicFields.contains(fieldName)) {
                softAssert.assertEquals(actualValue.asText(), expectedValue.asText(), "Значение '" + fieldName + "' не соответствует ожидаемому!");
            } else if (dynamicFields.contains(fieldName)) {
                softAssert.assertNotNull(actualValue, "Поле '" + fieldName + "' отсутствует в ответе или пустое!");
            }
        }
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertAll();
    }
}