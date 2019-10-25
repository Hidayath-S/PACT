package com.provider.tests;

import java.net.MalformedURLException;
import java.net.URL;

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
@Provider("getUserDetails")
@PactFolder("../pacts")
//@VerificationReports(value = {"json"}, reportDir = "../pacts")
public class getUsetDetailsContractTest {
	public getUsetDetailsContractTest() throws MalformedURLException {
	}


	@TestTarget
	//public final Target target = new HttpTarget(url);
	public final Target target= new HttpTarget("https", "localhost", 8081, "");
	//public final Target target = new HttpTarget("http","services.groupkt.com");

	@State({"There is an user with userId 1001"})
	public void getPacts() {
		System.out.println("There is a country with alpha2_code as IN having name as India");
	}}

	
	
