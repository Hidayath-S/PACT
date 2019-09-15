package com.consumer.Pact.creation.tests;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactHttpsProviderRuleMk2;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.consumer.clients.MobileWsClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MobileWsClientTest {
	@Rule
	public PactHttpsProviderRuleMk2 provider= new PactHttpsProviderRuleMk2("UserService","localhost",8082,this); 
	
@Pact(consumer="UserServiceClient")
public RequestResponsePact createPact(PactDslWithProvider builder) {
	Map<String, String> headers=new HashMap();
	headers.put("Content-Type", "application/json");
	
	
	DslPart userDetails= new PactDslJsonBody()
			.stringType("firstName","Hidayath")
			.stringType("lastName","S")
			.stringType("email","hiddu91@gmail.com")
			.stringType("userId","1001")
			.stringType("message",null)
			.asBody();
	
	return builder
			.given("There is a user with userId 1001 having firstName as Hidayath")
            .uponReceiving("A request for userId 1001")
            .path("/users/1001")
            .method("GET")
            .willRespondWith()
            .status(200)
            .headers(headers)
            .body(userDetails).toPact();
	
}

@Test()
@PactVerification()
public void doTest() {
	System.setProperty("pact.rootDir","../pacts");
	String fName= new MobileWsClient(provider.getPort()).getUserDetails("1001");
	System.out.println("According to test fName="+fName);
	
	
}


}
