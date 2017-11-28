package br.com.test.vreal.utils;

import br.com.test.vreal.domain.ExceptionResponse;
import org.springframework.validation.BindingResult;

import java.util.LinkedHashSet;
import java.util.Set;

public class ValidationErrors {

    public static Set<ExceptionResponse> getErrors(BindingResult result) {
        Set<ExceptionResponse> error = new LinkedHashSet<>();
        if (result != null && result.hasErrors()) {
            result.getAllErrors().forEach(item -> {
                ExceptionResponse exceptionResponse = new ExceptionResponse();
                exceptionResponse.setErrorCode(item.getCode());
                exceptionResponse.setErrorMessage(item.getDefaultMessage());
                error.add(exceptionResponse);
            });
        }
        return error;
    }
}
