/**
 * 
 */
package hsbclearn.simpleapp.output;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IntegerWrapper;
@Default
@Dependent
public class DataOutput implements IDataOutput {

	@Override
	public String writeData(List<IntegerWrapper> data) {
		//System.out.println(data);
		return data.toString();

		
	}

}