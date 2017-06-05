package hsbclearn.simpleapp;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="IntegerWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLMessage {

	
	@XmlElementWrapper(name="Numbers")
   	private List <IntegerWrapper> dataNumbers;

	
	public List <IntegerWrapper> getList(){
		if (this.dataNumbers == null) 
			this.dataNumbers = new ArrayList<IntegerWrapper>();
		return this.dataNumbers;
	}
	
	
	public void setList(List<IntegerWrapper> inList){
			this.dataNumbers = inList;
	}

}
