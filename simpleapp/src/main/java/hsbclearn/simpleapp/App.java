package hsbclearn.simpleapp;

import java.util.List;

import hsbclearn.simpleapp.JAXB.XMLDataInput;
import hsbclearn.simpleapp.JAXB.XMLDataOutput;

@SuppressWarnings("unused")
public class App { 

	public static void main(String[] args) {

      // IDataInput input = new DataInput();
       IDataInput input = new XMLDataInput();
       List<IntegerWrapper> data = input.getData();   
 
      System.out.println("aaa");
        //IDataProcessor processor = new DataProcessor();
       IDataProcessor processor = new IncrementalDataProcessor();
       List<IntegerWrapper> processedData = processor.processData(data);
       
        //IDataOutput output = new DataOutput();
        IDataOutput output = new XMLDataOutput();
        output.writeData(processedData);        
        
        
        
        
    }
}
