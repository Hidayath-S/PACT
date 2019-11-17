package com.consumer.Pact.creation.tests.demo;

import au.com.dius.pact.consumer.Pact;
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
import com.consumer.clients.demo.getCompanyDetailsClient;

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

public class getCompanyDetailsPactTest {
	@Rule
	public PactProviderRuleMk2 provider = new PactProviderRuleMk2("getCompanyDetailsService", "localhost", 1233, this);

	@Pact(consumer = "getCompanyDetailsServiceClient")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws Exception {
		Map<String, String> headers = new HashMap();
		headers.put("Content-Type", "application/json");

		DslPart companyDetails = new PactDslJsonBody()
				
				.minArrayLike("CompanyDetails",7,48)
				.integerType("Id", 1)
				.stringValue("Name", "Infosys")
				.stringValue("Description", "Infosys limited")
				.integerType("CreatedBy", 1)
				.stringValue("CreatedDate", "2019-10-22T06:19:52.493")
				.stringValue("UpdatedDate", "2019-10-22T06:19:52.493")
				.integerType("Status", 0)
				.asBody();
				
				

		return builder
				.given("There are companies with different companyId's")
				.uponReceiving("A request for companyDetails ALL")
				.path("/company/ALL")
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
		String cName = new getCompanyDetailsClient(provider.getPort()).getCompanyDetails();
		System.out.println("According to test fName=" + cName);

	}

}
