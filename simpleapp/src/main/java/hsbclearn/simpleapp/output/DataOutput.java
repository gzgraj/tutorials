/**
 * 
 */
package hsbclearn.simpleapp;

import java.util.List;


import hsbclearn.simpleapp.IntegerWrapper;

public class DataOutput implements IDataOutput {

	@Override
	public void writeData(List<IntegerWrapper> data) {
		System.out.println(data);
	}

}