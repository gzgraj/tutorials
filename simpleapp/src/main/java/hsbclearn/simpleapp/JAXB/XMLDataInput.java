package hsbclearn.simpleapp.JAXB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import hsbclearn.simpleapp.IDataInput;
import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;

public class XMLDataInput implements IDataInput {

	@Override
	public List<IntegerWrapper> getData() {
		//final String filename = "./src/main/java/hsbclearn/simpleapp/data/ifile.xml";  // zastąpić
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<IntegerWrapper>"+
				"<Numbers>"+
				"<dataNumbers>"+
				"<Number>21</Number>"+
				" </dataNumbers>" +
				"<dataNumbers>"+
				"	<Number>10</Number>"+
				"</dataNumbers>"+
				"</Numbers>"+
				"<FakeNumbers>"+
				"<Number>66</Number>"+
				"	<Number>666</Number>"+
				"</FakeNumbers>"+
			"</IntegerWrapper>";
		IMessageParser msgParser = new MessageParser();
		
		return msgParser.readXML(xml);
	}

	

	@Override
	public String getDataAsString() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
