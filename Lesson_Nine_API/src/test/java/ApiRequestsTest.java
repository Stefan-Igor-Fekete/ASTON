import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requestsExecute.PostmanApiRequests;

public class ApiRequestsTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetRequest() throws Exception {
        Response response = PostmanApiRequests.sendGetRequest();
        JsonNode responseJson = objectMapper.readTree(response.getBody().asString());
        JsonNode argsNode = responseJson.get("args");
        JsonNode urlNode = responseJson.get("url");
        JsonNode headersNode = responseJson.get("headers");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(urlNode, "Поле 'url' отсутствует в ответе!");
        softAssert.assertEquals(urlNode.asText(), "http://postman-echo.com/get?foo1=bar1&foo2=bar2", "Значение 'url' не соответствует ожидаемому!");
        softAssert.assertNotNull(argsNode, "Поле 'args' отсутствует в ответе!");
        softAssert.assertEquals(argsNode.get("foo1").asText(), "bar1", "Значение 'foo1' не соответствует ожидаемому!");
        softAssert.assertEquals(argsNode.get("foo2").asText(), "bar2", "Значение 'foo2' не соответствует ожидаемому!");
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertNotNull(headersNode, "Поле 'headers' отсутствует в ответе!");
        softAssert.assertEquals(headersNode.get("host").asText(), "postman-echo.com", "Заголовок 'host' не соответствует ожидаемому!");
        softAssert.assertEquals(headersNode.get("accept").asText(), "*/*", "Заголовок 'accept' не соответствует ожидаемому!");
        softAssert.assertAll();
    }

    @Test
    public void testPostRequest() throws Exception {
        Response response = PostmanApiRequests.sendPostRequest();
        JsonNode responseJson = objectMapper.readTree(response.getBody().asString());
        JsonNode argsNode = responseJson.get("args");
        JsonNode formNode = responseJson.get("form");
        JsonNode headersNode = responseJson.get("headers");
        JsonNode urlNode = responseJson.get("url");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertNotNull(urlNode, "Поле 'url' отсутствует в ответе!");
        softAssert.assertEquals(urlNode.asText(), "http://postman-echo.com/post", "Значение 'url' не соответствует ожидаемому!");
        softAssert.assertNotNull(argsNode, "Поле 'args' отсутствует в ответе!");
        softAssert.assertTrue(argsNode.isEmpty(), "Поле 'args' не должно содержать данных!");
        softAssert.assertNotNull(formNode, "Поле 'form' отсутствует в ответе!");
        softAssert.assertEquals(formNode.get("foo1").asText(), "bar1", "Значение 'foo1' не соответствует ожидаемому!");
        softAssert.assertEquals(formNode.get("foo2").asText(), "bar2", "Значение 'foo2' не соответствует ожидаемому!");
        softAssert.assertNotNull(headersNode, "Поле 'headers' отсутствует в ответе!");
        softAssert.assertEquals(headersNode.get("host").asText(), "postman-echo.com", "Заголовок 'host' не соответствует ожидаемому!");
        softAssert.assertEquals(headersNode.get("accept").asText(), "*/*", "Заголовок 'accept' не соответствует ожидаемому!");
        softAssert.assertAll();
    }

    @Test
    public void testPostRawTextRequest() throws Exception {
        Response response = PostmanApiRequests.sendPostRawTextRequest();
        JsonNode responseJson = objectMapper.readTree(response.getBody().asString());
        JsonNode dataNode = responseJson.get("data");
        JsonNode urlNode = responseJson.get("url");
        JsonNode headersNode = responseJson.get("headers");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertNotNull(urlNode, "Поле 'url' отсутствует в ответе!");
        softAssert.assertEquals(urlNode.asText(), "http://postman-echo.com/post", "Значение 'url' не соответствует ожидаемому!");
        softAssert.assertNotNull(dataNode, "Поле 'data' отсутствует в ответе!");
        softAssert.assertEquals(dataNode.asText().trim(), "{\n    \"test\": \"value\"\n}", "Значение 'data' не соответствует ожидаемому!");
        softAssert.assertNotNull(headersNode, "Поле 'headers' отсутствует в ответе!");
        softAssert.assertEquals(headersNode.get("host").asText(), "postman-echo.com", "Заголовок 'host' не соответствует ожидаемому!");
        softAssert.assertEquals(headersNode.get("content-type").asText(), "text/plain; charset=UTF-8", "Заголовок 'content-type' не соответствует ожидаемому!");
        softAssert.assertAll();
    }

    @Test
    public void testPutRequest() throws Exception {
        Response response = PostmanApiRequests.sendPutRequest();
        JsonNode responseJson = objectMapper.readTree(response.getBody().asString());
        JsonNode argsNode = responseJson.get("args");
        JsonNode urlNode = responseJson.get("url");
        JsonNode headersNode = responseJson.get("headers");
        JsonNode dataNode = responseJson.get("data");
        String actualContentType = headersNode.get("content-type").asText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertNotNull(urlNode, "Поле 'url' отсутствует в ответе!");
        softAssert.assertEquals(urlNode.asText(), "http://postman-echo.com/put", "Значение 'url' не соответствует ожидаемому!");
        softAssert.assertNotNull(argsNode, "Поле 'args' отсутствует в ответе!");
        softAssert.assertTrue(argsNode.isEmpty(), "Поле 'args' не должно содержать данных!");
        softAssert.assertNotNull(dataNode, "Поле 'data' отсутствует в ответе!");
        softAssert.assertNotNull(headersNode, "Поле 'headers' отсутствует в ответе!");
        softAssert.assertEquals(headersNode.get("host").asText(), "postman-echo.com", "Заголовок 'host' не соответствует ожидаемому!");
        softAssert.assertTrue(actualContentType.startsWith("text/plain"), "Заголовок 'content-type' не соответствует ожидаемому! Ожидался 'text/plain', но получен '" + actualContentType + "'");
        softAssert.assertAll();
    }

    @Test
    public void testPatchRequest() throws Exception {
        Response response = PostmanApiRequests.sendPatchRequest();
        JsonNode responseJson = objectMapper.readTree(response.getBody().asString());
        JsonNode argsNode = responseJson.get("args");
        JsonNode urlNode = responseJson.get("url");
        JsonNode headersNode = responseJson.get("headers");
        JsonNode dataNode = responseJson.get("data");
        String actualContentType = headersNode.get("content-type").asText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertNotNull(urlNode, "Поле 'url' отсутствует в ответе!");
        softAssert.assertEquals(urlNode.asText(), "http://postman-echo.com/patch", "Значение 'url' не соответствует ожидаемому!");
        softAssert.assertNotNull(argsNode, "Поле 'args' отсутствует в ответе!");
        softAssert.assertTrue(argsNode.isEmpty(), "Поле 'args' не должно содержать данных!");
        softAssert.assertNotNull(dataNode, "Поле 'data' отсутствует в ответе!");
        softAssert.assertNotNull(headersNode, "Поле 'headers' отсутствует в ответе!");
        softAssert.assertEquals(headersNode.get("host").asText(), "postman-echo.com", "Заголовок 'host' не соответствует ожидаемому!");
        softAssert.assertTrue(actualContentType.startsWith("application/json"), "Заголовок 'content-type' не соответствует ожидаемому! Ожидался 'text/plain', но получен '" + actualContentType + "'");
        softAssert.assertAll();
    }

    @Test
    public void testDeleteRequest() throws Exception {
        Response response = PostmanApiRequests.sendDeleteRequest();
        JsonNode responseJson = objectMapper.readTree(response.getBody().asString());
        JsonNode argsNode = responseJson.get("args");
        JsonNode urlNode = responseJson.get("url");
        JsonNode headersNode = responseJson.get("headers");
        JsonNode dataNode = responseJson.get("data");
        String actualContentType = headersNode.get("content-type").asText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Код ответа не соответствует ожидаемому!");
        softAssert.assertNotNull(urlNode, "Поле 'url' отсутствует в ответе!");
        softAssert.assertEquals(urlNode.asText(), "http://postman-echo.com/delete", "Значение 'url' не соответствует ожидаемому!");
        softAssert.assertNotNull(argsNode, "Поле 'args' отсутствует в ответе!");
        softAssert.assertTrue(argsNode.isEmpty(), "Поле 'args' не должно содержать данных!");
        softAssert.assertNotNull(dataNode, "Поле 'data' отсутствует в ответе!");
        softAssert.assertNotNull(headersNode, "Поле 'headers' отсутствует в ответе!");
        softAssert.assertEquals(headersNode.get("host").asText(), "postman-echo.com", "Заголовок 'host' не соответствует ожидаемому!");
        softAssert.assertTrue(actualContentType.startsWith("application/json"), "Заголовок 'content-type' не соответствует ожидаемому! Ожидался 'text/plain', но получен '" + actualContentType + "'");
        softAssert.assertAll();
    }
}