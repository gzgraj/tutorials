package hsbclearn.simpleapp.examples;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import hsbclearn.simpleapp.IDataInput;
import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IDataProcessor;
//import hsbclearn.simpleapp.IDataProcessor;
import hsbclearn.simpleapp.IncrementalDataProcessor;
import hsbclearn.simpleapp.JAXB.XMLDataInput;
import hsbclearn.simpleapp.JAXB.XmlInputOutput;
//@ApplicationScoped
//@RequestScoped
@Default
@Dependent
public class XMLProcessController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -754288185060476690L;
	String dataReaded;
	@Inject @JmsInputOutput
	IDataOutput jmsOut ;
	@Inject @JmsInputOutput
	IDataInput jmsIn;// = new JMSDataInput();
	@Inject
	IDataOutput consoleOut;// = new DataOutput();
	@Inject @XmlInputOutput
	IDataInput input;// = new XMLDataInput();
	@Inject
	IDataProcessor processor;// = new IncrementalDataProcessor();
	public void run() {
		System.out.println("Wysyłam...");
        jmsOut.writeData(processor.processData(input.getData()));
       
	
		System.out.println("Odbieram...");
		dataReaded = (consoleOut.writeData(processor.processData(jmsIn.getData())).toString());
		//processor.processData(jmsIn.getData());
	}
	public String getdataReaded() {
		return dataReaded;
	}
}
