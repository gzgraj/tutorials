package hsbclearn.simpleapp;

import java.util.ArrayList;
import java.util.List;

import hsbclearn.simpleapp.JAXB.XMLDataInput;
import hsbclearn.simpleapp.JAXB.XMLDataOutput;
//import hsbclearn.simpleapp.StAX.XMLDataInput;
//import hsbclearn.simpleapp.JAXP.XMLDataInput;
import hsbclearn.simpleapp.input.DataInput;
import hsbclearn.simpleapp.output.DataOutput;

@SuppressWarnings("unused")
public class App { 

	public static void main(String[] args) {
      // IDataInput input = new DataInput();
       IDataInput input = new XMLDataInput();
       List<IntegerWrapper> data = input.getData();   
 
       
        //IDataProcessor processor = new DataProcessor();
       IDataProcessor processor = new IncrementalDataProcessor();
       List<IntegerWrapper> processedData = processor.processData(data);
       
        //IDataOutput output = new DataOutput();
        IDataOutput output = new XMLDataOutput();
        output.writeData(processedData);        
        
        
        
        
    }
}
