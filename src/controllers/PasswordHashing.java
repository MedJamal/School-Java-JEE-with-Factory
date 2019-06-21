package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
	
	private String passwordToHash;
	private String generatedPassword;

	
	public PasswordHashing (String passwordToHash) {
		this.passwordToHash = passwordToHash;
	}

	public String getGeneratedPassword() {
		
	    try {
	    	
	        // Create MessageDigest instance for MD5
	    	MessageDigest md = MessageDigest.getInstance("MD5");
	    	
	        //Add password bytes to digest
	        md.update(this.passwordToHash.getBytes());
	        
	        //Get the hash's bytes
	        byte[] bytes = md.digest();
	        
	        //This bytes[] has bytes in decimal format;
	        //Convert it to hexadecimal format
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++) {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        //Get complete hashed password in hex format
	        return this.generatedPassword = sb.toString();
	        
	    } catch (NoSuchAlgorithmException e){
	        e.printStackTrace();
	        System.out.println("Error password hashing");
	        return null;
	    }
	}

}
