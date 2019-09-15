package com.consumer.clients;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class MobileWsClient {
	int port=8081;
	
	MobileWsClient(){
		System.out.println("Default port "+port);
	}
	
	public MobileWsClient(int port){
		this.port=port;
        System.out.println("Custom port "+port);
		
	}
	
	public static void main(String[] args) {
		String response=new MobileWsClient().getUserDetails("1002");
	}
	
	
	
	
	
	
	public String getUserDetails(String userId) {
		String url=String.format("https://localhost:%d/users/%s",port,userId);
		System.out.println("using the URL="+url);
		try {
			HttpResponse r=Request.Get(url).addHeader("Accept","application/json").execute().returnResponse();
		String json=EntityUtils.toString(r.getEntity());
		System.out.println("Json="+json);
		JSONObject jsonobj=new JSONObject(json);
		String fName=jsonobj.get("firstName").toString();
		return fName;
		
		
		
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
		
	}
	

}
