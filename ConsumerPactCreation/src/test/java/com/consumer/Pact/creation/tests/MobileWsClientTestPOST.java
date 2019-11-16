package com.consumer.Pact.creation.tests;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.consumer.clients.MobileWsClientPOST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MobileWsClientTestPOST {
	@Rule
	public PactProviderRuleMk2 provider= new PactProviderRuleMk2("UserServicePOST","localhost",1234,this); 
	
@Pact(consumer="UserServicePOSTClient")
public RequestResponsePact createPact(PactDslWithProvider builder) {
	Map<String, String> headers=new HashMap();
	headers.put("Content-Type", "application/json");
	
	DslPart requestDetails= new PactDslJsonBody()
			.stringType("firstName","Hidayath")
			.stringType("lastName","S")
			.stringType("email","hiddu91@gmail.com")
			.asBody();
	
	
	DslPart userDetails= new PactDslJsonBody()
			.stringType("firstName","Hidayath")
			.stringType("lastName","S")
			.stringType("email","hiddu91@gmail.com")
		//	.integerType("userId",1001)
			.stringType("userId","1001")
			.stringType("message","User Created successfully")
			.asBody();
	
	return builder
			.given("user wants to create a new user with firstName as Hidayath")
            .uponReceiving("A request to create user with firstName as Hidayath")
            .path("/users")
            .method("POST").
            body(requestDetails)
            .willRespondWith()
            .status(200)
            //.headers(headers)
            .body(userDetails).toPact();
	
}

@Test()
@PactVerification()
public void doTest() {
	System.setProperty("pact.rootDir","../pacts");
	String userId= new MobileWsClientPOST(provider.getPort()).postUserDetails();
	System.out.println("According to test userId="+userId);
	
	
}


}
