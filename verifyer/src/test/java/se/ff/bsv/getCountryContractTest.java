package se.ff.bsv;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.loader.PactUrl;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import java.net.URL;
import java.util.Map;

@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("getCountryService") // Set up name of tested provider
@PactFolder("../pacts") // Point where to find pacts (See also section Pacts source in documentation)

//@PactUrl(urls = {"http://services.groupkt.com/country/get/iso3code/IND"} )

public class getCountryContractTest {

	@State("There is a country with alpha2_code as IN having name as India") // Method will be run before testing
																				// interactions that require "with-data"
																				// state
	public void hammerSmith() {
		System.out.println("There is a country with alpha2_code as IN having name as India");
	}

	@TestTarget // Annotation denotes Target that will be used for tests
    
    public final Target target = new HttpTarget(1234);// Out-of-the-box implementation of Target (for more information take a look at Test Target section)
    //public final Target target = new HttpTarget("http", "services.groupkt.com",);

}
