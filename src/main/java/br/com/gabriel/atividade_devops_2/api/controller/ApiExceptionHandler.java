package br.com.gabriel.atividade_devops_2.api.controller;

import br.com.gabriel.atividade_devops_2.data.response.ApiErrorResponse;
import br.com.gabriel.atividade_devops_2.exception.status.StatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(StatusException.class)
    public ResponseEntity<ApiErrorResponse> statusException(StatusException ex) {
        final var errorResponse = new ApiErrorResponse(ex);
        return ResponseEntity
                .status(ex.getStatus())
                .body(errorResponse);
    }
}
