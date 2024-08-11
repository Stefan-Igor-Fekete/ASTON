package enums;

public enum ApiMethodsPath {
    POST("/post"),
    GET_WITH_PARAMS("/get?foo1=bar1&foo2=bar2"),
    GET("/get"),
    PUT("/put"),
    PATCH("/patch"),
    DELETE("/delete"),
    ;
    public String path;

    ApiMethodsPath(String path) {
        this.path = path;
    }
}