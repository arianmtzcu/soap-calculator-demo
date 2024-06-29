package com.arian.example.demo.business.client;

import javax.xml.transform.dom.DOMSource;

import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoapLoggingInterceptor implements ClientInterceptor {

   @Override
   public boolean handleRequest(final MessageContext messageContext) {
      final SoapMessage soapRequest = (SoapMessage) messageContext.getRequest();
      log.info("Request:\n{}", XmlUtils.domSourceToString((DOMSource) soapRequest.getPayloadSource()));
      return true;
   }

   @Override
   public boolean handleResponse(final MessageContext messageContext) {
      final SoapMessage soapResponse = (SoapMessage) messageContext.getResponse();
      log.info("Response:\n{}", XmlUtils.domSourceToString((DOMSource) soapResponse.getPayloadSource()));
      return true;
   }

   @Override
   public boolean handleFault(final MessageContext messageContext) {
      final SoapMessage soapFault = (SoapMessage) messageContext.getResponse();
      log.error("Fault:\n{}", XmlUtils.domSourceToString((DOMSource) soapFault.getPayloadSource()));
      return true;
   }

   @Override
   public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {
      // without implementation
   }

}

