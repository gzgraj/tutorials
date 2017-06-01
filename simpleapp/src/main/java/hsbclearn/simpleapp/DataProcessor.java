/**
 * 
 */
package hsbclearn.simpleapp;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import javax.enterprise.context.Dependent;

import hsbclearn.simpleapp.IDataProcessor;
import hsbclearn.simpleapp.IntegerWrapper;

public class DataProcessor implements IDataProcessor {

	@Override
	public List<IntegerWrapper> processData(List<IntegerWrapper> data) {
		List<IntegerWrapper> result = new ArrayList<IntegerWrapper>();

		TreeSet<IntegerWrapper> sortedUnique = new TreeSet<IntegerWrapper>(data);
		result.addAll(sortedUnique);
		
		Integer sum = sum(result);
		result.add(new IntegerWrapper(sum));
				
		
		return result;
	}
	
	private Integer sum(Collection<IntegerWrapper> data) {
		Integer result = 0;
		
		for(IntegerWrapper i : data) {
			result += i.getData();
		}
		
		return result;
	}

}