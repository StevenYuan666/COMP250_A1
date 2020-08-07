package a1;

public class Hotel {
	/*
	 * declare the two private fields represent the name of hotel and rooms in the hotel
	 */
	private String name;
	private Room[] rooms;
	
	//Constructor to initialize a Hotel object, and nake a deep copy for the array
	public Hotel(String name, Room[] rooms) {
		this.name = name;
		//make a deep copy for the array
		Room[] r = new Room[rooms.length];
		for(int i = 0; i < rooms.length; i++) {
			//use the second constructor in class Room to make a copy
			r[i] = new Room(rooms[i]);
		}
		this.rooms = r;
	}
	
	//Take a string as input, change the availability of the first available room
	//return the price if successful, throw an exception otherwise
	public int reserveRoom(String type) {
		try {
			Room target = Room.findAvailableRoom(this.rooms, type);
			target.changeAvailability();
			return target.getPrice();
		}
		catch (NullPointerException e) {
			throw new IllegalArgumentException("No such type room available!");
		}
	}
	
	//Take a string as  input, change the availability of the room back to available again
	//return true if the operation is successful, return false otherwise
	public boolean cancelRoom(String type) {
		return Room.makeRoomAvailable(this.rooms, type);
	}
}
