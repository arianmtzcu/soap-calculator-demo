package com.arian.example.demo.api.error;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

   @ExceptionHandler(Exception.class)
   public ResponseEntity<Object> handleGlobalException(final Exception ex, final WebRequest request) {
      log.error("Exception: ", ex);
      Map<String, Object> body = new HashMap<>();
      body.put("timestamp", LocalDateTime.now());
      body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
      body.put("error", "Internal Server Error");
      body.put("message", ex.getMessage());
      body.put("path", request.getDescription(false));
      return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public Map<String, Object> handleValidationExceptions(final MethodArgumentNotValidException ex) {
      log.error("Validation Exception: ", ex);
      Map<String, Object> errors = new HashMap<>();
      ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
      return errors;
   }

}
