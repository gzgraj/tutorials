package hsbclearn.simpleapp;

import java.util.List;

public interface IMessageParser {
	String saveAsXML(List<IntegerWrapper> inList);
	 List<IntegerWrapper> readXML(String xml);



}
