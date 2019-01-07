package com.first.test;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class httpClient {
	public static void main(String[] args) {
		File file=new File("src\\main\\resources\\requests\\userReq.json");
		
		try {
			HttpResponse r=Request.Get("http://localhost:8081/users/1002").addHeader("Accept","application/json").execute().returnResponse();
			//HttpResponse r1=Request.Post("http://localhost:8081/users").bodyFile(file,Accept application/json).addHeader("Accept","application/json").execute().returnResponse();
			String json=EntityUtils.toString(r.getEntity());
			//String header=EntityUtils.toString(r.getHeaders("Content-Type"));
			System.out.println(json);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
