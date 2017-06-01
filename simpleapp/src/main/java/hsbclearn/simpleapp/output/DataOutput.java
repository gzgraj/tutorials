/**
 * 
 */
package hsbclearn.simpleapp.output;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;

import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.JAXB.MessageParser;
@Default
@Dependent
public class DataOutput implements IDataOutput {

	@Override
	public String writeData(List<IntegerWrapper> data) {
		//System.out.println(data);
		return data.toString();

		
	}

}