package com.shagaba.jacksync.utils;

import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * Utility methods to compute and validate checksums.
 * 
 * @author Shagaba
 *
 */
public final class ChecksumUtils {
	
	private ChecksumUtils() {
	}

	/**
	 * Compute and return the checksum value (using the default CRC-32
	 * algorithm) of the contents on the given string
	 * 
	 * @param string the given string
	 * @return a checksum value for the given string.
	 */
	public static String computeChecksum(String string) {
		if (string == null || string.isEmpty()) {
			throw new IllegalArgumentException("Input string cannot be null or empty");
		}
		try {
			byte[] jsonBytes = string.getBytes("UTF-8");
			return computeChecksum(jsonBytes);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Compute and return the checksum value (using the default CRC-32
	 * algorithm) of the contents on the given byte array
	 * 
	 * @param byteArray the byte array to compute the checksum value with
	 * @return a checksum value for the given byte array.
	 */
	public static String computeChecksum(byte[] byteArray) {
		Checksum checksum = new CRC32();
		checksum.update(byteArray, 0, byteArray.length);
		return Long.toHexString(checksum.getValue());
	}

	/**
	 * Validates that the data in the specified receivedChecksum matches the checksum
	 * value of the given string
	 * 
	 * @param string the given string
	 * @param receivedChecksum the received checksum to verify
	 * @return
	 */
	public static boolean verifyChecksum(String string, String receivedChecksum) {
		if (string == null || string.isEmpty()) {
			throw new IllegalArgumentException("Input string cannot be null or empty");
		}
		if (receivedChecksum == null || receivedChecksum.isEmpty()) {
			throw new IllegalArgumentException("Checksum cannot be null or empty");
		}
		String checksum = computeChecksum(string);
		return Objects.equals(checksum, receivedChecksum);
	}

	/**
	 * Validates that the data in the specified receivedChecksum matches the checksum
	 * value of the given byte array
	 * 
	 * @param byteArray
	 * @param receivedChecksum the received checksum to verify
	 * @return
	 */
	public static boolean verifyChecksum(byte[] byteArray, String receivedChecksum) {
		if (receivedChecksum == null || receivedChecksum.isEmpty()) {
			throw new IllegalArgumentException("checksum cannot be null or empty");
		}
		String checksum = computeChecksum(byteArray);
		return Objects.equals(checksum, receivedChecksum);
	}
}
