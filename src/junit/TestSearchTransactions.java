package junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import banksystem.Account;
import banksystem.AccountOwner;
import banksystem.Deposit;
import banksystem.Withdrawal;
import database.Database;

public class TestSearchTransactions {

	Database database = Database.getInstance();

	@Before
	public void setUp() throws Exception {
		Database.setFileName("test.dat");
		database.eraseFile();
		database.load();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	//setup:
	//1. create an account
	//2. deposit $200 to the account
	//3. withdraw $100 from the account
	
	@Test
	public void setupAccount() throws Exception{
		
		String password="M$09230w";
		String owner="Michael";
				
		//create account owner and account connected to the owner
		AccountOwner newAccountOwner = new AccountOwner(owner, password);
		Account newAccount = new Account("O1001", "Checking", "50.00");
		
		//make deposit and withdrawal
		Deposit newDeposit = new Deposit("O1001", "A1001", "200.00");
		Withdrawal newWithdrawal = new Withdrawal("O1001", "A1001", "100.00");
		
		newAccount.put();
		newAccountOwner.put();
		
		newDeposit.put();
		newDeposit.updateBalance(password);
		
		newWithdrawal.put();
	 	newWithdrawal.updateBalance(password);

	 	//what is the final balance?
	 	System.out.println("balance: "+newAccount.getBalance());
	 	
	}
}
