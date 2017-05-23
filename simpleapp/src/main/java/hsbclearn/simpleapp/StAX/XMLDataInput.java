package hsbclearn.simpleapp.StAX;

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
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;

public class XMLDataInput implements IDataInput {

	@Override
	public List<IntegerWrapper> getData() {
		final String filename = "./src/main/java/hsbclearn/simpleapp/data/ifile.xml";  // zastąpić
		IMessageParser msgParser = new MessageParser();
		
		return msgParser.readXML(filename);
	}

}
