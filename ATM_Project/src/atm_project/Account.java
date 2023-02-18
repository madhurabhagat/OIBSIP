package atm_project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account 
{
        private int customerNumber;
	private int pinNumber;
        private double AccountBalance = 0;
        
        
        Scanner sc = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
   

	/* Set the customer number */

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	/* Get the customer number */

	public int getCustomerNumber() {
		return customerNumber;
	}

	/* Set the pin number */

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	/* Get the pin number */

	public int getPinNumber() {
		return pinNumber;
	}
        
        /* Get Account Balance */

	public double getAccountBalance() {
		return AccountBalance;
	}

	/* Calculate Account withdrawal */

	public double calcAccountWithdraw(double amount) {
		AccountBalance = (AccountBalance - amount);
		return AccountBalance;
	}
        
	/* Calculate Account deposit */

	public double calcAccountDeposit(double amount) {
		AccountBalance = (AccountBalance + amount);
		return AccountBalance;
	}
        
        public double calTransferMoney(double amount)
        {
            AccountBalance = (AccountBalance - amount);
		return AccountBalance;
        }
        
        /* Customer Checking Account Withdraw input */

	public void getAccountWithdrawInput() {
		System.out.println("Account Balance: " + moneyFormat.format(AccountBalance));
		System.out.print("Amount you want to withdraw from Account: ");
		double amount = sc.nextDouble();

		if ((AccountBalance - amount) >= 0) {
			calcAccountWithdraw(amount);
			System.out.println("New Account balance: " + moneyFormat.format(AccountBalance) + "\n");
		} 
                else 
                {
			System.out.println("Balance cannot be negative." + "\n");
		}
                
	}
        
        /* Customer Account Deposit input */

	public void getAccountDepositInput() {
		System.out.println("Account Balance: " + moneyFormat.format(AccountBalance));
		System.out.print("Amount you want to deposit from Account: ");
		double amount = sc.nextDouble();

		if ((AccountBalance + amount) >= 0) {
			calcAccountDeposit(amount);
			System.out.println("New Account balance: " + moneyFormat.format(AccountBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
        
        public void getTransferMoneyInput(){
            
                System.out.println("Account Balance: " + moneyFormat.format(AccountBalance));
		System.out.println("Enter Receipent's Name: ");
                 String receipent=sc.next();
                System.out.print("Amount you want to Transfer: ");
		double amount = sc.nextDouble();
                
            try{
                if(AccountBalance >= amount)
                {
                    if(amount<= AccountBalance)
                    {
                        int transaction = 0;
                        transaction++;
                        AccountBalance=AccountBalance-amount;
                        System.out.println("Successfully Transfered amount of rupees "+amount +receipent);
     
                    }
                    else{
                        System.out.println(" Sorry Insufficiant Amount ");
                    }
                }
            }
            catch(Exception ex)
                        {
                        
                        }
        }
}
