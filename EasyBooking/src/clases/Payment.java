package clases;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable 
public abstract class Payment  {
	@NotPersistent
	private Reserve reserve;
	
	public Payment() {
	}

	public Reserve getReserve() {
		return reserve;
	}

	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	
	
}
