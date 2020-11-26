import java.util.PriorityQueue;

/**
 * Class that creates a graph with all cities, travel time, and costs. This
 * class comprises a total of 12 major cities in the United States and maps out
 * the flight path and cost from each city to another using Dijkstra's
 * Algorithm.
 * 
 * @author aneesh
 *
 */

public class FlightData {

	// create priority queues for each city - total of 12 cities and 12 priority
	// queues
	private PriorityQueue<Hotel> queueNYCHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueDallasHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueAustinHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueChicagoHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueLAHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueOrlandoHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueMadisonHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueSJHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queuePhilHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueSeattleHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueAtlantaHotels = new PriorityQueue<Hotel>();
	private PriorityQueue<Hotel> queueBaltimoreHotels = new PriorityQueue<Hotel>();

	// create location objects with corresponding city names (string) and its
	// priority queue - total of 12 cities
	Location nyc = new Location("New York City", queueNYCHotels);
	Location chi = new Location("Chicago", queueChicagoHotels);
	Location dal = new Location("Dallas", queueDallasHotels);
	Location la = new Location("Los Angeles", queueLAHotels);
	Location aus = new Location("Austin", queueAustinHotels);
	Location sea = new Location("Seattle", queueSeattleHotels);
	Location orl = new Location("Orlando", queueOrlandoHotels);
	Location sj = new Location("San Jose", queueSJHotels);
	Location mad = new Location("Madison", queueMadisonHotels);
	Location phi = new Location("Philadelphia", queuePhilHotels);
	Location atl = new Location("Atlanta", queueAtlantaHotels);
	Location bal = new Location("Baltimore", queueBaltimoreHotels);

	/**
	 * Default constructor that initializes the popular hotels as per Google's
	 * Hotels List along with the respective cost per night in USD
	 *
	 * @author aneesh
	 *
	 */
	public FlightData() {
		// TODO Auto-generated constructor stub

		// top hotels in new york city
		queueNYCHotels.add(new Hotel("Knickerboc", 210));
		queueNYCHotels.add(new Hotel("Radisson", 79));
		queueNYCHotels.add(new Hotel("Hilton", 118));
		queueNYCHotels.add(new Hotel("Millennium", 83));
		queueNYCHotels.add(new Hotel("Marriott", 132));
		queueNYCHotels.add(new Hotel("Sheraton", 143));
		queueNYCHotels.add(new Hotel("Westin", 147));
		queueNYCHotels.add(new Hotel("Aloft", 111));
		queueNYCHotels.add(new Hotel("Archer", 111));
		queueNYCHotels.add(new Hotel("INNSIDE", 93));
		queueNYCHotels.add(new Hotel("Continent", 133));
		queueNYCHotels.add(new Hotel("Evelyn", 110));

		// top hotels in dallas
		queueDallasHotels.add(new Hotel("Hyatt", 129));
		queueDallasHotels.add(new Hotel("Downtown", 93));
		queueDallasHotels.add(new Hotel("Hilton", 114));
		queueDallasHotels.add(new Hotel("Canopy", 139));
		queueDallasHotels.add(new Hotel("Marriott", 119));
		queueDallasHotels.add(new Hotel("Sheraton", 58));
		queueDallasHotels.add(new Hotel("Fairmont", 98));
		queueDallasHotels.add(new Hotel("Omni", 161));

		// top hotels in chicago
		queueChicagoHotels.add(new Hotel("Swissotel", 119));
		queueChicagoHotels.add(new Hotel("Radisson", 112));
		queueChicagoHotels.add(new Hotel("Hilton", 280));
		queueChicagoHotels.add(new Hotel("Sofitel", 95));
		queueChicagoHotels.add(new Hotel("Mariott", 135));
		queueChicagoHotels.add(new Hotel("LondonH", 106));
		queueChicagoHotels.add(new Hotel("Westin", 129));
		queueChicagoHotels.add(new Hotel("Loews", 121));
		queueChicagoHotels.add(new Hotel("Ivy", 89));
		queueChicagoHotels.add(new Hotel("Godfrey", 81));
		queueChicagoHotels.add(new Hotel("Fairmont", 103));

		// top hotels in austin
		queueAustinHotels.add(new Hotel("Fairmont", 170));
		queueAustinHotels.add(new Hotel("Archer", 269));
		queueAustinHotels.add(new Hotel("Driskill", 290));
		queueAustinHotels.add(new Hotel("Mariott", 212));
		queueAustinHotels.add(new Hotel("Hilton", 249));

		// top hotels in los angeles
		queueLAHotels.add(new Hotel("Hilton", 173));
		queueLAHotels.add(new Hotel("Sofitel", 191));
		queueLAHotels.add(new Hotel("Mondrian", 222));
		queueLAHotels.add(new Hotel("Roosevelt", 195));
		queueLAHotels.add(new Hotel("Freehand", 89));

		// top hotels in madison
		queueMadisonHotels.add(new Hotel("Indigo", 80));
		queueMadisonHotels.add(new Hotel("Hilton", 97));
		queueMadisonHotels.add(new Hotel("SpringHill", 84));
		queueMadisonHotels.add(new Hotel("DoubleTree", 85));
		queueMadisonHotels.add(new Hotel("Courtyard", 85));

		// top hotels in orlando
		queueOrlandoHotels.add(new Hotel("Staybridge", 93));
		queueOrlandoHotels.add(new Hotel("Hilton", 136));
		queueOrlandoHotels.add(new Hotel("Carlton", 454));
		queueOrlandoHotels.add(new Hotel("HardRock", 412));
		queueOrlandoHotels.add(new Hotel("Hyatt", 127));

		// top hotels in san jose
		queueSJHotels.add(new Hotel("Wingate", 93));
		queueSJHotels.add(new Hotel("Fairmont", 127));
		queueSJHotels.add(new Hotel("Mariott", 122));
		queueSJHotels.add(new Hotel("Valencia", 140));
		queueSJHotels.add(new Hotel("Westin", 106));

		// top hotels in philadelphia
		queuePhilHotels.add(new Hotel("Hilton", 144));
		queuePhilHotels.add(new Hotel("Westin", 109));
		queuePhilHotels.add(new Hotel("Sonesta", 121));
		queuePhilHotels.add(new Hotel("Loews", 103));
		queuePhilHotels.add(new Hotel("Kimpton", 142));
		queuePhilHotels.add(new Hotel("Windsor", 132));
		queuePhilHotels.add(new Hotel("Wyndham", 101));

		// top hotels in seattle
		queueSeattleHotels.add(new Hotel("Charter", 144));
		queueSeattleHotels.add(new Hotel("Hilton", 88));
		queueSeattleHotels.add(new Hotel("Hyatt", 76));
		queueSeattleHotels.add(new Hotel("Plaza", 96));
		queueSeattleHotels.add(new Hotel("Thompson", 150));
		queueSeattleHotels.add(new Hotel("WSpring", 127));

		// top hotels in atlanta
		queueAtlantaHotels.add(new Hotel("Burgess", 144));
		queueAtlantaHotels.add(new Hotel("Artmore", 103));
		queueAtlantaHotels.add(new Hotel("Hilton", 93));
		queueAtlantaHotels.add(new Hotel("Hampton", 56));
		queueAtlantaHotels.add(new Hotel("WFall", 146));
		queueAtlantaHotels.add(new Hotel("Omni", 95));

		// top hotels in baltimore
		queueBaltimoreHotels.add(new Hotel("Homewood", 118));
		queueBaltimoreHotels.add(new Hotel("Pier5", 109));
		queueBaltimoreHotels.add(new Hotel("Marriott", 80));
		queueBaltimoreHotels.add(new Hotel("Hyatt", 82));
		queueBaltimoreHotels.add(new Hotel("Sheraton", 50));
		queueBaltimoreHotels.add(new Hotel("Delta", 65));

	}

	/**
	 * This method accepets a CS400<Location> variable and will be initialized to
	 * the graph demonstrated in this method that comprises of all direct flights
	 * from one city to another along with the duration in minutes. All data has
	 * been collected from Google Flights (rb.gy/7lb1su). Lines kept as comments
	 * indicate that the path has been acknowledged, however, there is no direct
	 * flight between the two locations.
	 * 
	 * @param cities CS400<Location> type paramater passed in from the GAMethods
	 *               class which will then store the following graph as presented in
	 *               this method
	 * 
	 * @author aneesh
	 */
	protected void flightTimes(CS400Graph<Location> cities) {

		// insert all 12 cities as vertices
		cities.insertVertex(nyc);
		cities.insertVertex(chi);
		cities.insertVertex(dal);
		cities.insertVertex(la);
		cities.insertVertex(aus);
		cities.insertVertex(sea);
		cities.insertVertex(orl);
		cities.insertVertex(sj);
		cities.insertVertex(mad);
		cities.insertVertex(phi);
		cities.insertVertex(atl);
		cities.insertVertex(bal);

		// Seattle
		cities.insertEdge(sea, sj, 123);
		cities.insertEdge(sea, la, 146);
		cities.insertEdge(sea, aus, 241);
		cities.insertEdge(sea, phi, 310);
		cities.insertEdge(sea, dal, 212);
		cities.insertEdge(sea, orl, 326);
		cities.insertEdge(sea, chi, 227);
		cities.insertEdge(sea, nyc, 294);
		cities.insertEdge(sea, atl, 270);
		// cities.insertEdge(sea, mad, 123); NO DIRECT FLIGHT
		// cities.insertEdge(sea, bal, 0); NO DIRECT FLIGHT

		cities.insertEdge(sj, chi, 245);
		cities.insertEdge(sj, dal, 280);
		cities.insertEdge(sj, la, 80);
		cities.insertEdge(sj, aus, 210);
		cities.insertEdge(sj, sea, 130);
		// cities.insertEdge(sj, atl, 0); NO DIRECT FLIGHT
		// cities.insertEdge(sj, bal, 0); NO DIRECT FLIGHT
		// cities.insertEdge(sj, nyc, 394); NO DIRECT FLIGHT
		// cities.insertEdge(sj, orl, 245); NO DIRECT FLIGHT
		// cities.insertEdge(sj, mad, 245); NO DIRECT FLIGHT
		// cities.insertEdge(sj, phi, 245); NO DIRECT FLIGHT

		cities.insertEdge(nyc, la, 377);
		cities.insertEdge(nyc, aus, 245);
		cities.insertEdge(nyc, orl, 182);
		cities.insertEdge(nyc, chi, 174);
		cities.insertEdge(nyc, dal, 243);
		cities.insertEdge(nyc, phi, 30);
		cities.insertEdge(nyc, sea, 375);
		cities.insertEdge(nyc, atl, 165);
		// cities.insertEdge(nyc, bal, 0); NO DIRECT FLIGHT
		// cities.insertEdge(nyc, sj, 720); NO DIRECT FLIGHT
		// cities.insertEdge(nyc, mad, 0); NO DIRECT FLIGHT

		cities.insertEdge(chi, la, 276);
		cities.insertEdge(chi, aus, 220);
		cities.insertEdge(chi, orl, 159);
		cities.insertEdge(chi, mad, 60);
		cities.insertEdge(chi, sj, 280);
		cities.insertEdge(chi, nyc, 126);
		cities.insertEdge(chi, dal, 154);
		cities.insertEdge(chi, sea, 280);
		cities.insertEdge(chi, phi, 124);
		cities.insertEdge(chi, atl, 120);
		cities.insertEdge(chi, bal, 110);

		cities.insertEdge(mad, phi, 143);
		cities.insertEdge(mad, chi, 60);
		cities.insertEdge(mad, dal, 158);
		cities.insertEdge(mad, orl, 166);
		cities.insertEdge(mad, atl, 126);
		// cities.insertEdge(mad, bal, 0);
		// cities.insertEdge(mad, nyc, 300); NO DIRECT FLIGHT
		// cities.insertEdge(mad, la, 0); NO DIRECT FLIGHT
		// cities.insertEdge(mad, aus, 300); NO DIRECT FLIGHT
		// cities.insertEdge(mad, sj, 390); NO DIRECT FLIGHT
		// cities.insertEdge(mad, sea, 300); NO DIRECT FLIGHT

		cities.insertEdge(aus, chi, 155);
		cities.insertEdge(aus, nyc, 217);
		cities.insertEdge(aus, sea, 272);
		cities.insertEdge(aus, la, 200);
		cities.insertEdge(aus, orl, 143);
		cities.insertEdge(aus, dal, 70);
		cities.insertEdge(aus, sj, 233);
		cities.insertEdge(aus, atl, 125);
		cities.insertEdge(aus, bal, 180);
		// cities.insertEdge(aus, phi, 201); NO DIRECT FLIGHT
		// cities.insertEdge(aus, mad, 201); NO DIRECT FLIGHT
		
		cities.insertEdge(dal, aus, 67);
		cities.insertEdge(dal, la, 204);
		cities.insertEdge(dal, nyc, 189);
		cities.insertEdge(dal, mad, 139);
		cities.insertEdge(dal, orl, 153);
		cities.insertEdge(dal, chi, 130);
		cities.insertEdge(dal, sea, 263);
		cities.insertEdge(dal, phi, 183);
		cities.insertEdge(dal, sj, 235);
		cities.insertEdge(dal, atl, 115);
		cities.insertEdge(dal, bal, 165);

		cities.insertEdge(phi, chi, 155);
		cities.insertEdge(phi, nyc, 30);
		cities.insertEdge(phi, orl, 150);
		cities.insertEdge(phi, dal, 220);
		cities.insertEdge(phi, sea, 369);
		cities.insertEdge(phi, la, 350);
		cities.insertEdge(phi, atl, 129);
		// cities.insertEdge(phi, bal, 0); NO DIRECT FLIGHT
		// cities.insertEdge(phi, sj, 0); NO DIRECT FLIGHT
		// cities.insertEdge(phi, mad, 247); NO DIRECT FLIGHT
		// cities.insertEdge(phi, aus, 0); NO DIRECT FLIGHT

		cities.insertEdge(orl, la, 329);
		cities.insertEdge(orl, nyc, 149);
		cities.insertEdge(orl, mad, 180);
		cities.insertEdge(orl, aus, 163);
		cities.insertEdge(orl, dal, 180);
		cities.insertEdge(orl, phi, 146);
		cities.insertEdge(orl, sea, 334);
		cities.insertEdge(orl, chi, 183);
		cities.insertEdge(orl, atl, 92);
		cities.insertEdge(orl, bal, 126);
		// cities.insertEdge(orl, sj, 180); NO DIRECT

		cities.insertEdge(la, chi, 230);
		cities.insertEdge(la, aus, 169);
		cities.insertEdge(la, dal, 176);
		cities.insertEdge(la, sea, 162);
		cities.insertEdge(la, phi, 289);
		cities.insertEdge(la, orl, 280);
		cities.insertEdge(la, sj, 74);
		cities.insertEdge(la, nyc, 310);
		cities.insertEdge(la, atl, 240);
		cities.insertEdge(la, bal, 288);
		// cities.insertEdge(la, mad, 0); NO DIRECT FLIGHTS

		// all direct flights from Atlanta, GA
		cities.insertEdge(atl, chi, 111);
		cities.insertEdge(atl, aus, 138);
		cities.insertEdge(atl, sea, 329);
		cities.insertEdge(atl, la, 282);
		cities.insertEdge(atl, bal, 97);
		cities.insertEdge(atl, nyc, 118);
		cities.insertEdge(atl, orl, 93);
		cities.insertEdge(atl, phi, 112);
		cities.insertEdge(atl, dal, 128);
		cities.insertEdge(atl, mad, 125);
		// cities.insertEdge(atl, sj, 0);

		// all direct flights from Baltimore
		cities.insertEdge(bal, chi, 126);
		cities.insertEdge(bal, aus, 210);
		cities.insertEdge(bal, sea, 363);
		cities.insertEdge(bal, la, 360);
		cities.insertEdge(bal, atl, 106);
		cities.insertEdge(bal, orl, 139);
		cities.insertEdge(bal, dal, 227);
		// cities.insertEdge(bal, mad, 0); NO DIRECT FLIGHT
		// cities.insertEdge(bal, sj, 0); NO DIRECT FLIGHT
		// cities.insertEdge(bal, phi, 0); NO DIRECT FLIGHT
		// cities.insertEdge(bal, nyc, 0); NO DIRECT FLIGHT

	}

	/**
	 * This method accepts a CS400<Location> variable and will be initialized to the
	 * graph demonstrated in this method that comprises of all direct flights from
	 * one city to another along with the cost of a ticket per head in Dollars. All
	 * data has been collected from Google Flights (rb.gy/7lb1su). Lines kept as
	 * comments indicate that the path has been acknowledged, however, there is no
	 * direct flight between the two locations.
	 * 
	 * @param cities CS400<Location> type parameter passed in from the GAMethods
	 *               class which will then store the following graph as presented in
	 *               this method
	 * 
	 * @author aneesh
	 */
	protected void flightPrice(CS400Graph<Location> cities) {
		// insert all vertices for 12 cities
		cities.insertVertex(nyc);
		cities.insertVertex(chi);
		cities.insertVertex(dal);
		cities.insertVertex(la);
		cities.insertVertex(aus);
		cities.insertVertex(sea);
		cities.insertVertex(orl);
		cities.insertVertex(sj);
		cities.insertVertex(mad);
		cities.insertVertex(phi);
		cities.insertVertex(atl);
		cities.insertVertex(bal);

		// all direct flights from seattle
		cities.insertEdge(sea, sj, 321);
		cities.insertEdge(sea, la, 267);
		cities.insertEdge(sea, aus, 197);
		cities.insertEdge(sea, phi, 347);
		cities.insertEdge(sea, dal, 217);
		cities.insertEdge(sea, orl, 303);
		cities.insertEdge(sea, chi, 137);
		cities.insertEdge(sea, nyc, 229);
		cities.insertEdge(sea, atl, 289);
		// cities.insertEdge(sea, mad, 347); NO DIRECT FLIGHT
		// cities.insertEdge(sea, bal, 0); NO DIRECT FLIGHT

		// all direct flights from San Jose, CA
		// cities.insertEdge(sj, nyc, 394); NO DIRECT FLIGHT
		cities.insertEdge(sj, chi, 176);
		cities.insertEdge(sj, dal, 349);
		cities.insertEdge(sj, la, 99);
		cities.insertEdge(sj, aus, 380);
		cities.insertEdge(sj, sea, 114);
		// cities.insertEdge(sj, atl, 0); NO DIRECT FLIGHT
		// cities.insertEdge(sj, bal, 0); NO DIRECT FLIGHT
		// cities.insertEdge(sj, orl, 245); NO DIRECT FLIGHT
		// cities.insertEdge(sj, mad, 245); NO DIRECT FLIGHT
		// cities.insertEdge(sj, phi, 245); NO DIRECT FLIGHT

		// all direct flights from New York
		cities.insertEdge(nyc, la, 145);
		cities.insertEdge(nyc, aus, 299);
		cities.insertEdge(nyc, orl, 49);
		cities.insertEdge(nyc, chi, 199);
		cities.insertEdge(nyc, dal, 175);
		cities.insertEdge(nyc, phi, 70);
		cities.insertEdge(nyc, sea, 219);
		cities.insertEdge(nyc, atl, 104);
		// cities.insertEdge(nyc, bal, 0); NO DIRECT FLIGHT
		// cities.insertEdge(nyc, sj, 720); NO DIRECT FLIGHT
		// cities.insertEdge(nyc, mad, 0); NO DIRECT FLIGHT

		// all direct flights from Chicago
		cities.insertEdge(chi, la, 88);
		cities.insertEdge(chi, aus, 383);
		cities.insertEdge(chi, orl, 184);
		cities.insertEdge(chi, mad, 269);
		cities.insertEdge(chi, sj, 176);
		cities.insertEdge(chi, nyc, 99);
		cities.insertEdge(chi, dal, 174);
		cities.insertEdge(chi, sea, 89);
		cities.insertEdge(chi, phi, 124);
		cities.insertEdge(chi, atl, 38);
		cities.insertEdge(chi, bal, 104);

		// all direct flights from Madison

		cities.insertEdge(mad, phi, 211);
		cities.insertEdge(mad, chi, 269);
		cities.insertEdge(mad, dal, 201);
		cities.insertEdge(mad, orl, 64);
		cities.insertEdge(mad, atl, 199);
		// cities.insertEdge(mad, bal, 0); NO DIRECT FLIGHT
		// cities.insertEdge(mad, nyc, 300); NO DIRECT FLIGHT
		// cities.insertEdge(mad, la, 0); NO DIRECT FLIGHT
		// cities.insertEdge(mad, aus, 300); NO DIRECT FLIGHT
		// cities.insertEdge(mad, sj, 390); NO DIRECT FLIGHT
		// cities.insertEdge(mad, sea, 300); NO DIRECT FLIGHT

		// all direct flights from Austin, TX
		cities.insertEdge(aus, chi, 184);
		cities.insertEdge(aus, nyc, 77);
		cities.insertEdge(aus, sea, 224);
		cities.insertEdge(aus, la, 169);
		cities.insertEdge(aus, orl, 164);
		cities.insertEdge(aus, dal, 194);
		cities.insertEdge(aus, sj, 206);
		cities.insertEdge(aus, atl, 189);
		cities.insertEdge(aus, bal, 138);
		// cities.insertEdge(aus, phi, 201); NO DIRECT FLIGHT
		// cities.insertEdge(aus, mad, 201); NO DIRECT FLIGHT

		// all direct flights from Dallas
		cities.insertEdge(dal, aus, 124);
		cities.insertEdge(dal, la, 189);
		cities.insertEdge(dal, nyc, 60);
		cities.insertEdge(dal, mad, 201);
		cities.insertEdge(dal, orl, 124);
		cities.insertEdge(dal, chi, 209);
		cities.insertEdge(dal, sea, 205);
		cities.insertEdge(dal, phi, 134);
		cities.insertEdge(dal, sj, 237);
		cities.insertEdge(dal, atl, 69);
		cities.insertEdge(dal, bal, 107);

		// all direct flights from Philadelphia
		cities.insertEdge(phi, chi, 124);
		cities.insertEdge(phi, nyc, 60);
		cities.insertEdge(phi, orl, 26);
		cities.insertEdge(phi, dal, 127);
		cities.insertEdge(phi, sea, 138);
		cities.insertEdge(phi, la, 43);
		cities.insertEdge(phi, atl, 52);
		// cities.insertEdge(phi, bal, 0); NO DIRECT FLIGHT
		// cities.insertEdge(phi, sj, 0); NO DIRECT FLIGHT
		// cities.insertEdge(phi, mad, 247); NO DIRECT FLIGHT
		// cities.insertEdge(phi, aus, 0); NO DIRECT FLIGHT

		// all direct flights from Orlando, FL
		cities.insertEdge(orl, la, 89);
		cities.insertEdge(orl, nyc, 21);
		cities.insertEdge(orl, mad, 64);
		cities.insertEdge(orl, aus, 119);
		cities.insertEdge(orl, dal, 193);
		cities.insertEdge(orl, phi, 19);
		cities.insertEdge(orl, sea, 205);
		cities.insertEdge(orl, chi, 38);
		cities.insertEdge(orl, atl, 46);
		cities.insertEdge(orl, bal, 26);
		// cities.insertEdge(orl, sj, 180); NO DIRECT FLIGHT

		// all direct flights from Los Angeles, CA
		cities.insertEdge(la, chi, 52);
		cities.insertEdge(la, aus, 84);
		cities.insertEdge(la, dal, 102);
		cities.insertEdge(la, sea, 94);
		cities.insertEdge(la, phi, 43);
		cities.insertEdge(la, orl, 89);
		cities.insertEdge(la, sj, 123);
		cities.insertEdge(la, nyc, 89);
		cities.insertEdge(la, bal, 93);
		cities.insertEdge(la, atl, 88);
		// cities.insertEdge(la, mad, 0); NO DIRECT FLIGHTS

		// all direct flights from Atlanta, GA
		cities.insertEdge(atl, chi, 88);
		cities.insertEdge(atl, aus, 189);
		cities.insertEdge(atl, sea, 289);
		cities.insertEdge(atl, la, 119);
		cities.insertEdge(atl, bal, 104);
		cities.insertEdge(atl, nyc, 99);
		cities.insertEdge(atl, orl, 76);
		cities.insertEdge(atl, phi, 99);
		cities.insertEdge(atl, dal, 104);
		cities.insertEdge(atl, mad, 199);
		// cities.insertEdge(atl, sj, 0); NO DIRECT FLIGHT

		// all direct flights from Baltimore
		cities.insertEdge(bal, chi, 164);
		cities.insertEdge(bal, aus, 244);
		cities.insertEdge(bal, sea, 147);
		cities.insertEdge(bal, la, 128);
		cities.insertEdge(bal, atl, 104);
		cities.insertEdge(bal, orl, 103);
		cities.insertEdge(bal, dal, 82);
		// cities.insertEdge(bal, sj, 0); NO DIRECT FLIGHT
		// cities.insertEdge(bal, phi, 0); NO DIRECT FLIGHT
		// cities.insertEdge(bal, nyc, 0); NO DIRECT FLIGHT
		// cities.insertEdge(bal, mad, 0); NO DIRECT FLIGHT

	}
}
