package hsbclearn.simpleapp.JAXB;

import java.util.List;

import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;

public class XMLDataOutput implements IDataOutput {

	@Override
	public String writeData(List<IntegerWrapper> data) {
		IMessageParser msgParser = new MessageParser();
		return msgParser.saveAsXML(data);
		//return null;
	}

}
