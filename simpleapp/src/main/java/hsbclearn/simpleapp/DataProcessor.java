/**
 * 
 */
package hsbclearn.simpleapp;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author GZGRAJ
 *
 */
public class DataProcessor {
	Set <Integer> m_OrderedUniqueData = new TreeSet <Integer>();
	DataProcessor()
	{
		// tu dać  m_OrderedUniqueData = new TreeSet <Integer>(); 
	}
	/**
	 * Buduje posortowaną bez duplikatów
	 *
	 */
	void buildOrderedUnique(IntegerWrapper iData)
	{
		Iterator<Integer> tmp = iData.iterator();
		tmp = iData.iterator();
		while (tmp.hasNext()) 
		{
			m_OrderedUniqueData.add(tmp.next());
		}
		
	}

	/**
	 * Przepisuje  posortowaną bez duplikatów do zwykłej i dodaje sumę
	 *
	 */
	void buildCompleteResult(IntegerWrapper iData)
	{
		int sum = 0;
		iData.getRawData().clear();
		for (Integer tmp: m_OrderedUniqueData )
		{
			sum += tmp;
			iData.add(tmp);
		}
		iData.add(sum);
		
	}
	void Run( IntegerWrapper iData)
	{
		buildOrderedUnique(iData);
		buildCompleteResult(iData);
	}	
}
