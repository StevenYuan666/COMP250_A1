package a1;

public class Room {
	/*
	 * declare the three private fileds, type refer to the room type
	 * integer price in cents
	 * availability, true when room if available, false otherwise
	 */
	private String type;
	private int price;
	private boolean availability;
	
	//Constructor to initialize the object by taking a room type as argument
	public Room(String type) {
		//check if the room type is double
		if(type.equalsIgnoreCase("double")) {
			this.type = type;
			this.price = 9000;
			this.availability = true;
		}
		//check if the room type is queen
		else if(type.equalsIgnoreCase("queen")) {
			this.type = type;
			this.price = 11000;
			this.availability = true;
		}
		//check if the room type if king
		else if(type.equalsIgnoreCase("king")) {
			this.type = type;
			this.price = 15000;
			this.availability = true;
		}
		//throw out an exception otherwise for unsupported argument
		else {
			throw new IllegalArgumentException("No room of such type can be created");
		}
	}
	
	//Constructor to initialize a object by copy from other's fields
	public Room(Room r) {
		this.price = r.getPrice();
		this.availability = r.availability;
		this.type = r.getType();
	}
	
	//Accessor to return the Room type
	public String getType() {
		return this.type;
	}
	
	//Accessor to return the Price
	public int getPrice() {
		return this.price;
	}
	
	//Mutator to change the availability to the opposite value
	public void changeAvailability() {
		this.availability = !(this.availability);
	}
	
	//Input an array of room and room type, find the first available room
	public static Room findAvailableRoom(Room[] rooms, String type) {
		for(int i = 0; i < rooms.length; i++) {
			//check if there is room with target type and available as well
			if(rooms[i].type.equalsIgnoreCase(type) && rooms[i].availability) {
				return rooms[i];
			}
		}
		return null;
	}
	
	/*
	 * Input an array of room and room type
	 * make the first unavailable room of this type available again
	 * if succeed, return ture, or return false otherwise
	 */
	public static boolean makeRoomAvailable(Room[] rooms, String type) {
		for(int i = 0; i < rooms.length; i++) {
			//check if there is room with target type and unavailable as well
			if(rooms[i].type.equalsIgnoreCase(type) && !(rooms[i].availability)) {
				//change the availability and return true
				rooms[i].changeAvailability();
				return true;
			}
		}
		return false;
	}
}
