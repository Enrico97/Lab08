package it.polito.tdp.extflightdelays.model;

public class CoppieAereoporti {
	
	private Airport a1;
	private Airport a2;
	private int avg;
	/**
	 * @param a1
	 * @param a2
	 * @param avg
	 */
	public CoppieAereoporti(Airport a1, Airport a2, int avg) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.avg = avg;
	}
	/**
	 * @return the a1
	 */
	public Airport getA1() {
		return a1;
	}
	/**
	 * @param a1 the a1 to set
	 */
	public void setA1(Airport a1) {
		this.a1 = a1;
	}
	/**
	 * @return the a2
	 */
	public Airport getA2() {
		return a2;
	}
	/**
	 * @param a2 the a2 to set
	 */
	public void setA2(Airport a2) {
		this.a2 = a2;
	}
	/**
	 * @return the avg
	 */
	public int getAvg() {
		return avg;
	}
	/**
	 * @param avg the avg to set
	 */
	public void setAvg(int avg) {
		this.avg = avg;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a1 == null) ? 0 : a1.hashCode());
		result = prime * result + ((a2 == null) ? 0 : a2.hashCode());
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
		CoppieAereoporti other = (CoppieAereoporti) obj;
		if (a1 == null) {
			if (other.a1 != null)
				return false;
		} else if (!a1.equals(other.a1))
			return false;
		if (a2 == null) {
			if (other.a2 != null)
				return false;
		} else if (!a2.equals(other.a2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return a1.getAirportName()+" "+a2.getAirportName()+ " "+avg+"\n";
	}
	
}
