
package hsbclearn.simpleapp;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class IntegerWrapper implements Comparable<IntegerWrapper> {
	@XmlElement(name="Number")
	private Integer data;		
	
	public IntegerWrapper() { data = 0;}
	
	public IntegerWrapper(Integer data) {
		this.data = data;
	}	
	
	//@XmlTransient
	public Integer getData() {
		return data;
	}	

	public void setData(Integer data) {
		this.data = data;
	}
	
	@Override
	public int compareTo(IntegerWrapper o) {
		
		return data.compareTo(o.data);
	}	

	@Override
	public String toString() {
		
		return "IntegerWrapper [data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegerWrapper other = (IntegerWrapper) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
		
}