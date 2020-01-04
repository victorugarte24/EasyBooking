package clases;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable
public class Airline {
	

	private Set<Fligth> vuelos = new HashSet<>();
	
	@PrimaryKey
	private String codeAirline;
	@NotPersistent
	private String nameAirline;
	
	public Airline() {
		
	}

	public Set<Fligth> getVuelos() {
		return vuelos;
	}

	public void setVuelos(Set<Fligth> vuelos) {
		this.vuelos = vuelos;
	}
	
	public void addVuelo(Fligth f) {
		this.getVuelos().add(f);
	}
	
	public void removeVuelo(Fligth f) {
		this.getVuelos().remove(f);	
	}

	public String getCodeAirline() {
		return codeAirline;
	}

	public void setCodeAirline(String codeAirline) {
		this.codeAirline = codeAirline;
	}

	public String getNameAirline() {
		return nameAirline;
	}

	public void setNameAirline(String nameAirline) {
		this.nameAirline = nameAirline;
	}
	
	/** Metodo que obtiene las diferentes listas de vuelos de una aerolinea y lo convierte en un Set
	 * @return Una lista de vuelos.
	 */
	public Set<Fligth> obtenerVuelosDeAerolinea(){
		//TODO
		return null;
	}
	
	
}
