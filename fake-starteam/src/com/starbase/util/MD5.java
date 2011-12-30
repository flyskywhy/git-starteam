/*****************************************************************************
 * All public interface based on Starteam API are a property of Borland, 
 * those interface are reproduced here only for testing purpose. You should
 * never use those interface to create a competitive product to the Starteam
 * Server. 
 * 
 * The implementation is given AS-IS and should not be considered a reference 
 * to the API. The behavior on a lots of method and class will not be the
 * same as the real API. The reproduction only seek to mimic some basic 
 * operation. You will not found anything here that can be deduced by using
 * the real API.
 * 
 * Fake-Starteam is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *****************************************************************************/
package com.starbase.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.ossnoize.fakestarteam.FileUtility;

public class MD5 {
	byte[] md5Sum = new byte[32];

	public MD5() {
	}
	
	public MD5(String stringMD5) {
		for(int i=0; i<md5Sum.length; i++) {
			try {
				md5Sum[i] = Byte.parseByte(stringMD5.substring(i, i+1), 16);
			} catch (NumberFormatException ne) {
				ne.printStackTrace();
			}
		}
	}
	
	public MD5(byte[] md5Array) {
		System.arraycopy(md5Array, 0, md5Sum, 0, md5Sum.length);
	}

	public long computeStreamMD5Ex(InputStream in) throws java.io.IOException {
		long fileLength = 0;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");

			byte buffer[] = new byte[64*1024];
			int read = in.read(buffer);
			while(read >= 0) {
				fileLength += read;
				digest.update(buffer, 0, read);
				read = in.read(buffer);
			}
			md5Sum = digest.digest();
		} catch (NoSuchAlgorithmException e) {
			throw new IOException("Could not find the algorithm: " + e.getMessage());
		}
		return fileLength;
	}
	
	public long computeFileMD5Ex(File file) throws java.io.IOException {
		long fileLength = 0;
		FileInputStream in = new FileInputStream(file);
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			
			byte buffer[] = new byte[64*1024];
			int read = in.read(buffer);
			while(read >= 0) {
				fileLength += read;
				digest.update(buffer, 0, read);
				read = in.read(buffer);
			}
			md5Sum = digest.digest();
		} catch (NoSuchAlgorithmException e) {
			FileUtility.close(in);
			throw new IOException("Could not find the algorithm: " + e.getMessage());
		}
		FileUtility.close(in);
		return fileLength;
	}

	public byte[] getData() {
		return md5Sum;
	}
	
	public void setData(byte[] digest) {
		System.arraycopy(digest, 0, md5Sum, 0, md5Sum.length);
	}
	
	public java.lang.String toHexString() {
		StringBuilder checkSumString = new StringBuilder();
		for(int i=0; i<md5Sum.length; i++) {
			int byteVal;
			if((0x80 & md5Sum[i]) != 0) {
				byteVal = md5Sum[i] & 0x7f;
				byteVal += 0x80;
			} else {
				byteVal = md5Sum[i];
			}
			String number = Integer.toString(byteVal, 16);
			if(number.length() == 1) {
				checkSumString.append(0).append(number);
			} else {
				checkSumString.append(number);
			}
		}
		return checkSumString.toString();
	}
	
}