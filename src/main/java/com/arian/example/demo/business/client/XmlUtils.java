package com.arian.example.demo.business.client;

import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public final class XmlUtils {

   public static String domSourceToString(final DOMSource domSource) {
      try {
         StringWriter writer = new StringWriter();
         Transformer transformer = TransformerFactory.newInstance().newTransformer();
         transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
         transformer.transform(domSource, new StreamResult(writer));
         return writer.toString();

      } catch (TransformerException e) {
         throw new RuntimeException("Error transforming DOMSource to String", e);
      }
   }

   private XmlUtils() {
   }

}
