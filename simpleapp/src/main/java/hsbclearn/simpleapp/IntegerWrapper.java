/**
 * 
 */
package hsbclearn.simpleapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author GZGRAJ
 *
 */
public class IntegerWrapper implements Iterable <Integer>{
	//Integer[] m_IOValues = {1,5,5,3,2,4}; // ch..
	List<Integer> m_IOValues = new ArrayList<Integer>();
	
	IntegerWrapper()
	{
		/*m_IOValues.add(1);
		m_IOValues.add(5);
		m_IOValues.add(3);
		m_IOValues.add(3);
		m_IOValues.add(2);
		m_IOValues.add(4);*/
	}
	
	void print()
	{
		for (Integer tmp : m_IOValues)
        	 System.out.println(tmp); 
		
	}
	public List<Integer> getRawData() {
		
		return m_IOValues;
	}
	
	public void add(Integer elem) {
		m_IOValues.add(elem);
		
	}
	@Override
	public Iterator<Integer> iterator() {
		
		return m_IOValues.iterator();
	}

}
