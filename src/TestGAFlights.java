import org.junit.jupiter.api.Test;
import static org.junit.Assert.fail;
import java.io.ByteArrayInputStream;

/**
 * This class implements test methods for GAFlights program.
 * 
 * @author Jeff
 */
public class TestGAFlights extends CS400Graph<Location> {
  public CS400Graph<Location> price;
  public CS400Graph<Location> duration;
  public FlightData loader;
  public CS400Graph<Location> cities;
  public CS400Graph<Location>.Vertex departureCity;
  public CS400Graph<Location>.Vertex arrivalCity;
  public GAMethods gaFunction;
  public CS400Graph<Location>.Vertex travelDestination;

  @Test
  /**
   * This test checks if the path between two cities returns the correct price.
   * 
   */
  public void checkPathPrice() {



    gaFunction = new GAMethods();
    CS400Graph<Location>.Vertex departureCity = null;
    CS400Graph<Location>.Vertex arrivalCity = null;
    String city = "chicago";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city.equals(location.data.getName().toLowerCase())) {
        departureCity = location;
        break;
      }
    }
    String city2 = "orlando";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city2.equals(location.data.getName().toLowerCase())
          && !city2.equals(departureCity.data.getName().toLowerCase())) {
        arrivalCity = location;

        break;
      }
    }

    Path pricePath = gaFunction.price.dijkstrasShortestPath(departureCity.data, arrivalCity.data);

    int temp = pricePath.distance;


    if (temp != 114) {
      fail();
    }



  }

  @Test
  /**
   * This test checks if the program returns the cheapest hotel in a given city.
   * 
   */
  public void getHotelInfoTest() {

    gaFunction = new GAMethods();
    String city = "chicago";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city.equals(location.data.getName().toLowerCase())) {
        travelDestination = location;
        break;
      }
    }
    if (travelDestination.data.bestHotel().getName() != "Godfrey") {
      fail();
    }

  }

  @Test
  /**
   * This test checks if the path between two cities returns the correct distance.
   * 
   */
  public void getFlightInfoTest() {

    gaFunction = new GAMethods();
    CS400Graph<Location>.Vertex departureCity = null;
    CS400Graph<Location>.Vertex arrivalCity = null;
    String city = "chicago";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city.equals(location.data.getName().toLowerCase())) {
        departureCity = location;
        break;
      }
    }
    String city2 = "orlando";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city2.equals(location.data.getName().toLowerCase())
          && !city2.equals(departureCity.data.getName().toLowerCase())) {
        arrivalCity = location;

        break;
      }
    }

    Path durationPath =
        gaFunction.duration.dijkstrasShortestPath(departureCity.data, arrivalCity.data);

    int temp = durationPath.distance;


    if (temp != 159) {
      fail();
    }


  }

  @Test
  /**
   * This test checks if the user interface runs correctly given inputs.
   * 
   */
  public void userInterfaceTest() {
    String userInput = "1" + System.getProperty("line.separator") + "Chicago"
        + System.getProperty("line.separator") + "Orlando" + System.getProperty("line.separator")
        + "0" + System.getProperty("line.separator") + "3";

    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
    try {
      // run the application and check program flow
      GAFlights flights = new GAFlights();
      flights.userInterface();
    } catch (Exception e) {
      e.printStackTrace();
      fail("The display interface interface is incorrect");
    }
  }

  @Test
  /**
   * This test checks if the path between two cities returns the correct score when path has
   * stopover/no stopover.
   * 
   */
  public void getScoreTest() {

    gaFunction = new GAMethods();
    CS400Graph<Location>.Vertex departureCity = null;
    CS400Graph<Location>.Vertex arrivalCity = null;
    String city = "chicago";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city.equals(location.data.getName().toLowerCase())) {
        departureCity = location;
        break;
      }
    }
    String city2 = "orlando";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city2.equals(location.data.getName().toLowerCase())
          && !city2.equals(departureCity.data.getName().toLowerCase())) {
        arrivalCity = location;

        break;
      }
    }

    Path durationPath =
        gaFunction.duration.dijkstrasShortestPath(departureCity.data, arrivalCity.data);

    int temp = 11 - durationPath.dataSequence.size();


    if (temp != 9) {
      fail();
    }
  }

  @Test
  /**
   * This test checks if the data has been loaded in correctly by checking a vertex to see if it
   * contains the city.
   * 
   */
  public void loadDataTest(){

    gaFunction = new GAMethods();
    String city = "chicago";
    for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
      if (city.equals(location.data.getName().toLowerCase())) {
        travelDestination = location;
        break;
      }
    }
    if (!gaFunction.price.containsVertex(travelDestination.data)) {
      fail();
    }


  }

  @Test
  /**
   * This test checks if the printPath function runs correctly.
   * 
   */
  public void printPathsTest(){
    try {

      gaFunction = new GAMethods();
      CS400Graph<Location>.Vertex departureCity = null;
      CS400Graph<Location>.Vertex arrivalCity = null;
      String city = "chicago";
      for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
        if (city.equals(location.data.getName().toLowerCase())) {
          departureCity = location;
          break;
        }
      }
      String city2 = "orlando";
      for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
        if (city2.equals(location.data.getName().toLowerCase())
            && !city2.equals(departureCity.data.getName().toLowerCase())) {
          arrivalCity = location;

          break;
        }
      }
      gaFunction.printBothPaths(departureCity.data, arrivalCity.data);
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }



  }



}
