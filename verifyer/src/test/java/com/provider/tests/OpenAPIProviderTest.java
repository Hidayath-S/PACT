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
@Provider("getCountryService")
@PactFolder("../pacts")
//@VerificationReports(value = {"json"}, reportDir = "../pacts")
public class OpenAPIProviderTest {
	public OpenAPIProviderTest() throws MalformedURLException {
	}

	private URL url = new URL("http://services.groupkt.com/country/get/iso3code/IND");
	int port;// open API

	@TestTarget
	//public final Target target = new HttpTarget(url);
	public final Target target= new HttpTarget("http", "services.groupkt.com", 80, "");
	//public final Target target = new HttpTarget("http","services.groupkt.com");

	@State({"There is a country with alpha2_code as IN having name as India"})
	public void getPacts() {
		System.out.println("There is a country with alpha2_code as IN having name as India");
	}}

	
	
