package com.dnyanesh.springbootjunit.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceClientTest {

	@Mock
	private RestTemplate template;

	@InjectMocks
	private UserServiceClient userServiceClient;

	HttpHeaders header;
	HttpEntity<Object> entity;

	@Before
	public void setUp() {
		header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		entity = new HttpEntity<Object>("abc", header);
	}

	@Test
	public void callExternalApiTest() {
		String url = "http://localhost:8080/hello";
		Mockito.when(template.exchange(url, HttpMethod.PUT, entity, Object.class))
				.thenReturn(ResponseEntity.ok("success"));
		Boolean result = userServiceClient.callExternalApi(1L);
		Assert.assertTrue(result);
	}
	
	@Test
	public void callExternalApiFailureTest() {
		Boolean result = userServiceClient.callExternalApi(2L);
		Assert.assertTrue(result);
	}

}
