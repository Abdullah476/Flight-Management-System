import java.util.Scanner;

public class FlightBooking {
	public static final Scanner in = new Scanner (System.in);
	protected int pnr;
	protected String flight;
	protected String arrivalTime;
	protected String departureTime;
	protected String dateOfJourney;
	protected int source;
	protected int destination;
	protected int choice;
	
	public FlightBooking() {
		pnr = 0;
		flight = "";
		arrivalTime = "";
		departureTime = "";
		dateOfJourney  = "";
		source = 0;
		destination = 0;
		choice = 0;		
	}
	
	public void init_pnr(int var) {
		pnr = var;
	}
	
	public void journeyDetails() {
		System.out.print("Enter DateOfJourney(DD-MM-YYYY): ");
		dateOfJourney = in.nextLine();
		System.out.println("\nSelect your source and destination");
		System.out.println("Enter (1) for London \nEnter (2) for Dubai \nEnter (3) for Abu Dhabi \nEnter (4) for Singapore \nEnter (5) for NewYork");
        System.out.print("Enter Source: ");
        source = in.nextInt();
        in.nextLine();
        System.out.print("Enter Destination: ");
        destination = in.nextInt();
        in.nextLine();
        System.out.println("\n****Available Flights****");
        
        if((source==1 && destination==3) || (source==3 && destination==1))
        {
        	System.out.println("Airline:\tDeparture:\tArrival:\tPrice:\t\tCategory:");
        	System.out.println("PIA(1)\t\t10:00\t\t14:05\t\tRs.25000\tRefundable");
        	System.out.println("Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tRefundable");
        	System.out.println("Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tRefundable");
        }

        else if((source==1 && destination==4) || (source==4 && destination==1))
        {
        	System.out.println("Airline:\tDeparture:\tArrival:\tPrice:\t\tCategory:");
        	System.out.println("PIA(1)\t\t10:00\t\t14:05\t\tRs.25500\tRefundable");
        	System.out.println("Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21300\tRefundable");
        	System.out.println("Emirates(3)\t18:00\t\t22:05\t\tRs.24650\tRefundable");
        }

        else if((source==1 && destination==5) || (source==5 || destination==1))
        {
        	System.out.println("Airline:\tDeparture:\tArrival:\tPrice:\t\tCategory:");
        	System.out.println("PIA(1)\t\t10:00\t\t14:05\t\tRs.52500\tRefundable");
        	System.out.println("Fly Dubai(2)\t14:00\t\t18:05\t\tRs.59420\tRefundable");
        	System.out.println("Emirates(3)\t18:00\t\t22:05\t\tRs.64892\tRefundable");
        }

        else if((source==2 && destination==3) || (source==3 && destination==2))
        {
        	System.out.println("Airline:\tDeparture:\tArrival:\tPrice:\t\tCategory:");
        	System.out.println("PIA(1)\t\t10:00\t\t14:05\t\tRs.17800\tRefundable");
        	System.out.println("Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tRefundable");
        	System.out.println("Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tRefundable");
        }

        else if((source==2 && destination==4) || (source==4 && destination==2))
        {
        	System.out.println("Airline:\tDeparture:\tArrival:\tPrice:\t\tCategory:");
        	System.out.println("PIA(1)\t\t10:00\t\t14:05\t\tRs.32000\tRefundable");
        	System.out.println("Fly Dubai(2)\t14:00\t\t18:05\t\tRs.38500\tRefundable");
        	System.out.println("Emirates(3)\t18:00\t\t22:05\t\tRs.41259\tRefundable");
        }

        else if(source==2 && destination==5 || (source==5 && destination==2))
        {
        	System.out.println("Airline:\tDeparture:\tArrival:\tPrice:\t\tCategory:");
        	System.out.println("PIA(1)\t\t10:00\t\t14:05\t\tRs.82500\tRefundable");
        	System.out.println("Fly Dubai(2)\t14:00\t\t18:05\t\tRs.87550\tRefundable");
        	System.out.println("Emirates(3)\t18:00\t\t22:05\t\tRs.81478\tRefundable");

        }
        else if(source == destination)
        {
        	System.out.println("No Flights Found! Try Again!\n");
            journeyDetails();
        }
        else
        {
        	System.out.println("No Flights Found! Try Again!\n");
            journeyDetails();
        }
	}
	
	public void selectFlight() {
		System.out.print("Enter Your Choice: ");
		choice = in.nextInt();
		in.nextLine();
        switch(choice)
        {
        case 1:
        	System.out.println("\nFlight selected:");
        	System.out.println("PIA");
        	System.out.println("Departure Time: 10:00");
        	System.out.println("Arrival Time: 14:05");
        	flight = "PIA";
        	departureTime = "10:00";
        	arrivalTime = "14:05";
            break;
            
        case 2:
        	System.out.println("\nFlight selected:");
        	System.out.println("Fly Dubai");
        	System.out.println("Departure Time: 14:00");
        	System.out.println("Arrival Time: 18:05");
        	flight = "Fly Dubai";
        	departureTime = "14:00";
        	arrivalTime = "18:05";
            break;
            
        case 3:
        	System.out.println("\nFlight selected:");
        	System.out.println("Emirates");
        	System.out.println("Departure Time: 18:00");
        	System.out.println("Arrival Time: 22:05");
        	flight = "Emirates";
        	departureTime = "18:00";
        	arrivalTime = "22:05";
            break;
            
        default:
        	System.out.println("Wrong Input Try Again!");
            selectFlight();
        }
	}
	
}
