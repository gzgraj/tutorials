
package hsbclearn.simpleapp.JAXB;

/**
 * Czary
 */


import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.XMLMessage;

public class MessageParser implements IMessageParser {
	
	

   
	@Override
	public String saveAsXML(List<IntegerWrapper> inList) {
		
		XMLMessage numbers = new XMLMessage();
		StringWriter stringWriter = new StringWriter();
		numbers.setList(inList);
		
		JAXBContext context;
		System.out.println("saveAsXML...");
		try {
			context = JAXBContext.newInstance(XMLMessage.class);
			Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        //m.marshal(numbers, System.out);
	        m.marshal(numbers, stringWriter);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return stringWriter.toString();
	}

	@Override
	public List<IntegerWrapper> readXML(String xml) {
		
		
		//File inputFile = new File(xml);
		XMLMessage numbers = null;
	
		try {
			//numbers =  (XMLMessage) JAXBContext.newInstance(XMLMessage.class).createUnmarshaller().unmarshal(inputFile);
			numbers =  (XMLMessage) JAXBContext.newInstance(XMLMessage.class).createUnmarshaller().unmarshal(new StringReader(xml));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numbers.getList();
	}

	
}

