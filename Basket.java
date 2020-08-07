package a1;

public class Basket {
	//declare a field represent an array of reservation
	private Reservation[] reservation;
	
	//Constructor takes no input and initialize the field with an array with no reservation
	public Basket() {
		this.reservation = new Reservation[0];
	}
	
	//Return a shallow copy of the array of reservations of the basket
	public Reservation[] getProducts() {
		
		//use the clone method to make a shallow copy 
		Reservation[] copy = new Reservation[this.reservation.length];
		copy = this.reservation.clone();
		
		//return the copy
		return copy;
	}
	
	//An add method takes reservation as input and add to the list of reservation
	//return how many reservations there
	public int add(Reservation r) {
		//create a new array with one more reservation
		Reservation[] add = new Reservation[this.reservation.length+1];
		
		//copy the original list of reservations
		for(int i = 0; i < add.length-1; i++) {
			add[i] = this.reservation[i];
		}
		
		//add the new reservation at the end of the list
		add[this.reservation.length] = r;
		
		//mutate the field
		this.reservation = add;
		
		//return how may reservations in the field
		return add.length;
	}
	
	//A remove method takes reservation as input and remove it from  the list
	//return true if it is successful, return false otherwise
	public boolean remove(Reservation r) {
		
		//write a for loop to find if there is same reservation with r in the list
		for(int i = 0; i < this.reservation.length; i++) {
			
			//if there is a same reservation
			if(this.reservation[i].equals(r)) {
				
				//create a new array with one less reservation
				Reservation[] remove = new Reservation[this.reservation.length-1];
				
				//to copy the first half reservations, which are before the same reservation
				for(int j = 0; j < i; j++) {
					remove[j] = this.reservation[j];
				}
				
				//to copy the second half reservations, which are after the same reservation
				for(int k = i; k < remove.length; k++) {
					remove[k] = this.reservation[k+1];
				}
				
				//mutate the field
				this.reservation = remove;
				
				//return true
				return true;
			}
		//if there is no same reservation, return false
		}
		return false;
	}
	
	//A clear method empty the array of reservation
	public void clear() {
		this.reservation = new Reservation[0];
	}
	
	//Return the number of reservations in the array
	public int getNumOfReservations() {
		return this.reservation.length;
	}
	
	//Return the total cost in the array of reservations
	public int getTotalCost() {
		int total = 0;
		
		//add every reservation's cost
		for(int i = 0; i < this.reservation.length; i++) {
			total += this.reservation[i].getCost();
		}
		return total;
	}
}
