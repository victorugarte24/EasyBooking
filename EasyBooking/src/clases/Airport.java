package clases;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable
public class Airport {
	
	
	//private Set<Fligth> vuelos = new HashSet<Fligth>(); No necesitamos una lista de vuelos
	
	@PrimaryKey
	private String codeAirport; 
	
	@NotPersistent
	private String name;
	@NotPersistent
	private String city;

	
	public Airport() {
	}	
		
	
	public String getCodeAirport() {
		return codeAirport;
	}

	public void setCodeAirport(String codeAirport) {
		this.codeAirport = codeAirport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
