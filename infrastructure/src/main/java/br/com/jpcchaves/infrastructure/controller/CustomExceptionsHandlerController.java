package br.com.jpcchaves.infrastructure.controller;

import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.infrastructure.dto.ExceptionResponseDTO;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionsHandlerController extends ResponseEntityExceptionHandler {
  private static final Logger _logger =
      Logger.getLogger(CustomExceptionsHandlerController.class.getName());

  @ExceptionHandler
  public final ResponseEntity<ExceptionResponseDTO> handleInternalServerErrorException(
      Exception ex, WebRequest request) {
    _logger.severe("Error: " + ex.getClass() + " Message: " + ex.getMessage());

    ExceptionResponseDTO exceptionResponse =
        new ExceptionResponseDTO(new Date(), ex.getMessage(), request.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(TodoException.class)
  public final ResponseEntity<ExceptionResponseDTO> handleTodoException(
      TodoException ex, WebRequest request) {
    _logger.severe("Error: " + ex.getClass() + " Message: " + ex.getMessage());

    ExceptionResponseDTO exceptionResponse =
        new ExceptionResponseDTO(new Date(), ex.getMessage(), request.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.valueOf(ex.getStatusCode()));
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      @NonNull HttpHeaders headers,
      @NonNull HttpStatusCode status,
      WebRequest request) {
    _logger.severe("Error: " + ex.getClass() + " Message: " + ex.getMessage());

    ExceptionResponseDTO exceptionResponse =
        new ExceptionResponseDTO(
            new Date(),
            Objects.requireNonNull(ex.getFieldError()).getDefaultMessage(),
            request.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
