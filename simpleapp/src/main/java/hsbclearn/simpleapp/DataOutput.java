/**
 * 
 */
package hsbclearn.simpleapp;

import java.util.Iterator;

/**
 * @author GZGRAJ
 *
 */
public class DataOutput {

	void print(IntegerWrapper iData)
	{
		Iterator<Integer> tmp = iData.iterator();
		while (tmp.hasNext()) 
			System.out.println(tmp.next());
	}
}
