
package hsbclearn.simpleapp.JAXB;

/**
 * Czary
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;
//@XmlRootElement
@XmlRootElement(name="IntegerWrapper") // tu cie mam
public class MessageParser implements IMessageParser {
	public static class User {

        @XmlElement(name="Number")
        private List<Integer> numbers;

        public List<Integer> getNumbers() {
            return numbers;
        }

    }
	@XmlElement
	private User Numbers;
	public User getNumbersNode() {
	        return Numbers;
	    }
	@Override
	public String saveAsXML(List<IntegerWrapper> inList) {
		// bzdety
		return null;
	}

	@Override
	public List<IntegerWrapper> readXML(String xml) {
		
		List<IntegerWrapper> resultList = new ArrayList<IntegerWrapper>();
		List<Integer> tmpList = new ArrayList<Integer>();
		File inputFile = new File(xml);
		try {
			MessageParser access =  (MessageParser) JAXBContext.newInstance(MessageParser.class).createUnmarshaller().unmarshal(inputFile);
			tmpList = access.getNumbersNode().getNumbers();
			//resultList.addAll(access.getNumbersNode().getNumbers());
			for (Integer nn : tmpList) {
				resultList.add(new IntegerWrapper(nn)); // jak to zrobić na jednej liście
				//System.out.println(nn);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultList;
	}

	
}

