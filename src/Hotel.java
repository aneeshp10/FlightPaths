// --== CS400 File Header Information ==--
// Name: Arjun Iyer
// Email: iyer9@wisc.edu
// Team: GA
// TA: Daniel Kiel
// Lecturer: Florian Heimerl
// Notes to Grader: -

/**
 * Holds the name and cost of the hotel with a method that compares two hotels
 * by cost
 * 
 * @author arjun
 *
 */
public class Hotel implements Comparable<Hotel> {

	private String name;
	private int cost;

	/**
	 * Constructor that takes the hotel's name and cost as parameters
	 * 
	 * @param name
	 * @param cost
	 */
	public Hotel(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}

	/**
	 * Method to get hotel name
	 * 
	 * @return - String - hotel name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method to get hotel cost
	 * 
	 * @return - int - hotel cost
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * Setter method to modify the hotel's cost
	 * 
	 * @param cost - int - hotel cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Allows the natural ordering of hotels to be increasing with hotel cost. When
	 * hotel cost is equal, the string comparison of the name is used to break ties.
	 * 
	 * @param other is the other path that is being compared to this one
	 * @return -1 when this hotel has a smaller cost than the other, +1 when this
	 *         hotel has a larger cost that the other, and the comparison of hotel
	 *         name in string form when their costs are tied
	 */
	public int compareTo(Hotel other) {
		int cmp = this.cost - other.cost;
		if (cmp != 0)
			return cmp; // use path distance as the natural ordering
		// when path distances are equal, break ties by comparing the string
		// representation of data in the end vertex of each path
		return this.name.toString().compareTo(other.name.toString());
	}
}
