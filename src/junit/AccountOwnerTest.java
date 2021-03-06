package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import banksystem.Account;
import banksystem.AccountOwner;
import database.Database;


public class AccountOwnerTest {
	Database dataBase = Database.getInstance();

	@Before
	public void setUp() throws Exception {
		Database.setFileName("test.dat");
		dataBase.eraseFile();
		dataBase.load();
	}
	
	@Test
	public void testAccountOwnerGetNull() {
		AccountOwner accountOwner = AccountOwner.get("doesNotExist");
		Assert.assertNull(accountOwner);
	}
	
	@Test
	public void testAccountValidation() {
		String validationResult = AccountOwner.validate("123456789101234567891012345678910", "password");
		Assert.assertEquals("Name must be less than 30 characters", validationResult);
	}
	
	@Test
	public void testAccountIdInt() {
		Integer accountOwnerIdInt=AccountOwner.getNextIdInt();
		Assert.assertEquals(Integer.class, accountOwnerIdInt.getClass());
	}
	
	@Test
	public void testValidateName() {
		AccountOwner accountOwner = new AccountOwner();
		accountOwner.setName("P");
		accountOwner.setPassword("password");
		Assert.assertEquals("password", accountOwner.getPassword());
		Assert.assertEquals("Name must be greater than 1 character", accountOwner.validate());
		Assert.assertEquals("Name must be greater than 1 character", accountOwner.validateName());		

	}
	
	
	@Test
	public void testSetAccountOwnerPassword() {
		AccountOwner accountOwner = new AccountOwner();		
		accountOwner.setPassword("password");
		Assert.assertEquals("password", accountOwner.getPassword());			
	}
	
	@Test	
	public void testGetNextAccountOwnerId() {
		AccountOwner accountOwner = new AccountOwner();
		accountOwner.put();
		assertEquals("O1001", accountOwner.getId());		
		assertEquals("O1002", AccountOwner.getNextId());	
	}
	
	@Test
	public void testValidateAccountOwner() {
		AccountOwner accountOwner = new AccountOwner("Phil", "P12345$#j");
		String validateOutput = accountOwner.validate();
		Assert.assertEquals("valid", validateOutput);
	}

	@Test
	public void nonExistingOwner() {
		assertEquals("Invalid Account Owner ID", AccountOwner.validateOwnerId("O1001"));
	}
	
	@Test
	public void existingOwner() {
		AccountOwner accountOwner = new AccountOwner();
		accountOwner.put();
		assertEquals("O1001", accountOwner.getId());
		assertEquals("valid", AccountOwner.validateOwnerId("O1001"));
		assertEquals("Invalid Account Owner ID", AccountOwner.validateOwnerId("O1002"));
	}
	
	@Test
	public void linkedAccount() {
		AccountOwner accountOwner = new AccountOwner();
		accountOwner.put();		
		Account account = new Account(accountOwner.getId(), "Checking", "100.00");
		account.put ();
		assertEquals("O1001", account.getOwnerId());
		Database.dump();
	}
	
	
	@Test
	public void validName() {
		String name = "First Last";
		Assert.assertEquals("valid", AccountOwner.validateName(name));
	}

	@Test
	public void minLength() {
		String name = "A";
		Assert.assertEquals("Name must be greater than 1 character",
				AccountOwner.validateName(name));
	}

	@Test
	public void maxLength() {
		String name = "012345678901234567890123456789N";
		Assert.assertEquals("Name must be less than 30 characters",
				AccountOwner.validateName(name));
	}
	
	@Test
	public void writeOwnerToDatabase() {
		AccountOwner owner = new AccountOwner("owner", "J$");
		owner.put();

		String ownerId = owner.getId();
		AccountOwner ownerWrittenToDatabase = AccountOwner.get(ownerId);

		Assert.assertEquals(ownerId, ownerWrittenToDatabase.getId());
		Assert.assertEquals("owner", ownerWrittenToDatabase.data.name);
		Assert.assertEquals("J$", ownerWrittenToDatabase.data.password);

	}
	
	@Test
	public void isAccountOwnerAGoat()
	{
		String name = "Goat";
		Assert.assertEquals("valid", AccountOwner.validateName(name));
	}
	
	@Test
	public void isAccountOwnerAZombie()
	{
		String name = "Zombie";
		Assert.assertEquals("valid", AccountOwner.validateName(name));
	}
	

}
