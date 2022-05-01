package com.qa;

import java.util.NoSuchElementException;

enum ErrorCodes {

    VALIDATION_PARSE_ERROR(123);
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void wrapWithCustomException() {
        try {
            // some code…
        } catch (NoSuchElementException e) {
            throw new TestToolException("Element is not found ", e);
        }
    }
}

public class TestToolException extends RuntimeException {


    private Integer errorCode;

    public TestToolException() {
    }

    public TestToolException(String message) {
        super(message);
    }

    public TestToolException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestToolException(Throwable cause) {
        super(cause);
    }

    public TestToolException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public TestToolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
