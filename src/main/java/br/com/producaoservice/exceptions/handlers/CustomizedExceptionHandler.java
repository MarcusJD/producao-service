package br.com.producaoservice.exceptions.handlers;

import br.com.producaoservice.exceptions.BadRequestException;
import br.com.producaoservice.exceptions.NoContentException;
import br.com.producaoservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
        String message = getMessageOrDefault(exception, "Ocorreu um erro no servidor");
        return buildExceptionResponse(message, request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException exception, WebRequest request) {
        String message = getMessageOrDefault(exception, "Resultado não encontrado");
        return buildExceptionResponse(message, request.getDescription(false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class, MethodArgumentTypeMismatchException.class})
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException exception, WebRequest request) {
        String message = getMessageOrDefault(exception, "Requisição inválida");
        return buildExceptionResponse(message, request.getDescription(false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContentException.class)
    public final ResponseEntity<ExceptionResponse> handleNoContentException(NoContentException exception, WebRequest request) {
        String message = getMessageOrDefault(exception, "Sem conteúdo");
        return buildExceptionResponse(message, request.getDescription(false), HttpStatus.NO_CONTENT);
    }

    private String getMessageOrDefault(Exception exception, String defaultMessage) {
        return exception.getMessage() != null && !exception.getMessage().isBlank() ? exception.getMessage() : defaultMessage;
    }

    private ResponseEntity<ExceptionResponse> buildExceptionResponse(String message, String details, HttpStatus status) {
        ExceptionResponse response = ExceptionResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(message)
                .details(details)
                .build();
        return new ResponseEntity<>(response, status);
    }
}