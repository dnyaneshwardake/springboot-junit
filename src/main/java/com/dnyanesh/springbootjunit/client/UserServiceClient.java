package com.dnyanesh.springbootjunit.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dnyanesh.springbootjunit.model.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	public Boolean callExternalApi(Long id) {
		String url = "http://localhost:8080/hello";
		ResponseEntity<Object> response = null;
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>("abc", header);
		try {
			response = restTemplate.exchange(url, HttpMethod.PUT, entity, Object.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != response && null != response.getBody()) {
			log.info("callExternalApi Response: " + response.getBody());
		}
		return true;
	}

	public Boolean callExternalService(String data) {
		ResponseEntity<Object> response = null;
		String url = "http://localhost:8080/hi";
		Object body = new Object();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		try {
			response = restTemplate.getForEntity(url, Object.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != response && null != response.getBody()) {
			log.info("callExternalService Response: " + response.getBody());
		}
		return true;
	}

}
