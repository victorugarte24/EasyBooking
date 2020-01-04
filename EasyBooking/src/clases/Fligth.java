package clases;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable 
public class Fligth {
	
	private Set<Reserve> reserves = new HashSet<>();
	
	private Airport aDeparture;
	private Airport aArrival;
	private Airline airline; 
	
	
	@PrimaryKey
	private int fligthCode;
	private String date;
	private String timeDeparture;
	private String timeArrival;
	private int totalSeats;
	private int remainingSeats;

	public Airport getADeparture() {
		return aDeparture;
	}

	public void setADeparture(Airport aDeparture) {
		this.aDeparture = aDeparture;
	}

	public Airport getAArrival() {
		return aArrival;
	}

	public void setAArrival(Airport aArrival) {
		this.aArrival = aArrival;
	}
//
	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public int getFligthCode() {
		return fligthCode;
	}
	
	public void setFligthCode(int fligthCode) {
		this.fligthCode = fligthCode;
	}

	public Set<Reserve> getReserves() {
		return reserves;
	}

	public void setReserves(Set<Reserve> reserves) {
		this.reserves = reserves;
	}
	
	public void addReserva(Reserve e) {
		this.getReserves().add(e);
	}
	
	public void removeReserva(Reserve e) {
		this.getReserves().remove(e);	
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(String timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public String getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(String timeArrival) {
		this.timeArrival = timeArrival;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	
	
	
	
	
}
