package phamthuy.ptit.helper;

import java.security.SecureRandom;

import org.mindrot.jbcrypt.BCrypt;

public class Helper {

	public static String randomString() {
		String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
		SecureRandom RANDOM = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 32; ++i)
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		return sb.toString();
	}

	public static long randomLong() {
		String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
		SecureRandom RANDOM = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 32; ++i)
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		return Long.parseLong(sb.toString());
	}

	// mã hóa password theo kiểu bCrypt
	public static String bCrypt(String password) {
		String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		return hash;
	}

	// giải mã password theo kiểu bCrypt
	public static boolean encryptionBCrypt(String password) {
		return BCrypt.checkpw(password, "$2a$12$OFOICietLS3.qRtzIe6jE.vF.fmtL22DqIZ18WNMmQ.8nS7Frq5aO");
	}

}
