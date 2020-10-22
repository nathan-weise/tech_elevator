package com.techelevator.security;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class AsymmetricEncryptionExample {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter public key:");
		String pubKeyString = scan.nextLine();

		byte[] bytes = Base64.getDecoder().decode(pubKeyString);
		PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));

		System.out.println("Please enter message to encrypt:");
		String message = scan.nextLine();

		byte[] encrypted = encrypt(pubKey, message);
		String encryptedString = new String(Base64.getEncoder().encode(encrypted));

		System.out.println("Your encrypted message:");
		System.out.println(encryptedString);
	}

	public static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		return cipher.doFinal(message.getBytes());
	}

}
