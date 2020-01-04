package clases;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable 
public class User {
	
	@Persistent 
	@ForeignKey 
	private Set<Reserve> reserves = new HashSet<>();
	
	@PrimaryKey
	private String codeUser;
	private String email;
	
	
	private Airport defaultAirport;
	
	@Persistent 
	private String nombreAeropuerto;
	
	public User() {	
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Reserve> getReserves() {
		return reserves;
	}

	public void setReserves(Set<Reserve> reserves) {
		this.reserves = reserves;
	}
	
	public void addReserve(Reserve e) {
		this.getReserves().add(e);
	}
	
	public void removeReserve(Reserve e) {
		this.getReserves().remove(e);
	}


	public String getCodeUser() {
		return codeUser;
	}


	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public Airport getDefaultAirport() {
		return defaultAirport;
	}


	public void setDefaultAirport(Airport defaultAirport) {
		this.defaultAirport = defaultAirport;
	}


	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}


	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}
	
}
