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

import com.consumer.clients.users_POSTClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class user_POSTClientTest {
	@Rule
	public PactProviderRuleMk2 provider= new PactProviderRuleMk2("UserServiceP","localhost",8082,this); 
	
@Pact(consumer="UserServicePClient")
public RequestResponsePact createPact(PactDslWithProvider builder) {
	Map<String, String> headers=new HashMap();
	headers.put("Content-Type", "application/json");
	
	
	DslPart userDetails= new PactDslJsonBody()
			.integerType("id", 1)
			.stringType("first_name","George")
			.stringType("last_name","Bluth")
			.asBody();
	
	return builder
			.given("There is a user with userId 1001 having firstName as Hidayath")
            .uponReceiving("A request for userId 1001")
            .path("/api/users")
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
	//String fName= new MobileWsClient(provider.getPort()).getUserDetails("1001");
	String response= new users_POSTClient(provider.getPort()).getUserDetails();
	System.out.println("According to test fName="+response);
	
	
}


}
