package com.consumer.Pact.creation.tests.demo;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

import org.junit.Rule;
import org.junit.Test;


import com.consumer.clients.demo.getCompanyDetailsByIDClient;
import java.util.HashMap;
import java.util.Map;



public class getCompanyDetailsByIDPactTest {
	@Rule
	public PactProviderRuleMk2 provider = new PactProviderRuleMk2("getCompanyDetailsByIDService", "localhost", 1233, this);

	@Pact(consumer = "getCompanyDetailsByIDServiceClient")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws Exception {
		Map<String, String> headers = new HashMap();
		headers.put("Content-Type", "application/json");
		

		DslPart companyDetails = new PactDslJsonBody()
				.integerType("Id", 49)
				.stringValue("Name", "Seventy One")
				.stringValue("Description", "Seventy One Desc")
				.integerType("CreatedBy", 0)
				.stringValue("CreatedDate", "2019-10-22T06:19:52.493")
				.stringValue("UpdatedDate", "2019-10-22T06:19:52.493")
				.integerType("Status", 0)
				.asBody();
				
				

		return builder
				.given("There is a company with Id=49")
				.uponReceiving("A request for companyDetails with Id=49")
				.path("/company/49")
				.method("GET")
				.willRespondWith().
				status(200).
				headers(headers).
				body(companyDetails).toPact();

	}

	@Test()
	@PactVerification()
	public void doTest() {
		System.setProperty("pact.rootDir", "../pacts");
		String cName = new getCompanyDetailsByIDClient(provider.getPort()).getCompanyDetails();
		System.out.println("According to test fName=" + cName);

	}

}
