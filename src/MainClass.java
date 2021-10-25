import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MainClass {
	public static final Scanner in = new Scanner (System.in);
	public static boolean dStatus = true;
	public static int tempVar = 1800;
	
	public static void savingDataInFile(Passenger p1) {
		
		String info = p1.getTicket();
		
		try {
			FileWriter writer = new FileWriter("Booking_Info.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write(info);
			bufferedWriter.newLine();
			bufferedWriter.close();
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void cancelTicket(int pnr) {
		String pnrString = Integer.toString(pnr);
		boolean status = true;
		try {
			FileReader reader = new FileReader("Booking_Info.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			FileWriter writer = new FileWriter("Booking_Info1.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			String data = null;
			while((data = bufferedReader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(data, "_");
				if(!(pnrString.equalsIgnoreCase(st.nextToken()))) {
					bufferedWriter.write(data);
					bufferedWriter.newLine();
				}
				else {
					status = false;
				}
			}
			//closing buffers and files
			bufferedReader.close();
			bufferedWriter.close();
			reader.close();
			writer.close();
			
			File f = new File("Booking_Info.txt");
			f.delete();
			File file2 = new File("Booking_Info.txt");
			File file1 = new File("Booking_Info1.txt");
			file1.renameTo(file2);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(status == false) {
			System.out.println("\nTicket Cancelled Successfully!");
		}
		else {
			System.out.println("\nTicket Details Not Found!");
		}
	}
	
	public static void checkTicketInformation(int pnr) {
		
		String pnrString = Integer.toString(pnr);
		String data = "";
		try {
            FileReader reader = new FileReader("Booking_Info.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String ticketInfo;
             
            while ((ticketInfo = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(ticketInfo, "_");
                if (pnrString.equalsIgnoreCase(st.nextToken())){
                	data = ticketInfo;
                	break;
                }
            }
            bufferedReader.close();
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(data != "") {
			StringTokenizer st = new StringTokenizer(data, "_");
			System.out.println("\n***Ticket***");
			System.out.println("PNR: " + st.nextToken());
			System.out.println("Flight: " + st.nextToken());
			System.out.println("Name: " +  st.nextToken());
			System.out.println("DOJ: " + st.nextToken());
			System.out.println("Departure Time: " + st.nextToken());
			System.out.println("Arrival Time: " + st.nextToken());
		}
		else {
			System.out.println("Ticket details not found!");
		}
		
	}
	
	public static void main(String[] args) {
		
		//Deleting file if exists
		if(dStatus == true) {
			try {
				File f = new File("Booking_info.txt");
				f.delete();
			}catch(Exception e) {
				e.printStackTrace();
			}
			dStatus = false;
		}
		
		char input = 'n';
		do {
			int ch;
			Passenger p1 = new Passenger();
			Payment pay = new Payment();
			System.out.println("\nWelcome To Flight Reservation System");
			System.out.println("Enter (1) for Book Flight");
			System.out.println("Enter (2) for Cancel Flight");
			System.out.println("Enter (3) for Check Ticket");
			System.out.println("Enter (4) for Exit");
			System.out.print("Option: ");
			ch = in.nextInt();
			while(ch != 1 && ch != 2 && ch != 3 && ch != 4) {
				System.out.println("Wrong Option! Enter Again!");
				System.out.print("Option: ");
				ch = in.nextInt();
				in.nextLine();
			}
		    switch(ch)
		    {
		    case 1:		//Booking Ticket
		    	p1.passengerDetails();
                p1.init_pnr(tempVar);
                p1.genderDetails();
                p1.extraDetails();
                try {
                	pay.payDetail();
                }catch(Exception e) {
                	System.out.println(e);
                	System.out.println("\nTry Again!\n");
                	break;
                }
                p1.display();
                savingDataInFile(p1);
                tempVar++;
                break;
                
            case 2:		//Ticket Cancellation
            	System.out.print("Enter you PNR number: ");
            	int pnr = in.nextInt();
            	in.nextLine();
            	cancelTicket(pnr);
            	break;
		    case 3:		//Check Booking Details
		    	System.out.print("Enter you PNR number: ");
            	int pnr1 = in.nextInt();
            	in.nextLine();
            	checkTicketInformation(pnr1);
            	break;
		    case 4:		//Exiting
		    	return; 
		    default:
		    	break;
		    }
		    System.out.print("\nDo you want to continue(y/Y): ");
			input = in.next().charAt(0);
		}while(input == 'y' || input == 'Y');
		in.close();
		System.out.println("\nThankyou For Using Flight Reservation System :)");
	}
}
