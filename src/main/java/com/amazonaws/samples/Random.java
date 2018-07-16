package com.amazonaws.samples;

import java.util.HashSet;
import java.util.Set;

/*
 * The random generator. It has the sets of information that's used as the basis for the generated data.
 */
public class Random {

	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final String accountLexicon = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	final String phoneLexicon = "0123456789";
	final String[] companies = { "AT&T","Verizon", "T-Mobile", "Sprint", "MetroPCS"};
	final String[] email = {"@GMAIL.COM", "@COMCAST.NET", "@YAHOO.COM", "@CAPGEMINI.COM", "@BELLSOUTH.NET"};
	final java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	final Set<String> identifiers = new HashSet<String>();

	public String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomPhone1() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = 3;
	        for(int i = 0; i < length; i++) {
	            builder.append(phoneLexicon.charAt(rand.nextInt(phoneLexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomPhone2() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = 4;
	        for(int i = 0; i < length; i++) {
	            builder.append(phoneLexicon.charAt(rand.nextInt(phoneLexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomPhone3() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = 2;
	        for(int i = 0; i < length; i++) {
	            builder.append(phoneLexicon.charAt(rand.nextInt(phoneLexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomAccountNum() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(accountLexicon.charAt(rand.nextInt(accountLexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomZipCode() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = 5;
	        for(int i = 0; i < length; i++) {
	            builder.append(phoneLexicon.charAt(rand.nextInt(phoneLexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomAddrNum() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = 4;
	        for(int i = 0; i < length; i++) {
	            builder.append(phoneLexicon.charAt(rand.nextInt(phoneLexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomAddrStreet() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	    	int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public String randomCompany() {
	   int x = rand.nextInt(4)+0;
	    return companies[x];
	}
	
	public String randomEmailDomain() {
	   int y = rand.nextInt(4)+0;
	    return email[y];
	}
}
