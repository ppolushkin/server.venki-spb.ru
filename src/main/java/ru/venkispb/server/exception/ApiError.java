package ru.venkispb.server.exception;

public class ApiError {
    ApiError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code;
    public String message;
}
