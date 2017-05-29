package hsbclearn.simpleapp;

import java.util.List;

public class IncrementalDataProcessor implements IDataProcessor {

	@Override
	public List<IntegerWrapper> processData(List<IntegerWrapper> data) {
		for(IntegerWrapper i : data) {
			i.setData(i.getData()+1);
		}
		return data;
	}

}
