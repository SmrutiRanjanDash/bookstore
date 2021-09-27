package dubai.digital.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

public class BookControllerTest {
	
	
	
	@Test
	public void testCheckout() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = "http://localhost:8080/book/checkout/1/test";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Double> result = restTemplate.getForEntity(uri, Double.class);
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody());
	}

}
