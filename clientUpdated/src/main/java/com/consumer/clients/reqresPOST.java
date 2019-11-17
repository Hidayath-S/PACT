package com.consumer.clients;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class reqresPOST {
	int port=8081;
	
	reqresPOST(){
		System.out.println("Default port "+port);
	}
	
	public reqresPOST(int port){
		this.port=port;
        System.out.println("Custom port "+port);
		
	}
	
	public static void main(String[] args) {
		String response=new reqresPOST().postUserDetails();
	}
	
	
	
	
	
	
	public String postUserDetails() {
		String url=String.format("Http://localhost:%d/api/users",port);
		//String url=String.format("https://reqres.in/api/users");
		String payload="{"+"\"name\":\"morpheus\","+"\"job\":\"leader\""+"}";
		//String payload1="{"+"\"firstName\":\"Salman\","+"\"lastName\":\"S\","+"\"email\":\"sms9211@gmail.com\""+"}";
		StringEntity entity= new StringEntity(payload,
                ContentType.APPLICATION_JSON);
		
		HttpClient httpClient=HttpClientBuilder.create().build();
		HttpPost request=new HttpPost(url);
		request.setEntity(entity);
		HttpResponse r;
		
		try {
			r = httpClient.execute(request);
			String json=EntityUtils.toString(r.getEntity());
			JSONObject jsonobj=new JSONObject(json);
			//System.out.println("response status code="+r.getStatusLine().getStatusCode());
			System.out.println("Json="+json);
			
			String userId=jsonobj.get("id").toString();
			return userId;
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payload;
		
		
//		System.out.println("using the URL="+url);
//		try {
//			//HttpResponse r=Request.Get(url).addHeader("Accept","application/json").execute().returnResponse();
//			HttpResponse r=Request.Post(url).bodyForm(formParams)
//		String json=EntityUtils.toString(r.getEntity());
//		System.out.println("Json="+json);
//		JSONObject jsonobj=new JSONObject(json);
//		String fName=jsonobj.get("firstName").toString();
//		return fName;
//		
//		
//		
//		
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return url;
		
	}
	

}
