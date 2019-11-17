package com.consumer.clients.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class getCompanyDetailsClient {
	int port;

	getCompanyDetailsClient() {
		System.out.println("Default port " + port);
	}

	public getCompanyDetailsClient(int port) {
		this.port = port;
		System.out.println("Custom port " + port);

	}

	public static void main(String[] args) {
		String response = new getCompanyDetailsClient().getCompanyDetails();
	}

	public String getCompanyDetails() {
		// String url="http://services.groupkt.com/country/get/iso3code/IND";
		String url = String.format("http://localhost:%d/company/ALL", port);
		System.out.println("using the URL=" + url);
		try {
			//HttpResponse r = Request.Get(url).addHeader("Accept", "application/json").execute().returnResponse();
			HttpResponse r = Request.Get(url).execute().returnResponse();
			String json = EntityUtils.toString(r.getEntity());
			System.out.println("Json=" + json);
			

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
