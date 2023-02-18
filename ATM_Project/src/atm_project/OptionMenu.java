package atm_project;

import atm_project.Account;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
    
        int selection;
    
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	/* Validate Login information customer number and pin number */

	public void getLogin() throws IOException {
		int x = 1;

		do {
			try {
				/*
				 * Accounts in a HashMap, key = customer number, value = pin
				 * number
				 */
				data.put(123456789, 1234);
				data.put(123456780, 1230);

				System.out.println("Welcome to the ATM Project");

				System.out.print("Enter Your Account Number: ");
				setCustomerNumber(menuInput.nextInt());

				System.out.print("Enter Your Pin Number: ");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
				x = 2;
			}
			int cn=getCustomerNumber();
                        int pn=getPinNumber();
                        if(data.containsKey(cn) && data.get(cn)== pn)
                        {
                            getAccount();
                        }else{
			System.out.println("\n" + "Wrong Account123456789"
                                + " Number or Pin Number." + "\n");
                        }
                } while (x == 1);
	}
                
	/* Display Account Menu with selections */

	public void getAccount() {
		System.out.println("\n Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Transfer Funds");
		System.out.println("Type 5 - Exit");
		System.out.print("\n Choice: ");

		selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getAccountBalance()) + "\n");
			getAccount();
			break;

		case 2:
			getAccountWithdrawInput();
			getAccount();
			break;

		case 3:
			getAccountDepositInput();
			getAccount();
			break;
                        
                case 4:
                        getTransferMoneyInput();
                        getAccount();
                        break;

		case 5:
			System.out.println("Thank You for using this ATM, bye.");
			break;

		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getAccount();
		}
        }
}