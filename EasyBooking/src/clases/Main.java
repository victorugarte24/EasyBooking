package clases;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;



//TODO Quitar constructor de todas las clases. Todos los atributos deben ser privados. 
//Cuidado con el fligthCode --> Especificado en el enunciado. AEROLINEA + NUM_VUELO
//Revisar diagrama entidad - relación --> Hacer uno nuevo
//Cambiar nombres de atributos como estan especificados en el class Diagram.
//Añadir getters and setter (para los atributos que teniamos en el constructor)
//Cuidado el nombre de los atributos.

//TODO 08/12/2019 comprobar que funcionan los cambios




public class Main {

	public static void main(String[] args) {
		
	    Airport airportBilbao = new Airport();
	    airportBilbao.setCodeAirport("BIO");
	    airportBilbao.setName("Aeropuerto de Bilbao");
	    airportBilbao.setCity("Bilbao");
	    airportBilbao.setCountry("España");
	    
	    Airport airportSantander = new Airport();
	    airportSantander.setCodeAirport("STD");
	    airportSantander.setName("Aeropuerto de Santander");
	    airportSantander.setCity("Santander");
	    airportSantander.setCountry("España");
	    
	    Airport airportMadrid = new Airport();
	    airportMadrid.setCodeAirport("MAD");
	    airportMadrid.setName("Aeropuerto de Madrid");
	    airportMadrid.setCity("Madrid");
	    airportMadrid.setCountry("España");
	    
	    Airline iberia = new Airline();	
	    iberia.setCodeAirline("220");
	    iberia.setNameAirline("Iberia");
	    
		Airline lufthansa = new Airline();
		lufthansa.setCodeAirline("221");
		lufthansa.setNameAirline("Lufthansa");
	    
	    Fligth fligth1 = new Fligth();
	    fligth1.setFligthCode(1234);
	    fligth1.setDate("21/01/18");
	    fligth1.setTimeDeparture("19:00");
	    fligth1.setTimeArrival("20:00");
	    fligth1.setTotalSeats(200);
	    fligth1.setRemainingSeats(140);    
	    
	    Fligth fligth2 = new Fligth();
	    fligth2.setFligthCode(2345);
	    fligth2.setDate("22/01/18");
	    fligth2.setTimeDeparture("18:00");
	    fligth2.setTimeArrival("21:00");
	    fligth2.setTotalSeats(200);
	    fligth2.setRemainingSeats(144); 
	    
	    User user1 = new User();
	    user1.setCodeUser("alvarfez");
	    user1.setEmail("noseque@gmail.com");
	    user1.setDefaultAirport(airportBilbao);
	    user1.setNombreAeropuerto(airportBilbao.getName());
	    
	    User user2 = new User();
	    user2.setCodeUser("Erlii");
	    user2.setEmail("nosecual@gmail.com");
	    user2.setDefaultAirport(airportMadrid);
	    
	    Reserve reserva1 = new Reserve();
	    reserva1.setCodeReserve(990);
	    reserva1.addPassenger("Alvar");
	    reserva1.addPassenger("Mikel");
	    reserva1.setDate("10/10/2018");
	    
	    
	    CreditCard cc = new CreditCard();
	    cc.setCvv("091");
	    cc.setNameOwner("Alvar Fernandez Villasante");
	    cc.setNumber("22304405005000");

	    //RELACIONES 
	 
	    iberia.addVuelo(fligth1);
	    lufthansa.addVuelo(fligth2);
	   
	    fligth1.setAArrival(airportBilbao);
	    fligth1.setADeparture(airportSantander);
	    fligth1.setAirline(iberia);
	    fligth1.addReserva(reserva1);
	    
	    airportBilbao.addVuelo(fligth1);
	    airportSantander.addVuelo(fligth1);
	    
	    reserva1.setFligth(fligth1);
	    reserva1.setUser(user1);
	    reserva1.setPayment(cc);
	    reserva1.setPago(cc.getNumber());
	    
	    user1.addReserve(reserva1);
	    
		try {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try {
			    transaction.begin();			    
	
			    persistentManager.makePersistent(user1);
			    persistentManager.makePersistent(reserva1); 
			    persistentManager.makePersistent(fligth1); 
			    
			    System.out.println("- Inserted into db: " + user1.getEmail());
			    System.out.println("- Inserted into db: " + reserva1.getCodeReserve());
			    System.out.println("- Inserted into db: " + fligth1.getFligthCode());
	
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			} finally {		    
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    
			    persistentManager.close();
			}
			
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try {
			    transaction.begin();
			    
			    //Obtenemos los vuelos que tienen como salida el aeropuerto de santander.
				Query<Fligth> fligthQuery = persistentManager.newQuery(Fligth.class);
			    fligthQuery.setFilter("fligthCode == 1234");
			    
			    @SuppressWarnings("unchecked")
				List<Fligth> fligths1 = (List<Fligth>) fligthQuery.execute();
			    
			    for (Fligth fligth : fligths1) {
			        System.out.println("- Selected fligth code from db: " + fligth.getFligthCode());
			    }
			    
			    System.out.println(Fligth.class.getName());
			    
			   //Obtenemos todos los vuelos para contrastar
			   Extent<Fligth> fligthExtent = persistentManager.getExtent(Fligth.class);
			    
			    for (Fligth fligth : fligthExtent) {
			    	System.out.println("- Selected fligth from db: " + fligth.getFligthCode() + ":");
			    } 			    
			    transaction.commit();	    
			   
			  
			} catch(Exception ex) {
				System.err.println("* Exception executing a query: " + ex.getMessage()); 
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
	
			    persistentManager.close();
			}
			
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		
	} 
		
	}
}
