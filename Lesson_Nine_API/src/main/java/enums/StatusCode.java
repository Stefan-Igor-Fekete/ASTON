package enums;

public enum StatusCode {
    OK_RESPONSE(200),
    ;
    public int code;

    StatusCode(int code) {
        this.code = code;
    }
}