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
public class DataInput {
	
	List<Integer> m_DPValues = new ArrayList<Integer>();
	//IIntegerWrapper m_Values;
	DataInput()
	{
		
	}
	public void initValues( IIntegerWrapper Values)
	{
		m_DPValues =  Values.getRawData();
	}
	public List<Integer> getValues()
	{
		return m_DPValues;
	}
}
