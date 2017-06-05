package hsbclearn.simpleapp.JAXB;

import java.util.List;

import javax.enterprise.context.Dependent;
import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;


@XmlInputOutput
@Dependent
public class XMLDataOutput implements IDataOutput {

	@Override
	public String writeData(List<IntegerWrapper> data) {
		IMessageParser msgParser = new MessageParser();
		return msgParser.saveAsXML(data);
		//return null;
	}

}
