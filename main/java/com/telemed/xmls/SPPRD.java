package com.telemed.xmls;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.telemed.base.TestBase;

public class SPPRD extends TestBase {
	 
 public static String getInputXmlSetPoeticProduct1(String xid,String prodName,String condition) {
	  
	  String inPutXml = "";

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// poetic elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Poetic");
		doc.appendChild(rootElement);
		rootElement.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttribute("xsi:noNamespaceSchemaLocation","poetic.xsd");

		// env elements
		Element env = doc.createElement("Envelope");
		rootElement.appendChild(env);
		env.setAttribute("documentType","SetPoeticProduct");
		env.setAttribute("trader","Poetic");
		env.setAttribute("languageCode","En");
		env.setAttribute("dtdRev","2.0");
		env.setAttribute("xid",xid);
		
		Element payload = doc.createElement("Payload");
		rootElement.appendChild(payload);
		
		Element setPrd = doc.createElement("SetPoeticProduct");
		payload.appendChild(setPrd);
		
		Element prodt = doc.createElement("Product");
		setPrd.appendChild(prodt);
		prodt.setAttribute("act","update");
		prodt.setAttribute("canCaptureLicensePurchaseDate","F");
		prodt.setAttribute("canPurchaseUpgrade","F");
		prodt.setAttribute("endDate","20390810");
		prodt.setAttribute("eulaID","EULA");
		prodt.setAttribute("familyCode","FMLY");
		prodt.setAttribute("isEntHiddenOnAssignment","T");
		prodt.setAttribute("isMoveConfCodeRequired","F");
		prodt.setAttribute("isRehostConfCodeRequired","F");
		prodt.setAttribute("languageCode","US");
		prodt.setAttribute("licenseVersion","1.0");
		prodt.setAttribute("name",prodName);
		prodt.setAttribute("onlyInUSFlag","T");
		prodt.setAttribute("platformCode","WIN");
		prodt.setAttribute("productNum",prodName);
		prodt.setAttribute("productShippingUnit","10");
		prodt.setAttribute("productTypeCode","LIC");
		prodt.setAttribute("startDate","20150810");
		prodt.setAttribute("supportOptionCode","SUPP");
		prodt.setAttribute("version","10");
		
		Element comp = doc.createElement("ComponentLink");
		prodt.appendChild(comp);
		comp.setAttribute("componentCondition",condition);
		comp.setAttribute("publisherID","Compo2389D1");
		comp.setAttribute("quantity","1");
		comp.setAttribute("quantityCalculationTypeCode","MULT");
				
		DOMSource source = new DOMSource(doc);
		
		// write the xml content into  String
		
		StringWriter writer = new StringWriter();
       StreamResult result = new StreamResult(writer);
       TransformerFactory tf = TransformerFactory.newInstance();
       Transformer transformer = tf.newTransformer();
       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
       transformer.transform(source, result);
       inPutXml = writer.toString();

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	  return inPutXml;

 }
	
 public static String getInputXmlSetPoeticProduct2(String xid,String prodName,String condition) {
	  
	  String inPutXml = "";

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// poetic elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Poetic");
		doc.appendChild(rootElement);
		rootElement.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttribute("xsi:noNamespaceSchemaLocation","poetic.xsd");

		// env elements
		Element env = doc.createElement("Envelope");
		rootElement.appendChild(env);
		env.setAttribute("documentType","SetPoeticProduct");
		env.setAttribute("trader","Poetic");
		env.setAttribute("languageCode","En");
		env.setAttribute("dtdRev","2.0");
		env.setAttribute("xid",xid);
		
		Element payload = doc.createElement("Payload");
		rootElement.appendChild(payload);
		
		Element setPrd = doc.createElement("SetPoeticProduct");
		payload.appendChild(setPrd);
		
		Element prodt = doc.createElement("Product");
		setPrd.appendChild(prodt);
		prodt.setAttribute("act","update");
		prodt.setAttribute("canCaptureLicensePurchaseDate","F");
		prodt.setAttribute("canPurchaseUpgrade","F");
		prodt.setAttribute("endDate","20390810");
		prodt.setAttribute("eulaID","EULA");
		prodt.setAttribute("familyCode","FMLY");
		prodt.setAttribute("isEntHiddenOnAssignment","T");
		prodt.setAttribute("isMoveConfCodeRequired","F");
		prodt.setAttribute("isRehostConfCodeRequired","F");
		prodt.setAttribute("languageCode","US");
		prodt.setAttribute("licenseVersion","1.0");
		prodt.setAttribute("name",prodName);
		prodt.setAttribute("onlyInUSFlag","T");
		prodt.setAttribute("platformCode","WIN");
		prodt.setAttribute("productNum",prodName);
		prodt.setAttribute("productShippingUnit","10");
		prodt.setAttribute("productTypeCode","LIC");
		prodt.setAttribute("startDate","20150810");
		prodt.setAttribute("supportOptionCode","SUPP");
		prodt.setAttribute("version","10");
		
		Element comp1 = doc.createElement("ComponentLink");
		prodt.appendChild(comp1);
		comp1.setAttribute("componentCondition",condition);
		comp1.setAttribute("publisherID","Compo2389D1");
		comp1.setAttribute("quantity","1");
		comp1.setAttribute("quantityCalculationTypeCode","MULT");
		
		Element comp2 = doc.createElement("ComponentLink");
		prodt.appendChild(comp2);
		comp2.setAttribute("componentCondition",condition);
		comp2.setAttribute("publisherID","Compo2389D1");
		comp2.setAttribute("quantity","1");
		comp2.setAttribute("quantityCalculationTypeCode","MULT");
				
		DOMSource source = new DOMSource(doc);
		
		// write the xml content into  String
		
		StringWriter writer = new StringWriter();
      StreamResult result = new StreamResult(writer);
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      transformer.transform(source, result);
      inPutXml = writer.toString();

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	  return inPutXml;

}
 
 
 public static String getInputXmlSetPoeticProduct3(String xid,String prodName,String condition, String condition1, String condition2) {
	  
	  String inPutXml = "";

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// poetic elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Poetic");
		doc.appendChild(rootElement);
		rootElement.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttribute("xsi:noNamespaceSchemaLocation","poetic.xsd");

		// env elements
		Element env = doc.createElement("Envelope");
		rootElement.appendChild(env);
		env.setAttribute("documentType","SetPoeticProduct");
		env.setAttribute("trader","Poetic");
		env.setAttribute("languageCode","En");
		env.setAttribute("dtdRev","2.0");
		env.setAttribute("xid",xid);
		
		Element payload = doc.createElement("Payload");
		rootElement.appendChild(payload);
		
		Element setPrd = doc.createElement("SetPoeticProduct");
		payload.appendChild(setPrd);
		
		Element prodt = doc.createElement("Product");
		setPrd.appendChild(prodt);
		prodt.setAttribute("act","update");
		prodt.setAttribute("canCaptureLicensePurchaseDate","F");
		prodt.setAttribute("canPurchaseUpgrade","F");
		prodt.setAttribute("endDate","20390810");
		prodt.setAttribute("eulaID","EULA");
		prodt.setAttribute("familyCode","FMLY");
		prodt.setAttribute("isEntHiddenOnAssignment","T");
		prodt.setAttribute("isMoveConfCodeRequired","F");
		prodt.setAttribute("isRehostConfCodeRequired","F");
		prodt.setAttribute("languageCode","US");
		prodt.setAttribute("licenseVersion","1.0");
		prodt.setAttribute("name",prodName);
		prodt.setAttribute("onlyInUSFlag","T");
		prodt.setAttribute("platformCode","WIN");
		prodt.setAttribute("productNum",prodName);
		prodt.setAttribute("productShippingUnit","10");
		prodt.setAttribute("productTypeCode","LIC");
		prodt.setAttribute("startDate","20150810");
		prodt.setAttribute("supportOptionCode","SUPP");
		prodt.setAttribute("version","10");
		
		Element comp1 = doc.createElement("ComponentLink");
		prodt.appendChild(comp1);
		comp1.setAttribute("componentCondition",condition);
		comp1.setAttribute("publisherID","Compo2389D1");
		comp1.setAttribute("quantity","1");
		comp1.setAttribute("quantityCalculationTypeCode","MULT");
		
		Element comp2 = doc.createElement("ComponentLink");
		prodt.appendChild(comp2);
		comp2.setAttribute("componentCondition",condition1);
		comp2.setAttribute("publisherID","Compo2389D2");
		comp2.setAttribute("quantity","4");
		comp2.setAttribute("quantityCalculationTypeCode","FIXED");
		
		Element comp3 = doc.createElement("ComponentLink");
		prodt.appendChild(comp3);
		comp3.setAttribute("componentCondition",condition2);
		comp3.setAttribute("publisherID","Compo2389D3");
		comp3.setAttribute("quantity","1");
		comp3.setAttribute("quantityCalculationTypeCode","MULT");
		
		Element comp4 = doc.createElement("ComponentLink");
		prodt.appendChild(comp4);
		comp4.setAttribute("componentCondition","");
		comp4.setAttribute("publisherID","Compo2389D4");
		comp4.setAttribute("quantity","1");
		comp4.setAttribute("quantityCalculationTypeCode","MULT");
				
		DOMSource source = new DOMSource(doc);
		
		// write the xml content into  String
		
		StringWriter writer = new StringWriter();
     StreamResult result = new StreamResult(writer);
     TransformerFactory tf = TransformerFactory.newInstance();
     Transformer transformer = tf.newTransformer();
     transformer.setOutputProperty(OutputKeys.INDENT, "yes");
     transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
     transformer.transform(source, result);
     inPutXml = writer.toString();

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	  return inPutXml;

}
	 	

		

}


