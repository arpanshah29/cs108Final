package loginPackage;

import static org.junit.Assert.*;

import org.junit.*;

public class AccountManagerTest {

	AccountManager manager;
	
	@Before
	public void setUp() {
		manager = new AccountManager();
	}
	
	@Test
	public void testExists() {
		//assertTrue(manager.accountExists("Patrick"));
		//assertTrue(manager.accountExists("Molly"));
		assertTrue(!manager.accountExists("NotHere"));
		assertTrue(!manager.accountExists(""));
	}
	
	@Test
	public void testPassword() {
		//assertTrue(manager.checkPassword("Patrick", "1234"));
		//assertTrue(manager.checkPassword("Molly", "FloPup"));
		//assertTrue(!manager.checkPassword("Molly", "Flopup"));
		assertTrue(!manager.checkPassword("asdf", ""));
	}
	
	@Test
	public void testCreate() {
		assertTrue(manager.createAccount("Testing", "create"));
		assertTrue(manager.checkPassword("Testing", "create"));
		assertTrue(manager.accountExists("Testing"));
		assertTrue(!manager.createAccount("Testing", "differentCreate"));
		//assertTrue(!manager.createAccount("Patrick", "newPassword"));
		//assertTrue(!manager.checkPassword("Patrick", "newPassword"));
		//assertTrue(manager.checkPassword("Patrick", "1234"));
	}
	

}
