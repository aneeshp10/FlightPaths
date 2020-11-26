import java.util.Scanner;

/**
 * This class implements the user interface of GA Flights application
 * 
 * @author Tavish
 */
public class GAFlights {

  private Scanner scan; // scan input from user
  protected GAMethods gaFunction; // functions to get flight and hotel info
  private CS400Graph<Location>.Vertex travelDestination; // travel destination
  private CS400Graph<Location>.Vertex departureCity; // departure city
  private CS400Graph<Location>.Vertex arrivalCity; // arrival city

  // main menu
  static private String menu =
      "*********************************************************************************\n"
          + "*                                                                               *\n"
          + "*  USER MENU                                                                    *\n"
          + "*                                                                               *\n"
          + "*  --> To find shortest and cheapest flights                   [Press 1]        *\n"
          + "*  --> To find hotels at your travel destination               [Press 2]        *\n"
          + "*  --> To quit the application                                 [Press 3]        *\n"
          + "*                                                                               *\n"
          + "*********************************************************************************";

  // list of cities
  static private String cities =
      "\n*********************************************************************************\n"
          + "*                    CITIES                  *                                  *\n"
          + "*                                            *                 _                *\n"
          + "* --> New York City     --> Los Angeles      *               -=\\`\\              *\n"
          + "* --> Madison           --> Orlando          *           |\\ ____\\_\\__           *\n"
          + "* --> Chicago           --> Seattle          *         -=\\c`\"\"\"\"\"\"\" \"`)         *\n"
          + "* --> Dallas            --> Austin           *            `~~~~~/ /~~`          *\n"
          + "* --> San Jose          --> Atlanta          *              -==/ /              *\n"
          + "* --> Philadelphia      --> Baltimore        *                '-'               *\n"
          + "*                                            *                                  *\n"
          + "*********************************************************************************\n";

  /**
   * This constructor initializes instance variables for the GA Flights application
   * 
   */
  public GAFlights() {
    scan = new Scanner(System.in);
    gaFunction = new GAMethods();
    travelDestination = null;
    departureCity = null;
    arrivalCity = null;
  }

  /**
   * This method implements the user interface for the GA Flights application
   * 
   */
  public void userInterface() {
    boolean start = true; // if app is running
    String input = "";

    // application description
    System.out.println(
        "*  Welcome to this GA Flights!                                                  *\n"
            + "*                                                                               *\n"
            + "*  This flight navigation app is designed to help you find the shortest         *\n"
            + "*  and cheapest flights between two locations. Moreover, you can use            *\n"
            + "*  this app to search for hotels at your travel destination!                    *\n"
            + "*                                                                               *");

    // while the app is running
    while (start) {
      System.out.println(menu);
      System.out.print("\n~ ");
      input = scan.nextLine().trim().toLowerCase();

      // check if input from user matches the expected output
      if (input.equals("1")) {
        getFlightInfo();
      } else if (input.equals("2")) {
        getHotelInfo();
      } else if (input.equals("3")) {
        start = false; // make start false if user chooses to quit application
      } else {
        System.out.println("\nInvalid input, please try again.\n");
      }
    }
  }

  /**
   * This method is used to find the shortest and cheapest flight path based on user input
   * 
   */
  protected void getFlightInfo() {
    boolean running = true; // true while looking for flights
    String city = "";

    // while looking for flights
    while (running) {
      System.out.println(cities);
      System.out.println("Enter city of departure from the list above\n");
      System.out.print("~ ");
      city = scan.nextLine().trim().toLowerCase(); // take input from the user

      // look for the departure city in the list of cities in the database
      for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
        if (city.equals(location.data.getName().toLowerCase())) {
          departureCity = location;
          break;
        }
      }

      // if city not found, prompt the user to input city again based on the list
      if (departureCity == null) {
        System.out.println("\nInvalid city of departure, please enter valid city name");
        continue;
      } else {
        // boolean variable to check if arrival city is already chosen by the user
        boolean arrivalInput = (arrivalCity == null) ? false : true;

        // while the arrival city isn't chosen
        while (!arrivalInput) {
          System.out.println(cities);
          System.out.println("Enter city of arrival from the list above\n");
          System.out.print("~ ");
          city = scan.nextLine().trim().toLowerCase(); // take input from the user

          // look for the arrival city in the list of cities in the database
          for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
            if (city.equals(location.data.getName().toLowerCase())
                && !city.equals(departureCity.data.getName().toLowerCase())) {
              arrivalCity = location;
              arrivalInput = true;
              break;
            }
          }
          // if city not found, prompt the user to input city again based on the list
          if (arrivalInput == false) {
            System.out.println("\nInvalid city of arrival, please enter valid city name");
          }
        }
      }
      // add delay while searching for flights
      addDelay("Searching");

      // best path for the price and duration of flights
      System.out.println(
          "-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=--=x=--=x=--=x=--=x=-");
      gaFunction.printBothPaths(departureCity.data, arrivalCity.data);
      System.out.println(
          "-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=--=x=--=x=--=x=--=x=-\n");
      System.out.println(
          "*********************************************************************************\n"
              + "                                                                                *\n"
              + "--> To go back to the main menu                              [Press 0]          *\n"
              + "--> To search for hotels at your travel destination          [Press 1]          *\n"
              + "--> To search for other flights                              [Press any key]    *\n"
              + "                                                                                *\n"
              + "*********************************************************************************\n");
      System.out.print("~ ");
      String userInput = scan.nextLine().trim(); // take input from user

      // check if input from user matches the expected output
      if (userInput.trim().equals("1")) {
        // make tavel destination equal to arrival city to search for hotels
        travelDestination = arrivalCity;
        getHotelInfo();
        running = false;
      } else if (userInput.trim().equals("0")) {
        // add delay when going back to main menu
        addDelay("Going back to main menu");
        // make departure and arrival city null for next search
        departureCity = null;
        arrivalCity = null;
        running = false;
      } else {
        // make depature and arrival city null for next search
        departureCity = null;
        arrivalCity = null;
      }
    }
  }

  /**
   * This method is used to find a list of hotels and the cheapest hotel based on user input
   * 
   */
  protected void getHotelInfo() {
    boolean running = true; // true while looking for hotels
    String city = "";

    // while looking for hotels
    while (running) {
      // check if user already chose a travel destination
      if (travelDestination == null) {
        System.out.println(cities);
        System.out.println("Select a travel destination from the list above\n");
        System.out.print("\n~ ");
        city = scan.nextLine().trim().toLowerCase(); // take input from user

        // look for travel destination in the list of cities in the database
        for (CS400Graph<Location>.Vertex location : gaFunction.price.vertices.values()) {
          if (city.equals(location.data.getName().toLowerCase())) {
            travelDestination = location;
            break;
          }
        }

        // if city not found, prompt the user to input city again based on the list
        if (travelDestination == null) {
          System.out.println("\nInvalid travel destination, please enter valid city name");
          continue;
        }
      } else {
        // add delay while searching for hotels
        addDelay("Searching");

        // list of hotels and the best hotel for the price
        System.out.println(
            "\n-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=--=x=--=x=--=x=--=x=-");
        System.out
            .println("Here are a list of hotels in " + travelDestination.data.getName() + ":\n");
        travelDestination.data.printHotelList();
        System.out
            .print("\nBest Hotel for the price in " + travelDestination.data.getName() + ":\t");
        System.out.println(travelDestination.data.bestHotel().getName()
            + "\n-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=--=x=--=x=--=x=--=x=-\n");
        System.out.println(
            "*********************************************************************************\n"
                + "                                                                                *\n"
                + "--> To go back to the main menu                              [Press 0]          *\n"
                + "--> To search for flights to your travel destination         [Press 1]          *\n"
                + "--> To search for other hotels                               [Press any key]    *\n"
                + "                                                                                *\n"
                + "*********************************************************************************\n");
        System.out.print("~ ");
        String userInput = scan.nextLine().trim(); // take input from user

        // check if input from user matches the expected output
        if (userInput.trim().equals("1")) {
          // make arrival city equal to travel destination to search for flights
          arrivalCity = travelDestination;
          getFlightInfo();
          running = false;
        } else if (userInput.trim().equals("0")) {
          System.out.println();
          // make travel destination null for next search
          travelDestination = null;
          running = false;
        } else {
          // make travel destination null for next search
          travelDestination = null;
        }
      }
    }
  }

  /**
   * This addDelay method puts a small delay after input to the console and is used to add delay
   * when going back to main menu or searching for flights and hotels
   * 
   * @param message to display for the reason of delay
   */
  private void addDelay(String message) {
    System.out.print("\n" + message);
    try {
      int i = 3;
      while (i > 0) {
        Thread.sleep(1000);
        System.out.print(".");
        i--;
      }
      System.out.println("\n");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  /**
   * This main method is used to set up and run the GA Flights application
   * 
   * @param args if any
   */
  public static void main(String[] args) {
    GAFlights flights = new GAFlights();

    // welcome message
    System.out.println(
        "*********************************************************************************\n"
            + "*                         __        __     __     ___ __                        *\n"
            + "*        __|__           / _  /\\   |_ |  |/ _ |__| | (_           __|__         *\n"
            + "*  *---o--(_)--o---*     \\__)/--\\  |  |__|\\__)|  | | __)    *---o--(_)--o---*   *\n"
            + "*                                                                               *\n"
            + "*********************************************************************************\n"
            + "*                                                                               *");

    flights.userInterface(); // runs the application user interface

    // end message
    System.out.println(
        "\n*********************************************************************************\n"
            + "*                          *                         *                          *\n"
            + "*          __|__           *   THANK YOU FOR USING   *           __|__          *\n"
            + "*    *---o--(_)--o---*     *       GA FLIGHTS!       *     *---o--(_)--o---*    *\n"
            + "*                          *                         *                          *\n"
            + "*********************************************************************************\n");
  }
}
