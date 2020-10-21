package com.techelevator.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class AsymmetricKeyGenerator {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		final int keySize = 2048;
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(keySize);
		KeyPair keyPair = keyPairGenerator.genKeyPair();

		PublicKey pubKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		String pubKeyString = Base64.getEncoder().encodeToString(pubKey.getEncoded());
		System.out.println("Public key:");
		System.out.println(pubKeyString);

		String privKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
		System.out.println("Private key:");
		System.out.println(privKeyString);
	}

}
