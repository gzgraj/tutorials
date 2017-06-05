package hsbclearn.simpleapp.JAXB;

import java.util.List;

import javax.enterprise.context.Dependent;
import hsbclearn.simpleapp.IDataInput;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;

@XmlInputOutput
@Dependent
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
