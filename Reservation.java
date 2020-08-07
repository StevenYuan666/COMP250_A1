package a1;

public abstract class Reservation {
	//declare a private field name
	private String name;
	
	//Constructor to initialize name field
	public Reservation(String name) {
		this.name = name;
	}
	
	//a final method to return the name field
	public final String reservationName() {
		return this.name;
	}
	
	//an abstract method return an integer
	public abstract int getCost();
	
	//an abstract method return a boolean value
	public abstract boolean equals(Object obj);
}
