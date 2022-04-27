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

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.telemed.base.TestBase;

public class BRPE extends TestBase {
	
	  public static String getInputXmlBRPE(String compN,String jobName,String lac,String prodN, String machName, String lockID) {
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","XID_BRPE");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
		
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			reg.setAttribute("allowPartialActivation","T");
			reg.setAttribute("registerLAC",lac);
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);
			
			Element lockInfo = doc.createElement("LockingDetail");
			machInfo.appendChild(lockInfo);
			lockInfo.setAttribute("lockingID",lockID);

		
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("activatedQuantity","0" );
			item.setAttribute("quantity","1");
		
			
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
	  
	  public static String getInputXmlBRPE100(String compN,String jobName,String lac,String prodN, String machName) {
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","XID_BRPE");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			for (int j=1; j<=3; j++) {
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			reg.setAttribute("allowPartialActivation","T");
			reg.setAttribute("registerLAC",lac);
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName+j);

			for (int i=1; i<=3; i++) {
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodN+i);
			item.setAttribute("activatedQuantity","0" );
			item.setAttribute("quantity","1");
			}
			}
			
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
	  
	  public static String getInputXmlBRPE1(String compN,String group,String prodN,String machName,String machName1,String machName2,String lockID,String lockID1,String lockID2,String jobName) {
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			regEnt.appendChild(batchconfig);
			batchconfig.setAttribute("groupPubID",group);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("jobName",compN);
			batchconfig.setAttribute("processCode","EXECUTE");
		
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);
			
			Element lockInfo = doc.createElement("LockingDetail");
			machInfo.appendChild(lockInfo);
			lockInfo.setAttribute("lockingID",lockID);

		
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("quantity","1");
			item.setAttribute("quantityMode","AddQty");
			
			Element reg1 = doc.createElement("Registration");
			regEnt.appendChild(reg1);
			reg1.setAttribute("mode","Generation");
			
			Element machInfo1 = doc.createElement("ActivationMachineInfo");
			reg1.appendChild(machInfo1);
			machInfo1.setAttribute("machineName",machName1);
			
			Element lockInfo1 = doc.createElement("LockingDetail");
			machInfo1.appendChild(lockInfo1);
			lockInfo1.setAttribute("lockingID",lockID1);
		
			Element item1 = doc.createElement("Item");
			reg1.appendChild(item1);
			item1.setAttribute("productNum",prodN);
			item1.setAttribute("quantity","1");
			item1.setAttribute("quantityMode","AddQty");
			
			Element reg2 = doc.createElement("Registration");
			regEnt.appendChild(reg2);
			reg2.setAttribute("mode","Generation");
			
			Element machInfo2 = doc.createElement("ActivationMachineInfo");
			reg2.appendChild(machInfo2);
			machInfo2.setAttribute("machineName",machName2);
			
			Element lockInfo2 = doc.createElement("LockingDetail");
			machInfo2.appendChild(lockInfo2);
			lockInfo2.setAttribute("lockingID",lockID2);
		
			Element item2 = doc.createElement("Item");
			reg2.appendChild(item2);
			item2.setAttribute("productNum",prodN);
			item2.setAttribute("quantity","1");
			item2.setAttribute("quantityMode","AddQty");
			
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
	  

		
	  public static String getInputXmlBRPE1Trans(String compN,String group,String prodN,String machName,String machName1,String machName2,String lockID,String lockID1,String lockID2,String jobName, String transID) {
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

				env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
				env.setAttribute("trader","Poetic");
				env.setAttribute("languageCode","En");
				env.setAttribute("dtdRev","2.0");
				env.setAttribute("xid","Batch");
				
				Element payload = doc.createElement("Payload");
				rootElement.appendChild(payload);
				
				Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
				payload.appendChild(regEnt);
				
				Element batchconfig = doc.createElement("BatchConfiguration");
				regEnt.appendChild(batchconfig);
				batchconfig.setAttribute("groupPubID",group);
				batchconfig.setAttribute("endCustomerPublisherID",compN);
				batchconfig.setAttribute("jobName",compN);
				batchconfig.setAttribute("transactionID",transID);
				batchconfig.setAttribute("processCode","EXECUTE");
			
				Element reg = doc.createElement("Registration");
				regEnt.appendChild(reg);
				reg.setAttribute("mode","Generation");
				
				Element machInfo = doc.createElement("ActivationMachineInfo");
				reg.appendChild(machInfo);
				machInfo.setAttribute("machineName",machName);
				
				Element lockInfo = doc.createElement("LockingDetail");
				machInfo.appendChild(lockInfo);
				lockInfo.setAttribute("lockingID",lockID);

			
				Element item = doc.createElement("Item");
				reg.appendChild(item);
				item.setAttribute("productNum",prodN);
				item.setAttribute("quantity","1");
				item.setAttribute("quantityMode","AddQty");
				
				Element reg1 = doc.createElement("Registration");
				regEnt.appendChild(reg1);
				reg1.setAttribute("mode","Generation");
				
				Element machInfo1 = doc.createElement("ActivationMachineInfo");
				reg1.appendChild(machInfo1);
				machInfo1.setAttribute("machineName",machName1);
				
				Element lockInfo1 = doc.createElement("LockingDetail");
				machInfo1.appendChild(lockInfo1);
				lockInfo1.setAttribute("lockingID",lockID1);
			
				Element item1 = doc.createElement("Item");
				reg1.appendChild(item1);
				item1.setAttribute("productNum",prodN);
				item1.setAttribute("quantity","1");
				item1.setAttribute("quantityMode","AddQty");
				
				Element reg2 = doc.createElement("Registration");
				regEnt.appendChild(reg2);
				reg2.setAttribute("mode","Generation");
				
				Element machInfo2 = doc.createElement("ActivationMachineInfo");
				reg2.appendChild(machInfo2);
				machInfo2.setAttribute("machineName",machName2);
				
				Element lockInfo2 = doc.createElement("LockingDetail");
				machInfo2.appendChild(lockInfo2);
				lockInfo2.setAttribute("lockingID",lockID2);
			
				Element item2 = doc.createElement("Item");
				reg2.appendChild(item2);
				item2.setAttribute("productNum",prodN);
				item2.setAttribute("quantity","1");
				item2.setAttribute("quantityMode","AddQty");
				
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
	  
	  public static String getInputXmlBRPE2(String compN,String group,String prodN,String machName,String machName1,String machName2,String lockID,String lockID1,String jobName) {
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			regEnt.appendChild(batchconfig);
			batchconfig.setAttribute("groupPubID",group);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("jobName",compN);
			batchconfig.setAttribute("processCode","EXECUTE");
		
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);
			
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("quantity","2");
			item.setAttribute("quantityMode","AddQty");
			
			Element reg1 = doc.createElement("Registration");
			regEnt.appendChild(reg1);
			reg1.setAttribute("mode","Generation");
			
			Element machInfo1 = doc.createElement("ActivationMachineInfo");
			reg1.appendChild(machInfo1);
			machInfo1.setAttribute("machineName",machName1);
			
			Element lockInfo1 = doc.createElement("LockingDetail");
			machInfo1.appendChild(lockInfo1);
			lockInfo1.setAttribute("lockingID",lockID);
		
			Element item1 = doc.createElement("Item");
			reg1.appendChild(item1);
			item1.setAttribute("productNum",prodN);
			item1.setAttribute("quantity","2");
			item1.setAttribute("quantityMode","AddQty");
			
			Element reg2 = doc.createElement("Registration");
			regEnt.appendChild(reg2);
			reg2.setAttribute("mode","Generation");
			
			Element machInfo2 = doc.createElement("ActivationMachineInfo");
			reg2.appendChild(machInfo2);
			machInfo2.setAttribute("machineName",machName2);
			
			Element lockInfo2 = doc.createElement("LockingDetail");
			machInfo2.appendChild(lockInfo2);
			lockInfo2.setAttribute("lockingID",lockID1);
		
			Element item2 = doc.createElement("Item");
			reg2.appendChild(item2);
			item2.setAttribute("productNum",prodN);
			item2.setAttribute("quantity","2");
			item2.setAttribute("quantityMode","AddQty");
			
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
	  
	  public static String getInputXmlBRPE2Trans(String compN,String group,String prodN,String machName,String machName1,String machName2,String lockID,String lockID1,String jobName, String transID) {
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			regEnt.appendChild(batchconfig);
			batchconfig.setAttribute("groupPubID",group);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("jobName",compN);
			batchconfig.setAttribute("transactionID",transID);
			batchconfig.setAttribute("processCode","EXECUTE");
		
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);
			
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("quantity","2");
			item.setAttribute("quantityMode","AddQty");
			
			Element reg1 = doc.createElement("Registration");
			regEnt.appendChild(reg1);
			reg1.setAttribute("mode","Generation");
			
			Element machInfo1 = doc.createElement("ActivationMachineInfo");
			reg1.appendChild(machInfo1);
			machInfo1.setAttribute("machineName",machName1);
			
			Element lockInfo1 = doc.createElement("LockingDetail");
			machInfo1.appendChild(lockInfo1);
			lockInfo1.setAttribute("lockingID",lockID);
		
			Element item1 = doc.createElement("Item");
			reg1.appendChild(item1);
			item1.setAttribute("productNum",prodN);
			item1.setAttribute("quantity","2");
			item1.setAttribute("quantityMode","AddQty");
			
			Element reg2 = doc.createElement("Registration");
			regEnt.appendChild(reg2);
			reg2.setAttribute("mode","Generation");
			
			Element machInfo2 = doc.createElement("ActivationMachineInfo");
			reg2.appendChild(machInfo2);
			machInfo2.setAttribute("machineName",machName2);
			
			Element lockInfo2 = doc.createElement("LockingDetail");
			machInfo2.appendChild(lockInfo2);
			lockInfo2.setAttribute("lockingID",lockID1);
		
			Element item2 = doc.createElement("Item");
			reg2.appendChild(item2);
			item2.setAttribute("productNum",prodN);
			item2.setAttribute("quantity","2");
			item2.setAttribute("quantityMode","AddQty");
			
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
	  
	  public static String getInputXmlBRPE3(String compN,String group,String prodN,String machName,String machName1,String lockID,String lockID1,String lockID2,String lockID3,String jobName,String lockType,String lockType1 ) {
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			regEnt.appendChild(batchconfig);
			batchconfig.setAttribute("groupPubID",group);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("jobName",compN);
			batchconfig.setAttribute("processCode","EXECUTE");

			Element reg1 = doc.createElement("Registration");
			regEnt.appendChild(reg1);
			reg1.setAttribute("mode","Generation");
			
			Element machInfo1 = doc.createElement("ActivationMachineInfo");
			reg1.appendChild(machInfo1);
			machInfo1.setAttribute("machineName",machName);
			
			Element lockInfo1 = doc.createElement("LockingDetail");
			machInfo1.appendChild(lockInfo1);
			lockInfo1.setAttribute("lockingID",lockID);
			lockInfo1.setAttribute("lockingIDTypeCode",lockType);
			
			Element lockInfo2 = doc.createElement("LockingDetail");
			machInfo1.appendChild(lockInfo2);
			lockInfo2.setAttribute("lockingID",lockID1);
			lockInfo2.setAttribute("lockingIDTypeCode",lockType1);
		
			Element item1 = doc.createElement("Item");
			reg1.appendChild(item1);
			item1.setAttribute("productNum",prodN);
			item1.setAttribute("quantity","1");
			item1.setAttribute("quantityMode","AddQty");
			
			Element reg2 = doc.createElement("Registration");
			regEnt.appendChild(reg2);
			reg2.setAttribute("mode","Generation");
			
			Element machInfo2 = doc.createElement("ActivationMachineInfo");
			reg2.appendChild(machInfo2);
			machInfo2.setAttribute("machineName",machName1);
			
			Element lockInfo3 = doc.createElement("LockingDetail");
			machInfo2.appendChild(lockInfo3);
			lockInfo3.setAttribute("lockingID",lockID2);
			lockInfo3.setAttribute("lockingIDTypeCode",lockType);
			
			Element lockInfo4 = doc.createElement("LockingDetail");
			machInfo2.appendChild(lockInfo4);
			lockInfo4.setAttribute("lockingID",lockID3);
			lockInfo4.setAttribute("lockingIDTypeCode",lockType1);
		
			Element item2 = doc.createElement("Item");
			reg2.appendChild(item2);
			item2.setAttribute("productNum",prodN);
			item2.setAttribute("quantity","1");
			item2.setAttribute("quantityMode","AddQty");
			
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
		
	  public static String getInputXmlBRPE3Trans(String compN,String group,String prodN,String machName,String machName1,String lockID,String lockID1,String lockID2,String lockID3,String jobName,String lockType,String lockType1, String transID ) {
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			regEnt.appendChild(batchconfig);
			batchconfig.setAttribute("groupPubID",group);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("jobName",compN);
			batchconfig.setAttribute("transactionID",transID);
			batchconfig.setAttribute("processCode","EXECUTE");

			Element reg1 = doc.createElement("Registration");
			regEnt.appendChild(reg1);
			reg1.setAttribute("mode","Generation");
			
			Element machInfo1 = doc.createElement("ActivationMachineInfo");
			reg1.appendChild(machInfo1);
			machInfo1.setAttribute("machineName",machName);
			
			Element lockInfo1 = doc.createElement("LockingDetail");
			machInfo1.appendChild(lockInfo1);
			lockInfo1.setAttribute("lockingID",lockID);
			lockInfo1.setAttribute("lockingIDTypeCode",lockType);
			
			Element lockInfo2 = doc.createElement("LockingDetail");
			machInfo1.appendChild(lockInfo2);
			lockInfo2.setAttribute("lockingID",lockID1);
			lockInfo2.setAttribute("lockingIDTypeCode",lockType1);
		
			Element item1 = doc.createElement("Item");
			reg1.appendChild(item1);
			item1.setAttribute("productNum",prodN);
			item1.setAttribute("quantity","1");
			item1.setAttribute("quantityMode","AddQty");
			
			Element reg2 = doc.createElement("Registration");
			regEnt.appendChild(reg2);
			reg2.setAttribute("mode","Generation");
			
			Element machInfo2 = doc.createElement("ActivationMachineInfo");
			reg2.appendChild(machInfo2);
			machInfo2.setAttribute("machineName",machName1);
			
			Element lockInfo3 = doc.createElement("LockingDetail");
			machInfo2.appendChild(lockInfo3);
			lockInfo3.setAttribute("lockingID",lockID2);
			lockInfo3.setAttribute("lockingIDTypeCode",lockType);
			
			Element lockInfo4 = doc.createElement("LockingDetail");
			machInfo2.appendChild(lockInfo4);
			lockInfo4.setAttribute("lockingID",lockID3);
			lockInfo4.setAttribute("lockingIDTypeCode",lockType1);
		
			Element item2 = doc.createElement("Item");
			reg2.appendChild(item2);
			item2.setAttribute("productNum",prodN);
			item2.setAttribute("quantity","1");
			item2.setAttribute("quantityMode","AddQty");
			
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
	  public static String getInputXmlRPESinPrd(String compN,String group,String prodN,String machName,String isv1,String isv2,String isv3,String xid, String job) {
		  
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid",xid);
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			regEnt.appendChild(batchconfig);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("groupPubID",group);			
			batchconfig.setAttribute("jobName",job);
			batchconfig.setAttribute("processCode","EXECUTE");
		
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);
			
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("quantity","5");
			item.setAttribute("expireDate","20300430");
			item.setAttribute("quantityMode","AddQty");
			
			Element customProp1 = doc.createElement("CustomProperty");
			item.appendChild(customProp1);
			customProp1.setAttribute("publisherID","classId");
			customProp1.setAttribute("valueCode",isv1);
		
			Element customProp2 = doc.createElement("CustomProperty");
			item.appendChild(customProp2);
			customProp2.setAttribute("publisherID","className");
			customProp2.setAttribute("valueCode",isv2);
			
			Element customProp3 = doc.createElement("CustomProperty");
			item.appendChild(customProp3);
			customProp3.setAttribute("publisherID","activatedBy");
			customProp3.setAttribute("valueCode",isv3);		
			
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
	  	
 public static String getInputXmlRPEMultPrd(String compN,String group,String prodN,String machName2,String machName3,String machName4,String machName5,String isv1,String xid, String job) {
		  
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid",xid);
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element batchconfig = doc.createElement("BatchConfiguration");
			regEnt.appendChild(batchconfig);
			batchconfig.setAttribute("endCustomerPublisherID",compN);
			batchconfig.setAttribute("groupPubID",group);			
			batchconfig.setAttribute("jobName",job);
			batchconfig.setAttribute("processCode","EXECUTE");
		
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName2);
			
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodN);
			item.setAttribute("quantity","5");
			item.setAttribute("expireDate","20300430");
			item.setAttribute("quantityMode","AddQty");
			
			Element customProp1 = doc.createElement("CustomProperty");
			item.appendChild(customProp1);
			customProp1.setAttribute("publisherID","classId");
			customProp1.setAttribute("valueCode",isv1);
		
			Element customProp2 = doc.createElement("CustomProperty");
			item.appendChild(customProp2);
			customProp2.setAttribute("publisherID","className");
			customProp2.setAttribute("valueCode","asdasdsad");
			
			Element customProp3 = doc.createElement("CustomProperty");
			item.appendChild(customProp3);
			customProp3.setAttribute("publisherID","activatedBy");
			customProp3.setAttribute("valueCode","#456*822@@@");		
			
			Element reg1 = doc.createElement("Registration");
			regEnt.appendChild(reg1);
			reg1.setAttribute("mode","Generation");
			
			Element machInfo1 = doc.createElement("ActivationMachineInfo");
			reg1.appendChild(machInfo1);
			machInfo1.setAttribute("machineName",machName3);
			
			Element item1 = doc.createElement("Item");
			reg1.appendChild(item1);
			item1.setAttribute("productNum",prodN);
			item1.setAttribute("quantity","5");
			item1.setAttribute("expireDate","20300430");
			item1.setAttribute("quantityMode","AddQty");
			
			Element customProp4 = doc.createElement("CustomProperty");
			item1.appendChild(customProp4);
			customProp4.setAttribute("publisherID","classId");
			customProp4.setAttribute("valueCode",isv1);
		
			Element customProp5 = doc.createElement("CustomProperty");
			item1.appendChild(customProp5);
			customProp5.setAttribute("publisherID","className");
			customProp5.setAttribute("valueCode","25");
			
			Element customProp6 = doc.createElement("CustomProperty");
			item1.appendChild(customProp6);
			customProp6.setAttribute("publisherID","activatedBy");
			customProp6.setAttribute("valueCode","25");		
			
			Element reg2 = doc.createElement("Registration");
			regEnt.appendChild(reg2);
			reg2.setAttribute("mode","Generation");
			
			Element machInfo2 = doc.createElement("ActivationMachineInfo");
			reg2.appendChild(machInfo2);
			machInfo2.setAttribute("machineName",machName4);
			
			Element item2 = doc.createElement("Item");
			reg2.appendChild(item2);
			item2.setAttribute("productNum",prodN);
			item2.setAttribute("quantity","5");
			item2.setAttribute("expireDate","20300430");
			item2.setAttribute("quantityMode","AddQty");
			
			Element customProp7 = doc.createElement("CustomProperty");
			item2.appendChild(customProp7);
			customProp7.setAttribute("publisherID","classId");
			customProp7.setAttribute("valueCode",isv1);
		
			Element customProp8 = doc.createElement("CustomProperty");
			item2.appendChild(customProp8);
			customProp8.setAttribute("publisherID","className");
			customProp8.setAttribute("valueCode","This is the iSV value for the machine to identify a machine with unique ID");
			
			Element customProp9 = doc.createElement("CustomProperty");
			item2.appendChild(customProp9);
			customProp9.setAttribute("publisherID","activatedBy");
			customProp9.setAttribute("valueCode","151515");		
			
			Element reg3 = doc.createElement("Registration");
			regEnt.appendChild(reg3);
			reg3.setAttribute("mode","Generation");
			
			Element machInfo3 = doc.createElement("ActivationMachineInfo");
			reg3.appendChild(machInfo3);
			machInfo3.setAttribute("machineName",machName5);
			
			Element item3 = doc.createElement("Item");
			reg3.appendChild(item3);
			item3.setAttribute("productNum",prodN);
			item3.setAttribute("quantity","2");
			item3.setAttribute("expireDate","20300430");
			item3.setAttribute("quantityMode","AddQty");
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
 
 public static String getInputXmlRPC(String xid,String prod,String ars,String machName, String lockingID) {
	  
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

		env.setAttribute("documentType","RegenPoeticCertificate");
		env.setAttribute("trader","Poetic");
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
		
		Element actMachInfo = doc.createElement("ActivationMachineInfo");
		reg.appendChild(actMachInfo);
		
		Element lockInfo = doc.createElement("LockingDetail");
		actMachInfo.appendChild(lockInfo);
		lockInfo.setAttribute("lockingID",lockingID);
		lockInfo.setAttribute("lockingIDTypeCode","LID1736");
		
		Element customProp1 = doc.createElement("CustomProperty");
		reg.appendChild(customProp1);
		customProp1.setAttribute("publisherID","QTPSQ1736ARS");
		customProp1.setAttribute("type","SurveyProperty");
		customProp1.setAttribute("valueDescription",ars);
	
		Element customProp2 = doc.createElement("CustomProperty");
		reg.appendChild(customProp2);
		customProp2.setAttribute("publisherID","QTPSQ1736PROD");
		customProp2.setAttribute("type","SurveyProperty");
		customProp2.setAttribute("valueDescription",prod);
		
		Element noteInfo1 = doc.createElement("Notes");
		reg.appendChild(noteInfo1);
		noteInfo1.setAttribute("usageType","EXTERNAL");
		CDATASection cdata1 = doc.createCDATASection("This is external note.");
		noteInfo1.appendChild(cdata1);
		
		Element noteInfo2 = doc.createElement("Notes");
		reg.appendChild(noteInfo2);
		noteInfo2.setAttribute("usageType","INTERNAL");
		CDATASection cdata2 = doc.createCDATASection("This is internal note.");
		noteInfo2.appendChild(cdata2);
		
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
	  	
 public static String getInputXmlBRPE_1169_1(String lac,String machName,String lockID,String prodName, String qty) { 
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			reg.setAttribute("allowPartialActivation","T");
			reg.setAttribute("registerLAC",lac);
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);
			machInfo.setAttribute("machineName",machName);

			Element lockId = doc.createElement("LockingDetail");
			machInfo.appendChild(lockId);
			lockId.setAttribute("lockingID",lockID);
			
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodName);
			item.setAttribute("quantity",qty);
					
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
		
public static String getInputXmlBRPE_1169_2(String lac,String lockID,String prodName, String qty) { 
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

			env.setAttribute("documentType","BatchRegisterPoeticEntitlement");
			env.setAttribute("trader","Poetic");
			env.setAttribute("languageCode","En");
			env.setAttribute("dtdRev","2.0");
			env.setAttribute("xid","Batch");
			
			Element payload = doc.createElement("Payload");
			rootElement.appendChild(payload);
			
			Element regEnt = doc.createElement("BatchRegisterPoeticEntitlement");
			payload.appendChild(regEnt);
			
			Element reg = doc.createElement("Registration");
			regEnt.appendChild(reg);
			reg.setAttribute("mode","Generation");
			reg.setAttribute("allowPartialActivation","T");
			reg.setAttribute("registerLAC",lac);
			
			Element machInfo = doc.createElement("ActivationMachineInfo");
			reg.appendChild(machInfo);

			Element lockId = doc.createElement("LockingDetail");
			machInfo.appendChild(lockId);
			lockId.setAttribute("lockingID",lockID);
			
			Element item = doc.createElement("Item");
			reg.appendChild(item);
			item.setAttribute("productNum",prodName);
			item.setAttribute("quantity",qty);
					
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


