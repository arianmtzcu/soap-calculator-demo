package com.arian.example.demo.business.client;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import com.arian.example.demo.interfaces.wsdl.Add;
import com.arian.example.demo.interfaces.wsdl.AddResponse;
import com.arian.example.demo.interfaces.wsdl.Divide;
import com.arian.example.demo.interfaces.wsdl.DivideResponse;
import com.arian.example.demo.interfaces.wsdl.Multiply;
import com.arian.example.demo.interfaces.wsdl.MultiplyResponse;
import com.arian.example.demo.interfaces.wsdl.Subtract;
import com.arian.example.demo.interfaces.wsdl.SubtractResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SoapCalculatorClient extends WebServiceGatewaySupport {

   @Value("${app.external-service.uri}")
   private String uri;

   @Value("${app.external-service.connection-timeout:5000}")
   private Integer connectionTimeout;

   @Value("${app.external-service.read-timeout:5000}")
   private Integer readTimeout;

   @PostConstruct
   public void init() {
      // Set uri
      getWebServiceTemplate().setDefaultUri(uri);

      // set connection configuration
      Arrays.stream(getWebServiceTemplate().getMessageSenders()).filter(s -> s instanceof HttpUrlConnectionMessageSender).forEach(s -> {
         ((HttpUrlConnectionMessageSender) s).setConnectionTimeout(Duration.of(connectionTimeout, ChronoUnit.MILLIS));
         ((HttpUrlConnectionMessageSender) s).setReadTimeout(Duration.of(readTimeout, ChronoUnit.MILLIS));
      });

      // set marshaller and unmarshaller
      Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
      marshaller.setContextPath("com.arian.example.demo.interfaces.wsdl");
      getWebServiceTemplate().setMarshaller(marshaller);
      getWebServiceTemplate().setUnmarshaller(marshaller);

      // Add logging interceptor
      getWebServiceTemplate().setInterceptors(new ClientInterceptor[] { new SoapLoggingInterceptor() });
   }

   public AddResponse add(final Add request) {
      return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request,
            message -> ((SaajSoapMessage) message).setSoapAction("http://tempuri.org/Add"));
   }

   public SubtractResponse subtract(final Subtract request) {
      return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(request,
            message -> ((SaajSoapMessage) message).setSoapAction("http://tempuri.org/Subtract"));
   }

   public MultiplyResponse multiply(final Multiply request) {
      return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(request,
            message -> ((SaajSoapMessage) message).setSoapAction("http://tempuri.org/Multiply"));
   }

   public DivideResponse divide(final Divide request) {
      return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(request,
            message -> ((SaajSoapMessage) message).setSoapAction("http://tempuri.org/Divide"));
   }

}
