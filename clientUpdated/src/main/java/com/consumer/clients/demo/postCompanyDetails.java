package com.consumer.clients.demo;

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

import com.consumer.clients.readJsontoString;

public class postCompanyDetails {
	
	int port=8081;
	
	postCompanyDetails(){
		System.out.println("Default port = "+port);
	}
	
	public postCompanyDetails(int port){
		this.port=port;
		System.out.println("Custom port = "+port);
	}
	
	public static void main(String[] args) throws IOException {
		String response=new postCompanyDetails().addCompanyDetails();
	}
	
	
	
	public String addCompanyDetails() throws IOException{

		String url = String.format("Http://localhost:%d/company", port);
		String payload = new readJsontoString().readFile("C:\\Users\\Hidayath\\Desktop\\Pact_Request\\postCompanyDetails.txt");
		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.setEntity(entity);
		HttpResponse r;

		try {
			r = httpClient.execute(request);
			String json = EntityUtils.toString(r.getEntity());
			JSONObject jsonobj = new JSONObject(json);
			System.out.println("Json=" + json);

			String Id = jsonobj.get("Id").toString();
			return Id;

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
