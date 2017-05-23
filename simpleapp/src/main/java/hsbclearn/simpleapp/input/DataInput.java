/**
 * 
 */
package hsbclearn.simpleapp.input;

import java.util.ArrayList;
import java.util.List;

import hsbclearn.simpleapp.IDataInput;
import hsbclearn.simpleapp.IntegerWrapper;

public class DataInput implements IDataInput {

	private static int[] data = {10, 1, 2, 3, 4, 10}; 
	
	@Override
	public List<IntegerWrapper> getData() {
		 List <IntegerWrapper> result = new ArrayList<IntegerWrapper>();
		 
		 for(int i : data) {
			 result.add(new IntegerWrapper(i));
		 }
		 
		 return result;
	}

}