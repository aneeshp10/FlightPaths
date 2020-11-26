import java.util.PriorityQueue;

/**
 * Location class that stores the destination name and a PriorityQueue of hotels
 * with a method that returns the best hotel in this destination by cost
 * 
 * @author arjun
 *
 */
public class Location {

	private String name;
	private PriorityQueue<Hotel> hotels;

	/**
	 * Constructor that takes the name and a PriorityQueue of hotels as parameters
	 * 
	 * @param name
	 * @param hotels
	 */
	public Location(String name, PriorityQueue<Hotel> hotels) {
		this.name = name;
		this.hotels = hotels;
	}

	/**
	 * Method that returns the name of the location
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Adds a hotel to the hotels PriorityQueue
	 * 
	 * @param hotel
	 */
	public void addHotel(Hotel hotel) {
		hotels.offer(hotel);
	}

	/**
	 * Returns the best hotel from the hotels PriorityQueue without removing it from
	 * the queue
	 * 
	 * @return
	 */
	public Hotel bestHotel() {
		return hotels.peek();
	}

	/**
	 * Prints all the hotels at this location with the cost
	 */
	public void printHotelList() {

		for (Hotel h : hotels)
			System.out.println("\t--> " + h.getName() + " \t\t$/Night: " + h.getCost());
	}
}
