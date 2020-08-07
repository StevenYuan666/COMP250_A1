package a1;

public class FlightReservation extends Reservation{
	//declare two private fields which indicate the departure and arrival airport
	private Airport departure;
	private Airport arrival;
	
	//Constructor taka a string and two airports as inputs
	public FlightReservation(String name, Airport departure, Airport arrival) {
		//call the super constructor in reservation class to initialize the name
		super(name);
		
		//check if the departure and the arrival are same or not
		if(departure.equals(arrival)) {
			throw new IllegalArgumentException("The departure and arrival cannot be same");
		}

		//initialize other fields respectively if there is no error
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public int getCost() {
		//calculate the airports fees first
		double airportsFees = this.departure.getFees() + this.arrival.getFees();
		
		//calculate the distance between the two airports
		int distance = Airport.getDistance(this.departure, this.arrival);
		
		//calculate the fuels needed
		double fuels = distance / 167.52;
		
		//calculate the cost for the fuels in cents
		double fuelCost = fuels * 1.24 * 100;
		
		//calculate the total cost, fuelCost plus the airports fees
		double totalCost = fuelCost + airportsFees + 5375;
		
		int result = (int)(totalCost);
		
		//return the totalCose itself if it is an integer, like 10000.0
		if(result == totalCost) {
			return result;
		}
		//otherwise, return the result plus one to round up the result
		else {
			return result+1;
		}
	}
	
	public boolean equals(Object obj) {
		//check if the input obj is a FlightReservation or not
		if(obj instanceof FlightReservation) {
			//if it is a FlightReservation
			//Typecasting it to FlightReservation object to use the class methos
			FlightReservation input = (FlightReservation)(obj);
			
			//check if the name is same
			boolean compareName = this.reservationName().equalsIgnoreCase(input.reservationName());
			
			//check if the departure airport is same
			boolean compareDeparture = this.departure.equals(input.departure);
			
			//check if the arrival airport is same
			boolean compareArrival = this.arrival.equals(input.arrival);
			
			//check if all conditions are satisfied or not
			boolean condition = compareName && compareDeparture && compareArrival;
			
			//return true if all conditions are satisfied, return false other wise
			return condition;
		}
		//return false if the input object is not a FlightReservation object
		else {
			return false;
		}
	}
}
