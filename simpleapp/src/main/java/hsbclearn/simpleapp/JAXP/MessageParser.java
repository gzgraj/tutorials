package hsbclearn.simpleapp.JAXP;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MessageParser extends DefaultHandler implements IMessageParser {
	private boolean bNumbers = false;
	private boolean bNumber = false;
	private boolean bIntegerWrapper = false;
	List<IntegerWrapper> resultList = new ArrayList<IntegerWrapper>();
	@Override
	public String saveAsXML(List<IntegerWrapper> inList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IntegerWrapper> readXML(String xml) {
		
		try {	
	         File inputFile = new File(xml);
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         DefaultHandler userhandler = this ;//new UserHandler();
	         /* inline
	         DefaultHandler userhandler2 = new DefaultHandler(){ public void startElement(String uri, 
	        		   String localName, String qName, Attributes attributes)
	        				      throws SAXException { System.out.println(qName); }};
	        				      */
	         saxParser.parse(inputFile, userhandler);     
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return resultList;
	}
	 @Override
	   public void startElement(String uri, 
	   String localName, String qName, Attributes attributes)
	      throws SAXException {
		 System.out.println(qName); 
		 if (qName.equalsIgnoreCase("IntegerWrapper")) {
			 bIntegerWrapper = true;
		 }
		 else
		 	if (qName.equalsIgnoreCase("Numbers")) {
		 		bNumbers = true;
		 	}
		 	else
		 		if (qName.equalsIgnoreCase("Number")) {
			 		bNumber = true;
			 	}
		 		else
		 			bNumbers = false;
	   }
	 
	 @Override
	 public void characters(char ch[], int start, int length) throws SAXException {
		 if (bIntegerWrapper) {
		     if (bNumbers) {
		    	 if (bNumber) {
		    		 System.out.println("Number[]: " + new String(ch, start, length));
		    		 resultList.add(new IntegerWrapper(Integer.parseInt(new String(ch, start, length))));
		    		 bNumber = false;
		    	 }
		     }
		 }
	 }
}
