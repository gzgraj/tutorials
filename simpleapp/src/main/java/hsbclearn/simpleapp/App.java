package hsbclearn.simpleapp;

import java.util.Set;
import java.util.TreeSet;

public class App { 

	public static void main(String[] args) {
        System.out.println( "Hello World!" );
         IntegerWrapper OurRawData = new IntegerWrapper();
         DataInput OurData = new DataInput();
         
         OurData.initValues(OurRawData);
        
		for (Integer tmp : OurData.getValues() )
        	 System.out.println(tmp); 
		
		 System.out.println( "----------------" );
		 Set <Integer> ts = new TreeSet <Integer>();
	     
		 for (Integer tmp : OurData.getValues() )
			 ts.add(tmp);
	     
	      
	      for (Integer tmp : ts )
	        	 System.out.println(tmp); 
	      
    }
	
}
