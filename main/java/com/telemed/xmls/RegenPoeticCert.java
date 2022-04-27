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

public class RegenPoeticCert extends TestBase {
	
	  public static String getInputXml_RegenPoeticCert(String user,String userLogin,String userPwd, String machName, String xid) {
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

			env.setAttribute("documentType","RegenPoeticCertificate");
			env.setAttribute("trader",user);
			env.setAttribute("traderLogin",userLogin);
			env.setAttribute("traderPassword",userPwd);
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid",xid);
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("RegenPoeticCertificate");
			payload.appendChild(regEnt);
			
			Element reg = doc.createElement("Regeneration");
			regEnt.appendChild(reg);
			reg.setAttribute("doNotAutoSendCertificate","T");
			
			Element machInfo = doc.createElement("MachineQuery");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);

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
