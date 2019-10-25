package com.consumer.clients;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;

public class getUserDetailsClient {
	
	int port=8080;
	public getUserDetailsClient() {
	System.out.println("Using default port="+port);
	}
	
	public getUserDetailsClient(int port){
	this.port=port;
	System.out.println("Custom port="+port);
	}
	
	public static void main(String[] args) {
		String response=new getUserDetailsClient().getUserDetails();
		
	}
	
	public String getUserDetails(){
		String url=String.format("http://localhost:%d/users/1001", port);
		System.out.println("Using url:"+url);
		String JSONResponse=null;
		try {
			HttpResponse r=Request.Get(url).addHeader("Accept", "application/json").execute().returnResponse();
			JSONResponse=EntityUtils.toString(r.getEntity());
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONResponse;
		
		
	}

}
