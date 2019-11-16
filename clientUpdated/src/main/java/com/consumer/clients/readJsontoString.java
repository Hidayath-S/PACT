package com.consumer.clients;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readJsontoString {
	
	
	public static void main(String[] args) throws IOException {
		String fileContent=new readJsontoString().readFile("C:\\Users\\Hidayath\\Desktop\\Pact_Request\\postCompanyDetails.txt");
		System.out.println(fileContent);
	}
	
	public String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }}

}
