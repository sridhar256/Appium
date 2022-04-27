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

public class SetPoeticEnt_100Prod extends TestBase {
    
    
    public static String getInputXmlSPE100(String lac,String compN,String prodN) {
    	String inPutXml = "";

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// poetic elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Poetic");
		doc.appendChild(rootElement);

		// env elements
		Element env = doc.createElement("Envelope");
		rootElement.appendChild(env);

		env.setAttribute("documentType","SetPoeticEntitlement");
		env.setAttribute("trader","Poetic");
		env.setAttribute("languageCode","En");
		env.setAttribute("dtdRev","2.0");
		env.setAttribute("xid","XID_SPE");
		
		Element payload = doc.createElement("Payload");
		rootElement.appendChild(payload);
		
		Element regEnt = doc.createElement("SetPoeticEntitlement");
		payload.appendChild(regEnt);
		
		Element reg = doc.createElement("Entitlement");
		regEnt.appendChild(reg);
		reg.setAttribute("LACGenMethod","NoLACGen");

		for (int i=1; i<=100; i++) {
		Element item = doc.createElement("Item");
		reg.appendChild(item);
	    item.setAttribute("entitlementLAC",lac );
		item.setAttribute("productNum",prodN+i);
		item.setAttribute("quantity","100");
		}
		
		Element part = doc.createElement("Partner");
		reg.appendChild(part);
		part.setAttribute("role","SldCo");
		part.setAttribute("companyTypeCode","BUS");
		part.setAttribute("name",compN);
		part.setAttribute("publisherID",compN);
		
		Element add = doc.createElement("Address");
		part.appendChild(add);
		add.setAttribute("city","Austin");
		add.setAttribute("postalCode","12345");
		add.setAttribute("province","TX");
		add.setAttribute("country","USA");
		add.setAttribute("countryName","United States");
		add.setAttribute("countryISO2Code","US");
		Element Stre = doc.createElement("Street");
		add.appendChild(Stre);
		Stre.setAttribute("addr","123 Street");
		
		Element cont = doc.createElement("Contact");
		part.appendChild(cont);
		cont.setAttribute("role","ECOADMIN");
		cont.setAttribute("email","User@"+compN+".com");
		cont.setAttribute("lastName","LN_"+compN);
		cont.setAttribute("firstName","FN_"+compN);
			
		Element add1 = doc.createElement("Address");
		cont.appendChild(add1);
		add1.setAttribute("city",compN);
		add1.setAttribute("province","TX");
		add1.setAttribute("postalCode","12458");
		add1.setAttribute("country","USA");
		add1.setAttribute("countryName","United States");
		add1.setAttribute("countryISO2Code","US");
		Element Stre1 = doc.createElement("Street");
		add1.appendChild(Stre1);
		Stre1.setAttribute("addr","123 Street");

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
    
    public static String getInputXmlSPE100Grp(String lac,String compN,String prodN, String group) {
    	String inPutXml = "";

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// poetic elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Poetic");
		doc.appendChild(rootElement);

		// env elements
		Element env = doc.createElement("Envelope");
		rootElement.appendChild(env);

		env.setAttribute("documentType","SetPoeticEntitlement");
		env.setAttribute("trader","Poetic");
		env.setAttribute("languageCode","En");
		env.setAttribute("dtdRev","2.0");
		env.setAttribute("xid","XID_SPE");
		
		Element payload = doc.createElement("Payload");
		rootElement.appendChild(payload);
		
		Element regEnt = doc.createElement("SetPoeticEntitlement");
		payload.appendChild(regEnt);
		
		Element reg = doc.createElement("Entitlement");
		regEnt.appendChild(reg);
		reg.setAttribute("LACGenMethod","NoLACGen");

		for (int i=1; i<=100; i++) {
		Element item = doc.createElement("Item");
		reg.appendChild(item);
	    item.setAttribute("entitlementLAC",lac );
		item.setAttribute("productNum",prodN+i);
		item.setAttribute("quantity","100");
		}
		
		Element grp = doc.createElement("GroupDetail");
		reg.appendChild(grp);
		grp.setAttribute("publisherID",group);
		
		Element part = doc.createElement("Partner");
		reg.appendChild(part);
		part.setAttribute("role","SldCo");
		part.setAttribute("companyTypeCode","BUS");
		part.setAttribute("name",compN);
		part.setAttribute("publisherID",compN);
		
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