
package hsbclearn.simpleapp;

public class IntegerWrapper implements Comparable<IntegerWrapper> {
	
	private Integer data;		
	
	public IntegerWrapper(Integer data) {
		this.data = data;
	}	
	
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