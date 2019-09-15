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

import com.consumer.clients.reqresPOST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class reqresPOSTClientTest {
	@Rule
	public PactProviderRuleMk2 provider= new PactProviderRuleMk2("reqresrServicePOST","localhost",1234,this); 
	
@Pact(consumer="reqresrServicePOSTClient")
public RequestResponsePact createPact(PactDslWithProvider builder) {
	Map<String, String> headers=new HashMap();
	headers.put("Content-Type", "application/json");
	
	DslPart requestDetails= new PactDslJsonBody()
			.stringType("name","morpheus")
			.stringType("job","leader")
			.asBody();
	
	
	DslPart responseDetails= new PactDslJsonBody()
			.stringType("name","morpheus")
			.stringType("job","leader")
			.stringType("id","251")
		//	.integerType("userId",1001)
			.stringType("createdAt","2019-01-15T12:58:04.614Z")
			.asBody();
	
	return builder
			.given("user wants to create a new user with name as morpheus")
            .uponReceiving("A request to create user with name as morpheus")
            .path("/api/users")
            .method("POST").
            body(requestDetails)
            .willRespondWith()
            .status(200)
            //.headers(headers)
            .body(responseDetails).toPact();
	
}

@Test()
@PactVerification()
public void doTest() {
	System.setProperty("pact.rootDir","../pacts");
	String userId= new reqresPOST(provider.getPort()).postUserDetails();
	System.out.println("According to test userId="+userId);
	
	
}


}
