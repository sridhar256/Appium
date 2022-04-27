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

public class BUPC extends TestBase {
	
	  public static String getInputXmlBUPC1(String compN,String group,String jobName, String prodN,String machName) {
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

			env.setAttribute("documentType","BatchUpgradePoeticCertificate");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element upgCrt = doc.createElement("BatchUpgradePoeticCertificate");
			payload.appendChild(upgCrt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			upgCrt.appendChild(batchconfig);
			batchconfig.setAttribute("groupPubID",group);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("jobName",jobName);
			batchconfig.setAttribute("processCode","EXECUTE");
			batchconfig.setAttribute("selectionCode","ALL");
			batchconfig.setAttribute("errorHandlingCode","CONTINUE");
			batchconfig.setAttribute("resultOutputCode","NONE");
			batchconfig.setAttribute("emailKeysTo","test@ocs.com");
			batchconfig.setAttribute("emailReportTo","test@ocs.com");
			batchconfig.setAttribute("emailLanguageCode","EN");
			batchconfig.setAttribute("auJobPubID",jobName);
		
			Element upg = doc.createElement("Upgrade");
			upgCrt.appendChild(upg);
			upg.setAttribute("useQtyCalculator","T");
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			upg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);
			
			Element item = doc.createElement("UpgradeItem");
			upg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("quantity","10");
			item.setAttribute("quantityMode","AddQty");
					
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
	  

		
	  public static String getInputXmlBUPC1Trans(String compN,String group,String jobName, String prodN,String machName, String transID) {
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

			env.setAttribute("documentType","BatchUpgradePoeticCertificate");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element upgCrt = doc.createElement("BatchUpgradePoeticCertificate");
			payload.appendChild(upgCrt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			upgCrt.appendChild(batchconfig);
			batchconfig.setAttribute("groupPubID",group);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("jobName",jobName);
			batchconfig.setAttribute("transactionID",transID);
			batchconfig.setAttribute("processCode","EXECUTE");
			batchconfig.setAttribute("selectionCode","ALL");
			batchconfig.setAttribute("errorHandlingCode","CONTINUE");
			batchconfig.setAttribute("resultOutputCode","NONE");
			batchconfig.setAttribute("emailKeysTo","test@ocs.com");
			batchconfig.setAttribute("emailReportTo","test@ocs.com");
			batchconfig.setAttribute("emailLanguageCode","EN");
			batchconfig.setAttribute("auJobPubID",jobName);
		
			Element upg = doc.createElement("Upgrade");
			upgCrt.appendChild(upg);
			upg.setAttribute("useQtyCalculator","T");
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			upg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);
			
			Element item = doc.createElement("UpgradeItem");
			upg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("quantity","10");
			item.setAttribute("quantityMode","AddQty");
					
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


