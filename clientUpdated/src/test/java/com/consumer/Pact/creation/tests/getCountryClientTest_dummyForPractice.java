package com.consumer.Pact.creation.tests;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.consumer.clients.getCountryClient;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;


public class getCountryClientTest_dummyForPractice {
	@Rule
	public PactProviderRuleMk2 provider= new PactProviderRuleMk2("getCountryService","localhost",1234,this);
	//public PactProviderRule provider = new PactProviderRule(provider, host, port, target);
	
@Pact(consumer="getCountryServiceClient")
public RequestResponsePact createPact(PactDslWithProvider builder) throws Exception {
	Object	obj = new JSONParser().parse(new FileReader("C:\\Users\\Hidayath\\Desktop\\json\\getCountryResponse.json"));
	JSONObject jo = (JSONObject) obj;
	String response=jo.toString();
	Map<String, String> headers=new HashMap();
	headers.put("Content-Type", "application/json");
	
	
	
	
	DslPart userDetails= new PactDslJsonBody()
			
			.object("RestResponse")
			.array("messages")
			.stringType("Total [249] records found.")
		    .closeArray()
		    .minArrayLike("result", 3, 4)
			.stringType("name","India")
			.stringType("alpha2_code","IN")
			.stringType("alpha3_code","IND")
			.closeArray()
			.closeObject()
			.asBody();	
	return builder
			.given("There is a country with alpha2_code as IN having name as India")
            .uponReceiving("A request for alpha2_code IN")
            .path("/country/get/iso3code/IND")
            
            .method("GET")
            .willRespondWith()
            .status(200)
            .headers(headers)
            .body(userDetails)
            .toPact();
	
}

@Test()
@PactVerification()
public void doTest() {
	System.setProperty("pact.rootDir","../pacts");
	String cName= new getCountryClient(provider.getPort()).getCountryDetails();
	System.out.println("According to test fName="+cName);
	
	
}


}
