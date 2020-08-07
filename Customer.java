package a1;

public class Customer {
	//declare three private fields represent name, balance, and a basket
	private String name;
	private int balance;
	private Basket basket;
	
	//Constructor to initialize the three fields
	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.basket = new Basket();
	}
	
	//Return the name
	public String getName() {
		return this.name;
	}
	
	//Return the balance
	public int getBalance() {
		return this.balance;
	}
	
	//Return the reference of basket
	public Basket getBasket() {
		return this.basket;
	}
	
	//Takes an int as input and add it to the balance. If the input is negative, throw an exception
	public int addFunds(int funds) {
		
		//throw an exception if the input funds smaller than zero
		if(funds < 0) {
			throw new IllegalArgumentException("The funds cannot be negative");
		}
		
		//otherwise mutate the balance plus the input funds
		else {
			int newFunds = this.getBalance() + funds;
			this.balance = newFunds;
			return newFunds;
		}
	}
	
	//Takes a reservation as input, if the name is same, add it to the basket
	public int addToBasket(Reservation r) {
		
		//if the name is same, add the reservation to the basket
		if(r.reservationName().equalsIgnoreCase(this.getName())) {
			int num = this.basket.add(r);
			return num;
		}
		
		//throw an exception otherwise
		else {
			throw new IllegalArgumentException("The name of the input reservation is not same with the name of customer");
		}
	}
	
	//Overload the addToBasket, takes a hotel, a string, and a boolean as inputs
	public int addToBasket(Hotel hotel, String type, int nights, boolean breakfast) {
		
		//check if the customer need breakfast
		if(breakfast) {
			
			//if the breakfast is needed, create an BnBReservation object
			Reservation r = new BnBReservation(this.getName(), hotel, type, nights);
			int num = this.basket.add(r);
			return num;
		}
		
		//otherwise, create a normal HotelReservation object
		else {
			Reservation r = new HotelReservation(this.getName(), hotel, type, nights);
			int num = this.basket.add(r);
			return num;
		}
	}
	
	//Overload the addToBasket, takes two airports as inputs
	public int addToBasket(Airport departure, Airport arrival) {
		
		//check if there is an exception when create a FlightReservation object
		try {
			
			//if there is no exception, add it to basket and return the length of basket
			Reservation r = new FlightReservation(this.getName(), departure, arrival);
			int num = this.basket.add(r);
			return num;
		}
		
		//if there is an exception, return the number of reservation in the basket directly
		catch(IllegalArgumentException e){
			return this.basket.getNumOfReservations();
		}
	}
	
	//Takes a reservation as input, and remove this reservation from the basket
	//return a boolean indicating whether or not the operation was successful
	public boolean removeFromBasket(Reservation r) {
		boolean result = this.basket.remove(r);
		return result;
	}
	
	//Check if the customer's balance is able to cover the total cost
	public int checkOut() {
		
		//calculate the total cost of the customer
		int cost = this.basket.getTotalCost();
		
		//check if the total cost is greater than customer's balance
		if(cost > this.balance) {
			throw new IllegalStateException("Your balance cannot cover the total cost");
		}
		
		//otherwise, minus the cost from the balance, empty the basket, and return the balance left
		else {
			int left = this.balance - cost;
			this.balance = left;
			this.basket.clear();
			return left;
		}
	}
	
	
}
