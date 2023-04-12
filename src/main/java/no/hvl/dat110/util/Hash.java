package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		// we use MD5 with 128 bits digest
		// compute the hash of the input 'entity'
		// convert the hash into hex format
		// convert the hex into BigInteger
		// return the BigInteger
		BigInteger hashint = null;
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(entity.getBytes());
			byte[] digest = md.digest();
			hashint = new BigInteger(1, digest);

		}catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}


		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5


		BigInteger addressSize = null;

		// compute the number of bits = bitSize()
			int numBits = bitSize();

		// compute the address size = 2 ^ number of bits
			 addressSize = BigInteger.valueOf(2).pow(numBits);

			// return the address size
		return addressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		digestlen = md.getDigestLength();
		// find the digest length
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
