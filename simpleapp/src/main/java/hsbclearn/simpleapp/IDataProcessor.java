package hsbclearn.simpleapp;

import java.util.List;

public interface IDataProcessor {
	List<IntegerWrapper> processData(List<IntegerWrapper> data);
}