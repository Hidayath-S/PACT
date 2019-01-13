package se.ff.bsv;

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
@Provider("getCountryService")
@PactFolder("../pacts")
public class OpenAPIProviderTest {
	public OpenAPIProviderTest() throws MalformedURLException {
	}

	private URL url = new URL("https://services.groupkt.com/country/get/iso3code/IND"); // open API

	@TestTarget
	public final Target target = new HttpTarget(url);

	@State({"There is a country with alpha2_code as IN having name as India"})
	public void getPacts() {
		System.out.println("There is a country with alpha2_code as IN having name as India");
	}}

	
	
