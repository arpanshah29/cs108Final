
package loginPackage;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AccountManager implements Serializable {

	Hashtable<String, String> accounts;
	MessageDigest hashFn;

	public AccountManager() {
		accounts = new Hashtable<String, String>();
		try {
			hashFn = MessageDigest.getInstance("SHA");
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public boolean accountExists(String name) {
		return accounts.containsKey(name);
	}

	public boolean checkPassword(String name, String password) {
		if (!accountExists(name))
			return false;
		byte[] hashCode = hashFn.digest(password.getBytes());
		return accounts.get(name).equals(hexToString(hashCode));
	}

	public boolean createAccount(String name, String password) {
		if (accountExists(name)) {
			return false;
		}
		byte[] hashCode = hashFn.digest(password.getBytes());
		accounts.put(name, hexToString(hashCode));
		return true;
	}


	/* FOLLOWING CODE IS FROM ASSIGNMENT 4 */

	/*
	 Given a byte[] array, produces a hex String,
	 such as "234a6f". with 2 chars for each byte in the array.
	 (provided code)
	 */
	private static String hexToString(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<bytes.length; i++) {
			int val = bytes[i];
			val = val & 0xff;  // remove higher bits, sign
			if (val<16) buff.append('0'); // leading 0
			buff.append(Integer.toString(val, 16));
		}
		return buff.toString();
	}

	/*
	 Given a string of hex byte values such as "24a26f", creates
	 a byte[] array of those values, one byte value -128..127
	 for each 2 chars.
	 (provided code)
	 */
	private static byte[] hexToArray(String hex) {
		byte[] result = new byte[hex.length()/2];
		for (int i=0; i<hex.length(); i+=2) {
			result[i/2] = (byte) Integer.parseInt(hex.substring(i, i+2), 16);
		}
		return result;
	}

	// possible test values:
	// a 86f7e437faa5a7fce15d1ddcb9eaeaea377667b8
	// fm adeb6f2a18fe33af368d91b09587b68e3abcb9a7
	// a! 34800e15707fae815d7c90d49de44aca97e2d759
	// xyz 66b27417d37e024c46526c2f6d358a754fc552f3

	private String generateCode(String password) {
		byte[] hashCode = hashFn.digest(password.getBytes());
		return hexToString(hashCode);
	}
}
