import java.util.Scanner;

public class Passenger extends FlightBooking{
	public static final Scanner in = new Scanner (System.in);
	protected String firstName;
	protected String lastName;
	protected String email;
	protected int age;
	protected int gender;
	protected String contactNumber;
	
	Passenger(){
		firstName = "";
		lastName = "";
		email = "";
		age = 0;
		gender = 0;
		contactNumber = "";
	}
	
	public void passengerDetails() {
		journeyDetails();
		selectFlight();
		System.out.println("\n***Enter Passenger Details***");
		System.out.print("Enter First Name: ");
		firstName = in.nextLine();
		System.out.print("Enter Last Name: ");
		lastName = in.nextLine();
	}
	
	public void genderDetails() {
		System.out.println("Enter (1) for Male");
		System.out.println("Enter (2) for Female");
		System.out.print("Option: ");
		gender = in.nextInt();
		in.nextLine();
        if(gender!=1 && gender!=2)
        {
        	System.out.println("Wrong Input! Try Again!");
            genderDetails();
        }
	}
	
	public void extraDetails() {
		System.out.print("Enter Age: ");
		age = in.nextInt();
		in.nextLine();
		System.out.print("Enter E-mail: ");
		email = in.nextLine();
		System.out.print("Enter Contact Number: ");
		contactNumber = in.nextLine();
		System.out.println("\n***Entered Details***");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Gender: " + gender);
		System.out.println("Age: " + age);
		System.out.println("E-mail ID: " + email);
		System.out.println("Contact No.: " + contactNumber);
	}
	
	public int getpnr() {
		return pnr;
	}
	
	public void display() {
		System.out.println("\n***Ticket***");
		System.out.println("PNR: " + pnr);
		System.out.println("Flight: " + flight);
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("DOJ: " + dateOfJourney);
		System.out.println("Departure Time: " + departureTime);
		System.out.println("Arrival Time: " + arrivalTime);
	}
	
	public String getTicket() {
		return (Integer.toString(pnr) + "_" + flight + "_" + firstName + " " + lastName
				+ "_" + dateOfJourney + "_" + departureTime + "_" + arrivalTime);
	}
	
}
