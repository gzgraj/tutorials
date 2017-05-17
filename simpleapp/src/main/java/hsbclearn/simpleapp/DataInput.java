/**
 * 
 */
package hsbclearn.simpleapp;




/**
 * @author GZGRAJ
 *
 */
public class DataInput {
	
	
	IntegerWrapper m_InOutValues = new IntegerWrapper();
	
	DataInput()
	{
		initValues();
	}
	public void initValues()
	{
		m_InOutValues.add(1);
		m_InOutValues.add(5);
		m_InOutValues.add(3);
		m_InOutValues.add(3);
		m_InOutValues.add(2);
		m_InOutValues.add(4);
	}
	public IntegerWrapper getValues()
	{
		return  m_InOutValues;
	}
	
	
}
