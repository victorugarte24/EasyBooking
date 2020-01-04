package clases;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable 
public class Reserve {
	
	@ForeignKey
	private Fligth fligth;
	
	@ForeignKey
	private User user;
	 
	private Payment payment;
	@Persistent
	private String pago;

	@PrimaryKey 
	private int codeReserve;
	
	private Set<String> passengers = new HashSet<>();
	private String date;
	
	public Reserve() {
		
	}

	public Fligth getFligth() {
		return fligth;
	}

	public void setFligth(Fligth fligth) {
		this.fligth = fligth;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCodeReserve() {
		return codeReserve;
	}

	public void setCodeReserve(int codeReserve) {
		this.codeReserve = codeReserve;
	}

	public Set<String> getPassengers() {
		return passengers;
	}

	public void setPassenger(Set<String> passengers) {
		this.passengers = passengers;
	}
	
	public void addPassenger(String s) {
		this.getPassengers().add(s);
	}
	
	public void removePassengers(String s) {
		this.getPassengers().remove(s);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}
	
}
