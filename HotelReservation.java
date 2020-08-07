package a1;

public class HotelReservation extends Reservation{
	/*
	 * declare three private fields indicating the hotel, type of room, number of nights spent 
	 * and price for one nights of the specified room type and specified hotel in cents
	 */
	private Hotel hotel;
	private String type;
	private int nights;
	private int price;
	
	//Constructor to initialize the corresponding fields
	public HotelReservation(String name, Hotel hotel, String type, int nights) {
		//Call the super constructor to initialize the name
		super(name);
		
		this.hotel = hotel;
		this.type = type;
		this.nights = nights;
		
		//if there is no available room, will throw out an exception
		this.price = hotel.reserveRoom(type);
	}
	
	//Accessor to return the number of nights
	public int getNumOfNights() {
		return this.nights;
	}
	
	//Return the cost of reservation
	public int getCost() {
		int cost = this.price * this.nights;
		return cost;
	}
	
	//Compare the two reservation are equal or not
	public boolean equals(Object obj) {
		
		//check if the input object is an HotelReservation object
		if(obj instanceof HotelReservation) {
			//if it is, typecasting it to HotelReservation
			HotelReservation input = (HotelReservation)(obj);
			
			//check if the name is same
			boolean compareName = this.reservationName().equalsIgnoreCase(input.reservationName());
			
			//check if the hotel is same
			boolean compareHotel = this.hotel.equals(input.hotel);
			
			//check if the type of room is same
			boolean compareType = this.type.equalsIgnoreCase(input.type);
			
			//check if the number of nights is same
			boolean compareNights = this.nights == input.nights;
			
			//check if the total cost is same
			boolean compareCost = this.getCost() == input.getCost();
			
			//check if all of conditions are satisfied
			boolean condition = compareName && compareHotel && compareType && compareNights && compareCost;
			
			//return true if all conditions are satisfied, return false otherwise
			return condition;
		}
		//return false if the input object is not a HotelReservation
		else {
			return false;
		}
	}
}
