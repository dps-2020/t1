package junit;

import org.junit.Assert;
import org.junit.Test;

import banksystem.Account;
import banksystem.AccountOwner;
import database.Database;

public class AccountOwnerShip {

	Database dataBase = Database.getInstance();

	public void setUp() throws Exception {
		Database.setFileName("test.dat");
		dataBase.eraseFile();
		dataBase.load();
	}

	@Test
	public void test() {

		AccountOwner newAccountOwner = new AccountOwner("User One", "u!");
		newAccountOwner.put();
		AccountOwner newAccountOwner2 = new AccountOwner("User Two", "u2");
		newAccountOwner2.put();

		Account newAccount = new Account("O1001", "Checking", "50.00");
		newAccount.put();
		Account newAccount2 = new Account("O1001", "Savings", "50.00");
		newAccount2.put();
		Account newAccount3 = new Account("O1002", "Savings", "50.00");
		newAccount3.put();
		Account newAccount4 = new Account("O1002", "Checking", "250.00");
		newAccount4.put();

		Assert.assertEquals("A1004", Account.get("A1004").getId());
		Assert.assertEquals("O1002", AccountOwner.get("O1002").getId());
	}
}
