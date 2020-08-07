package a1;

public class BnBReservation extends HotelReservation{
	
	//Constructor to initialize corresponding fields
	public BnBReservation(String name, Hotel hotel, String type, int nights) {
		super(name,hotel,type, nights);
	}
	
	//Return the total cost include the breakfast
	public int getCost() {
		int totalcost = super.getCost();
		
		//add the total cost of breakfast
		totalcost += this.getNumOfNights() * 1000;
		return totalcost;
	}
	
}
