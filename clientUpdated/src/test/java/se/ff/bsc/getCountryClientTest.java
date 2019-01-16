package se.ff.bsc;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class getCountryClientTest {
	@Rule
	public PactProviderRuleMk2 provider= new PactProviderRuleMk2("getCountryService","localhost",1234,this); 
	
@Pact(consumer="getCountryServiceClient")
public RequestResponsePact createPact(PactDslWithProvider builder) {
	Map<String, String> headers=new HashMap();
	headers.put("Content-Type", "application/json");
	
	
	DslPart userDetails= new PactDslJsonBody()
			
			
			.stringType("name","India")
			.stringType("alpha2_code","IN")
			.stringType("alpha3_code","IND")
			.asBody();
	
	return builder
			.given("There is a country with alpha2_code as IN having name as India")
            .uponReceiving("A request for alpha2_code IN")
            .path("/country/get/iso2code/IN")
            .method("GET")
            .willRespondWith()
            .status(200)
            .headers(headers)
            .body("{\r\n" + 
            		"  \"RestResponse\" : {\r\n" + 
            		"    \"messages\" : [ \"Country found matching code [IND].\" ],\r\n" + 
            		"    \"result\" : {\r\n" + 
            		"      \"name\" : \"India\",\r\n" + 
            		"      \"alpha2_code\" : \"IN\",\r\n" + 
            		"      \"alpha3_code\" : \"IND\"\r\n" + 
            		"    }\r\n" + 
            		"  }\r\n" + 
            		"}")
            .toPact();
	
}

@Test()
@PactVerification()
public void doTest() {
	System.setProperty("pact.rootDir","../pacts");
	String cName= new getCountryClient(provider.getPort()).getCountryDetails();
	System.out.println("According to test fName="+cName);
	
	
}


}
