package com.techelevator.security;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class AsymmetricDecryptionExample {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter encrypted message:");
		String encryptedMessage = scan.nextLine();

		System.out.println("Please enter private key:");
		String privateKeyString = scan.nextLine();

		byte[] bytes = Base64.getDecoder().decode(privateKeyString);
		PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytes));

		bytes = Base64.getDecoder().decode(encryptedMessage);
		byte[] decrypted = decrypt(privateKey, bytes);

		System.out.println("Your decrypted message:");
		System.out.println(new String(decrypted));
	}

	public static byte[] decrypt(PrivateKey privateKey, byte[] encrypted) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		return cipher.doFinal(encrypted);
	}

}
