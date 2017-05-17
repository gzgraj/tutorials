/**
 * 
 */
package hsbclearn.simpleapp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GZGRAJ
 *
 */
public class IntegerWrapper implements IIntegerWrapper {
	//Integer[] m_IOValues = {1,5,5,3,2,4}; // ch..
	List<Integer> m_IOValues = new ArrayList<Integer>();
	
	IntegerWrapper()
	{
		m_IOValues.add(1);
		m_IOValues.add(5);
		m_IOValues.add(3);
		m_IOValues.add(3);
		m_IOValues.add(2);
		m_IOValues.add(4);
	}
	/* (non-Javadoc)
	 * @see hsbclearn.simpleapp.IIntegerWrapper#getData()
	 */
	@Override
	public List<Integer> getRawData() {
		
		return m_IOValues;
	}

}
