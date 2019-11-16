package com.provider.tests.demo;

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
@Provider("getCompanyDetailsByIDService")
@PactFolder("../pacts")
@VerificationReports(value = {"json"}, reportDir = "../pacts")
public class getCompanyDetailsByIDContractTest {
	public getCompanyDetailsByIDContractTest()  {
	}

	@TestTarget
	
	public final Target target= new HttpTarget("http", "localhost", 1234, "");

	@State({"There is a company with Id=49"})
	public void getPacts() {
		System.out.println("There is a country with Id=49 having Description as Seventy One Desc");
	}}

	
	
