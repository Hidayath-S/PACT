package com.consumer.Pact.creation.tests.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import com.consumer.clients.MobileWsClientPOST;
import com.consumer.clients.readJsontoString;
import com.consumer.clients.demo.postCompanyDetails;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslRequestWithPath;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class postCompanyDetailsPactTest {
	
	@Rule
	public PactProviderRuleMk2 provider=new PactProviderRuleMk2("postCompanyDetails", "localhost", 1233,this);
	
	@Pact(consumer="postCompanyDetailsClient")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws IOException{
		Map<String, String> headers=new HashMap();
		headers.put("Content-Type", "application/json");
		
		
//		DslPart requestDetails=new PactDslJsonBody()
//				.integerType("Id", 0)
//				.stringValue("Name", "Seventy One")
//				.stringValue("Description", "Seventy One Desc")
//				.integerType("CreatedBy", 0)
//				.stringValue("CreatedDate", "2019-10-22T06:19:52.493Z")
//				.stringValue("UpdatedDate", "2019-10-22T06:19:52.493Z")
//				.integerType("Status", 0)
//				.asBody();
		
		DslPart responseDetails=new PactDslJsonBody()
				.integerType("Id", 49)
				.stringValue("Name", "Seventy One")
				.stringValue("Description", "Seventy One Desc")
				.integerType("CreatedBy", 0)
				.stringValue("CreatedDate", "2019-10-22T06:19:52.493Z")
				.stringValue("UpdatedDate", "2019-10-22T06:19:52.493Z")
				.integerType("Status", 0)
				.asBody();
		
		return builder
				.given("user wants to create new company details with name as Seventy One" )
				.uponReceiving("a request to create new company details")
				.path("/company")
				.method("POST")
				.headers(headers)
				.body(new readJsontoString().readFile("C:\\Users\\Hidayath\\Desktop\\Pact_Request\\postCompanyDetails.txt"))
				.willRespondWith()
				.status(200)
				.headers(headers)
				.body(responseDetails)
				.toPact();
		
	}
	
	@Test()
	@PactVerification()
	public void doTest() throws IOException {
		System.setProperty("pact.rootDir","../pacts");
		String Id= new postCompanyDetails(provider.getPort()).addCompanyDetails();
		System.out.println("According to test Id="+Id);
		
		
	}



}
