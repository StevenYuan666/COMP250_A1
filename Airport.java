package a1;

public class Airport {
	/* 
	 * declare the three private fields
	 * x,y coordinates in kilometers and fees in cents
	 */
	private int x_coordinate;
	private int y_coordinate;
	private int fee;
	
	//Constructor to initialize the object
	public Airport(int x, int y, int f) {
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.fee = f;
	}
	
	//Accessor to return the value of Airport fees
	public int getFees() {
		return this.fee;
	}
	
	//Return the distance between two airport
	public static int getDistance(Airport a, Airport b) {
		double temp1 = Math.pow((a.x_coordinate-b.x_coordinate), 2);
		double temp2 = Math.pow((a.y_coordinate-b.y_coordinate), 2);
		double d = Math.sqrt(temp1 + temp2);
		int result = (int)(d);
		//return the result itself if the result is an integer,like 5.0
		if(result == d) {
			return result;
		}
		//return the integer round up the integer, like 5.3, return 6
		else {
			return result+1;
		}
		
	}
}
