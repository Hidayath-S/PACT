package com.consumer.clients;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class users_POSTClient {
	int port=8081;
	
	users_POSTClient(){
		System.out.println("Default port "+port);
	}
	
	public users_POSTClient(int port){
		this.port=port;
        System.out.println("Custom port "+port);
		
	}
	
	public static void main(String[] args) {
		String response=new users_POSTClient().getUserDetails();
	}
	
	
	
	
	
	
	public String getUserDetails() {
		String url=String.format("https://reqres.in:%d/api/users",port);
		System.out.println("using the URL="+url);
		try {
			HttpResponse r=Request.Get(url).addHeader("Accept","application/json").execute().returnResponse();
		String json=EntityUtils.toString(r.getEntity());
		System.out.println("Json="+json);
		JSONObject jsonobj=new JSONObject(json);
		String fName=jsonobj.get("page").toString();
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
