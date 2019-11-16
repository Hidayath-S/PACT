package com.provider.tests.demo;



import org.junit.runner.RunWith;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@Provider("getCompanyDetailsService")
@PactFolder("../pacts")
@VerificationReports(value = {"json"}, reportDir = "../pacts")
public class getCompanyDetailsContractTest {
	public getCompanyDetailsContractTest()  {
	}

	@TestTarget
	
	public final Target target= new HttpTarget("http", "localhost", 1234, "");

	@State({"There are companies with different companyId's"})
	public void getPacts() {
		System.out.println("Displaying all complany details");
	}}

	
	
