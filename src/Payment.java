import java.util.Scanner;

public class Payment {
	public static final Scanner in = new Scanner (System.in);
	protected int choice;
	protected int bank;
	protected String card;
	protected String date;
	protected String cvv;
	protected String userID;
	protected String password;
	
	public Payment() {
		choice = 0;
		bank = 0;
		card = "";
		date = "";
		cvv = "";
		userID = "";
		password = "";
	}
	
	public void payDetail() throws InvalidUserIDException, InvalidPasswordException, InvalidCardNumberException {
		System.out.println("\nEnter (1) for Debit Card");
		System.out.println("Enter (2) for Credit Card");
		System.out.println("Enter (3) for Net Banking");
		System.out.print("Option: ");
		choice = in.nextInt();
		in.nextLine();
        switch(choice)
        {
        case 1:
        	System.out.print("Enter Card Number(10-digits): ");
        	card = in.nextLine();
        	if(card.length() != 10) {
        		throw new InvalidCardNumberException("Invalid Card Number!");
        	}
        	System.out.print("Enter Expiry Date: ");
        	date = in.nextLine();
        	System.out.print("Enter CVV Number: ");
        	cvv = in.nextLine();
        	System.out.println("Transaction Successful!");
            break;
            
        case 2:
        	System.out.print("Enter Card Number(10-digits): ");
        	card = in.nextLine();
        	if(card.length() != 10) {
        		throw new InvalidCardNumberException("Invalid Card Number!");
        	}
        	System.out.print("Enter Expiry Date: ");
        	date = in.nextLine();
        	System.out.print("Enter Password: ");
        	password = in.nextLine();
        	System.out.println("Transaction Successful!");
            break;
            
        case 3:
        	System.out.println("\nAvailable Banks: ");
        	System.out.println("Enter (1) for West Pac Bank");
        	System.out.println("Enter (2) for Nabil Bank");
        	System.out.println("Enter (3) for Standard Chartered Bank");
        	System.out.print("Option: ");
        	bank = in.nextInt();
        	in.nextLine();
        	System.out.println("Selected Bank: " + bank);
        	System.out.print("Enter Use ID(5-digits): ");
        	userID = in.nextLine();
        	if(userID.length() != 5) {
        		throw new InvalidUserIDException("Invalid User-ID!");
        	}
        	System.out.print("Enter Password(8-digits): ");
        	password = in.nextLine();
        	if(password.length() != 8) {
        		throw new InvalidPasswordException("Invalid Password!");
        	}
        	System.out.println("Transaction Successful!");
            break;
            
        default:
        	System.out.println("Wrong Input! Try Again!");
            payDetail();
        }
	}	
}
