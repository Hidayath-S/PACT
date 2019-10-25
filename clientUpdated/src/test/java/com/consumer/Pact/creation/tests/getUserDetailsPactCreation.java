package com.consumer.Pact.creation.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import com.consumer.clients.getUserDetailsClient;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class getUserDetailsPactCreation {
	
	@Rule
	public PactProviderRuleMk2 provider=new PactProviderRuleMk2("getUserDetails", "localhost",1234,this);
	
	
	@Pact(consumer="getUserDetailsProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		Map<String, String> headersReq=new HashMap();
		headersReq.put("Accept", "application/json");
		Map<String, String> headersRes=new HashMap();
		headersRes.put("Content-Type", "application/json");
		
		DslPart userDetailsResponse=new PactDslJsonBody()
				.stringType("firstName", "Hidayath")
				.stringType("lastName", "S")
				.stringType("email", "hiddu91@gmail.com")
				.stringType("userId", "1001")
				//.stringType("message", null)
				.asBody();
		
		return builder
				.given("There is an user with userId 1001")
				.uponReceiving("A request to get user details")
				.path("/users/1001")
				.headers(headersReq)
				.method("GET")
				.willRespondWith()
				.status(200)
				.headers(headersRes)
				.body(userDetailsResponse).toPact();
	}
	
	@Test()
	@PactVerification()
	public void createPact(){
		System.setProperty("pact.rooDir", "../pacts");
		String userDetails=new getUserDetailsClient(provider.getPort()).getUserDetails();
		System.out.println("According to mock service userName="+userDetails);
		
	}
	

}
