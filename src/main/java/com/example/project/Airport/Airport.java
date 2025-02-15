package com.example.project.Airport;


import java.util.ArrayList;
import java.util.Arrays;

public class Airport  {
    /** A list of the flights into and out of this airport
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private ArrayList<Flight> allFlights;

    public Airport(ArrayList<Flight> flights) {
        allFlights = flights;
    }

    public ArrayList<Flight> getAllFlights() {
        return allFlights;
    }

 
    /** Returns the revenue generated by all flights at the airport,
     *  as described in part (a)
     */
    public double getTotalRevenue() {
       
        double total = 0.0;
        for (Flight flight : allFlights)
        {
            if (flight.getCapacity() < flight.getNumPassengers())
            {
                total += flight.getCapacity() * flight.getPrice();
            }
            else
            {
                total += flight.getNumPassengers() * flight.getPrice();
            }
        }
        return total;
    }

    public int updateFlights()
   {
       int c = 0;
       Flight currentFlight;
       for (int i = 0; i < allFlights.size(); i++)
       {
           currentFlight = allFlights.get(i);
           if (currentFlight.getCapacity() * 0.2 > currentFlight.getNumPassengers())
           {
               allFlights.remove(i);
               i--;
               c += currentFlight.getNumPassengers();
           }
       }
       return c;
   }


    public static void main(String[] args) 
    {
        // Flight f0 = new Flight(25, 50.00, 30);
        // Flight f1 = new Flight(10, 100.50, 60);
        // Flight f2 = new Flight(20, 100.00, 120);
        // Flight f3 = new Flight(50, 200.00, 40);
        // ArrayList<Flight> allFlights = new ArrayList<Flight>(Arrays.asList(f0, f1, f2, f3));
        // Airport capitalHub = new Airport(allFlights);
        // double revenue = capitalHub.getTotalRevenue();
        // System.out.println(revenue);


        Flight f0 = new Flight(25, 50.00, 30);
        Flight f1 = new Flight(10, 100.50, 60);
        Flight f2 = new Flight(20, 100.00, 120);
        Flight f3 = new Flight(50, 200.00, 40);
        ArrayList<Flight> allFlights = new ArrayList<Flight>(Arrays.asList(f0, f1, f2, f3));
        Airport capitalHub = new Airport(allFlights);
        int passengersWithRemovedFlights = capitalHub.updateFlights();
        System.out.println(passengersWithRemovedFlights);
     }

    /** Updates the list of flights by removing certain flights and
     *  returns the total number of passengers whose flights were removed,
     *  as described in part (b)
     */
    
}