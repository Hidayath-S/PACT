package com.consumer.clients;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

public class GetHoliday {
	
int port=8081;
	
GetHoliday(){
		System.out.println("Default port "+port);
	}
	
GetHoliday(int port){
		this.port=port;
        System.out.println("Custom port "+port);
		
	}
	
	public static void main(String[] args) {
		String response=new GetHoliday().HolidayDetails();
	}
	
	public String HolidayDetails()  {
		String url=String.format("Http://localhost:%d/api/users",port);
		//String url=String.format("https://reqres.in/api/users");
		//String payload="{"+"\"name\":\"morpheus\","+"\"job\":\"leader\""+"}";
		//String payload1="{"+"\"firstName\":\"Salman\","+"\"lastName\":\"S\","+"\"email\":\"sms9211@gmail.com\""+"}";
		
		JSONParser parser=new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader("C:\\Users\\Hidayath\\Desktop\\request.json"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject jsonobj= (JSONObject)obj;
		String payload=jsonobj.toString();
		StringEntity entity= new StringEntity(payload,
                ContentType.APPLICATION_JSON);
		
		HttpClient httpClient=HttpClientBuilder.create().build();
		HttpPost request=new HttpPost(url);
		request.setEntity(entity);
		HttpResponse r;
		
		try {
			r = httpClient.execute(request);
			String json=EntityUtils.toString(r.getEntity());
			JSONObject jsonobj1=new JSONObject(json);
			//System.out.println("response status code="+r.getStatusLine().getStatusCode());
			System.out.println("Json="+json);
			
			String userId=jsonobj1.get("id").toString();
			return userId;
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payload;
	
	}
}
