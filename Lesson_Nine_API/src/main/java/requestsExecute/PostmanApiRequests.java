package requestsExecute;

import base.ApiUtils;
import enums.ApiMethodsPath;
import enums.StatusCode;
import io.restassured.response.Response;
import utils.LoadProperties;

import java.util.HashMap;

public class PostmanApiRequests {
    private static final String BASE_URI = LoadProperties.getProperty("urlApi");
    private static final String GET_WITH_PARAMS_PATH = ApiMethodsPath.GET_WITH_PARAMS.path;
    private static final String POST_REQUEST = ApiMethodsPath.POST.path;
    private static final String PUT_REQUEST = ApiMethodsPath.PUT.path;
    private static final String PATCH_REQUEST = ApiMethodsPath.PATCH.path;
    private static final String DELETE_REQUEST = ApiMethodsPath.DELETE.path;

    public static Response sendGetRequest() {
        HashMap<String, String> params = new HashMap<>();
        params.put("foo1", "bar1");
        params.put("foo2", "bar2");
        return ApiUtils.getRequest(BASE_URI, GET_WITH_PARAMS_PATH, params);
    }

    public static Response sendPostRequest() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("foo1", "bar1");
        formParams.put("foo2", "bar2");
        return ApiUtils.postRequest(BASE_URI, POST_REQUEST, formParams, StatusCode.OK_RESPONSE);
    }

    public static Response sendPostRawTextRequest() {
        String body = "{\n    \"test\": \"value\"\n}";
        return ApiUtils.postRawTextRequest(BASE_URI, POST_REQUEST, body, StatusCode.OK_RESPONSE);
    }

    public static Response sendPutRequest() {
        HashMap<String, String> formParams = new HashMap<>();
        return ApiUtils.putRequest(BASE_URI, PUT_REQUEST, formParams, StatusCode.OK_RESPONSE);
    }

    public static Response sendPatchRequest() {
        HashMap<String, String> params = new HashMap<>();
        return ApiUtils.patchRequest(BASE_URI, PATCH_REQUEST, params, StatusCode.OK_RESPONSE);
    }

    public static Response sendDeleteRequest() {
        HashMap<String, String> params = new HashMap<>();
        return ApiUtils.deleteRequest(BASE_URI, DELETE_REQUEST, params, StatusCode.OK_RESPONSE);
    }
}