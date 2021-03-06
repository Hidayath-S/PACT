package com.provider.tests;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("UserService") // Set up name of tested provider
@PactFolder("../pacts") // Point where to find pacts

public class MobileWsContactTest {
	@State("There is a user with userId 1001 having firstName as Hidayath") // Method will be run before testing interactions that require "with-data" state
    public void hammerSmith() {
        System.out.println("There is a user with userId 1001 having firstName as Hidayath" );
    }


    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(8081); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)

}
