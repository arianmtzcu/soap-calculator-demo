package com.arian.example.demo.api.controller;

import java.util.function.Supplier;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arian.example.demo.business.service.CalculatorService;
import com.arian.example.demo.domain.dto.Members;

import lombok.RequiredArgsConstructor;

@Tag(name = "Calculator API")
@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {

   private final CalculatorService calculatorService;

   @Operation(summary = "Add two numbers", description = "Adds two numbers and returns the result.")
   @PostMapping("/add")
   public ResponseEntity<?> add(@RequestBody final Members members) {
      return handleOperation(() -> calculatorService.add(members));
   }

   @Operation(summary = "Subtract two numbers", description = "Subtracts two numbers and returns the result.")
   @PostMapping("/subtract")
   public ResponseEntity<?> subtract(@RequestBody final Members members) {
      return handleOperation(() -> calculatorService.subtract(members));
   }

   @Operation(summary = "Multiply two numbers", description = "Multiplies two numbers and returns the result.")
   @PostMapping("/multiply")
   public ResponseEntity<?> multiply(@RequestBody final Members members) {
      return handleOperation(() -> calculatorService.multiply(members));
   }

   @Operation(summary = "Divide two numbers", description = "Divides two numbers and returns the result.")
   @PostMapping("/divide")
   public ResponseEntity<?> divide(@RequestBody final Members members) {
      return handleOperation(() -> calculatorService.divide(members));
   }

   private ResponseEntity<?> handleOperation(final Supplier<Object> operation) {
      try {
         final var result = operation.get();
         return new ResponseEntity<>(result, HttpStatus.OK);

      } catch (Exception e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

}
