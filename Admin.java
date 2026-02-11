
import java.util.ArrayList;

public class Admin extends User{

	private String adminId;
	private String password;
	public static int cancelledReservations=0;
	public static int cancelledPassengers =0;
	public Admin(String name, String email,String id,String pass) {
		super(name, email);
		this.adminId=id;
		this.password=pass;
	}

	public boolean authenticate(String input) {
		return this.password.equals(input);
	}
	@Override
	public void displayDetails() {
        System.out.println("Admin ID: " + adminId +
        		"\nName: " + name + 
        		"\nEmail: " + email);

		
	}
	
	public void viewAllFlights(ArrayList<Flight> flights) {
        System.out.println("\nAll Available Flights:");
        for (Flight f : flights) {
            System.out.println(f.getFlightId() +"--- Broading from Dhaka to--- "+ f.getDestination());
            System.out.println(f.getFlightId() +" has available seats: " + f.getAvailableSeats() + " out of " + f.getTotalSeats() + " total seats");
        }
    }

	public void viewAllReservations(ArrayList<Reservation> reservations) {
        System.out.println("\nAll Active Reservations: ");
        for (Reservation r : reservations) {
            System.out.println("Reservation ID: "+r.getReservationId());
            System.out.println("Passengers: "+r.getPasssengerCount());
            System.out.println("Flight no.: " + r.getFlightId()+ " broading from Dhaka to " +r.getFlightId().getDestination());
        }
}
	public void viewCancellationSeats() {
		System.out.println("\nCancellation Statistics: ");
		System.out.println("total Reservations Cancelled: " + cancelledReservations);
		System.out.println("total Passenger Affected: " + cancelledPassengers);

	}
	public static void record(int passengerCount) {
		cancelledReservations++;
		cancelledPassengers += passengerCount;
	}
}

