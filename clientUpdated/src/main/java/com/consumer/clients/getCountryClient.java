package com.consumer.clients;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class getCountryClient {
	int port;

	getCountryClient() {
		System.out.println("Default port " + port);
	}

	public getCountryClient(int port) {
		this.port = port;
		System.out.println("Custom port " + port);

	}

	public static void main(String[] args) {
		String response = new getCountryClient().getCountryDetails();
	}

	public String getCountryDetails() {
		// String url="http://services.groupkt.com/country/get/iso3code/IND";
		String url = String.format("http://localhost:%d/country/get/iso3code/USA", port);
		System.out.println("using the URL=" + url);
		try {
			HttpResponse r = Request.Get(url).addHeader("Accept", "application/json").execute().returnResponse();
			String json = EntityUtils.toString(r.getEntity());
			System.out.println("Json=" + json);
			// JSONObject jsonobj=new JSONObject(json);
			// //JSONArray result=jsonobj.getJSONArray("name");
			// String cName=jsonobj.getString("name").toString();
			// return cName;

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
