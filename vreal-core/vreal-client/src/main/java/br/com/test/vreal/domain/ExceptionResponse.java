package br.com.test.vreal.domain;

import java.io.Serializable;
import java.util.Set;

public class ExceptionResponse implements Serializable {

    private String errorCode;
    private String errorMessage;
    private Set<ExceptionResponse> errors;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Set<ExceptionResponse> getErrors() {
        return errors;
    }

    public void setErrors(Set<ExceptionResponse> errors) {
        this.errors = errors;
    }
}
