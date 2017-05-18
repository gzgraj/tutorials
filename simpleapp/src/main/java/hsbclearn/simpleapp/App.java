package hsbclearn.simpleapp;

import java.util.List;

public class App { 

	public static void main(String[] args) {
        IDataInput input = new DataInput();
        List<IntegerWrapper> data = input.getData();        
        
        IDataProcessor processor = new DataProcessor();
        List<IntegerWrapper> processedData = processor.processData(data);
        
        IDataOutput output = new DataOutput();
        output.writeData(processedData);        
    }
}
