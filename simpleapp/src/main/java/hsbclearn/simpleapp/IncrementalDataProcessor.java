package hsbclearn.simpleapp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
@RequestScoped
public class IncrementalDataProcessor implements IDataProcessor {

	@Override
	public List<IntegerWrapper> processData(List<IntegerWrapper> data) {
		System.out.println("inc processor");
		for(IntegerWrapper i : data) {
			i.setData(i.getData()+1);
		}
		return data;
	}

}
