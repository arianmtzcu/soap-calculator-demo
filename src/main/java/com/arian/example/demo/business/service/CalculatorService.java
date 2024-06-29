package com.arian.example.demo.business.service;

import org.springframework.stereotype.Service;

import com.arian.example.demo.business.client.SoapCalculatorClient;
import com.arian.example.demo.business.mapper.RequestMapper;
import com.arian.example.demo.domain.dto.Members;
import com.arian.example.demo.interfaces.wsdl.AddResponse;
import com.arian.example.demo.interfaces.wsdl.DivideResponse;
import com.arian.example.demo.interfaces.wsdl.MultiplyResponse;
import com.arian.example.demo.interfaces.wsdl.SubtractResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculatorService {

   private final SoapCalculatorClient soapCalculatorClient;

   public AddResponse add(final Members members) {
      log.info("Received add request with members: {}", members);
      final var request = RequestMapper.INSTANCE.toAddRequest(members);
      final var response = soapCalculatorClient.add(request);
      return response;
   }

   public SubtractResponse subtract(final Members members) {
      log.info("Received subtract request with members: {}", members);
      final var request = RequestMapper.INSTANCE.toSubtractRequest(members);
      final var response = soapCalculatorClient.subtract(request);
      return response;
   }

   public MultiplyResponse multiply(final Members members) {
      log.info("Received multiply request with members: {}", members);
      final var request = RequestMapper.INSTANCE.toMultiplyRequest(members);
      final var response = soapCalculatorClient.multiply(request);
      return response;
   }

   public DivideResponse divide(final Members members) {
      log.info("Received divide request with members: {}", members);
      final var request = RequestMapper.INSTANCE.toDivideRequest(members);
      final var response = soapCalculatorClient.divide(request);
      return response;
   }

}
