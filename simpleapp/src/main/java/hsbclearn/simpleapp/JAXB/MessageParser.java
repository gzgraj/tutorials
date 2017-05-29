
package hsbclearn.simpleapp.JAXB;

/**
 * Czary
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

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

