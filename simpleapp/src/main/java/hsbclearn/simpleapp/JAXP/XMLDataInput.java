package hsbclearn.simpleapp.JAXP;

import java.util.List;
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

	@Override
	public String getDataAsString() {
		// TODO Auto-generated method stub
		return null;
	}

}
