
package hsbclearn.simpleapp.StAX;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;

public class MessageParser implements IMessageParser {

	@Override
	public String saveAsXML(List<IntegerWrapper> inList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IntegerWrapper> readXML(String xml) {
		
		List<IntegerWrapper> resultList = new ArrayList<IntegerWrapper>();
		boolean bNumbers = false; 
		boolean bIntegerWrapper = false;
		 
		try {
			
		        XMLInputFactory factory = XMLInputFactory.newInstance();
		        XMLEventReader r = factory.createXMLEventReader
	                       (xml, new FileInputStream(xml));

		        // ignorecase jeszcze
		        
		        while (r.hasNext()) {
		           XMLEvent e = r.nextEvent();
		           if (e.isStartElement() && e.toString().equals("<IntegerWrapper>")) 
		        	   bIntegerWrapper = true;
		         
		        	   
		           if (bIntegerWrapper && e.isStartElement() && e.toString().equals("<Numbers>")) 
		        	   bNumbers = true;
		           else
		        	   if (bIntegerWrapper && e.isEndElement() && e.toString().equals("</Numbers>")) 
			        	   bNumbers = false;
		        	   
		           if (bNumbers && e.isCharacters() && !java.util.regex.Pattern.compile("\\s").matcher(e.toString()).find())
		        	   resultList.add(new IntegerWrapper(Integer.parseInt(e.toString())));
		            	// System.out.println(e)
		        }
		       
		 
		} catch (FileNotFoundException e) {
			System.out.println("Brak pliku" +xml);
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	
}

