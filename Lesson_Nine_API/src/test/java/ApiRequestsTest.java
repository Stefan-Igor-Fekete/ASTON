import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requestsExecute.PostmanApiRequests;
import utils.CollectionsUtils;
import utils.LoadProperties;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ApiRequestsTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Set<String> dynamicFields = CollectionsUtils.getDynamicFields();
    private static SoftAssert softAssert = new SoftAssert();
    private static String postRequestBody = "{\n    \"test\": \"value\"\n}";
    private static String rawPostPutPatchRequestBody = "This is expected to be sent back as part of response body.";

    @Test
    public void testGetRequest() throws IOException, JSONException {
        JsonNode expectedJson = objectMapper.readTree(LoadProperties.readJsonFromFile("expectedResponses.json", "getResponseParams"));
        Response response = PostmanApiRequests.sendGetRequest();
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
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
        Response response = PostmanApiRequests.sendPostRequest(postRequestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
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
        Response response = PostmanApiRequests.sendPostRawTextRequest(rawPostPutPatchRequestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
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
        Response response = PostmanApiRequests.sendPutRequest(rawPostPutPatchRequestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
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
        Response response = PostmanApiRequests.sendPatchRequest(rawPostPutPatchRequestBody);
        JsonNode actualJson = objectMapper.readTree(response.getBody().asString());
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