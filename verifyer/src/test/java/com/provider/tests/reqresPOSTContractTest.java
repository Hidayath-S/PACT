package com.provider.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.runner.RunWith;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@Provider("reqresrServicePOST")
@PactFolder("../pacts")
public class reqresPOSTContractTest {
	public reqresPOSTContractTest() throws MalformedURLException {
	}

	private URL url = new URL("http://services.groupkt.com/country/get/iso3code/IND");
	int port;// open API

	@TestTarget
	//public final Target target = new HttpTarget(url);
	public final Target target= new HttpTarget("http", "reqres.in", 80, "");
	//public final Target target = new HttpTarget("http","services.groupkt.com");

	@State({"user wants to create a new user with name as morpheus"})
	public void getPacts() {
		System.out.println("user wants to create a new user with name as morpheus");
	}}

	
	
