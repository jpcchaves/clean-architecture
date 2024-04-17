package br.com.jpcchaves.infrastructure.controller;

import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.infrastructure.dto.ExceptionResponseDTO;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionsHandlerController {
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

    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
}
