package hsbclearn.simpleapp;




public class App { 

	public static void main(String[] args) {
        System.out.println( "Hello World!" );
        
        DataInput inOutData = new DataInput();  // Z zainicjowaniem tymczasowo w konstruktorze
        DataProcessor dataProcessor = new DataProcessor();
        DataOutput dataOutput = new DataOutput();
        System.out.println( "----- original data -----------" );
        dataOutput.print(inOutData.getValues());
        dataProcessor.Run(inOutData.getValues());
		System.out.println( "----- after processing -----------" );
		dataOutput.print(inOutData.getValues());
		
	      
	}
	
}
