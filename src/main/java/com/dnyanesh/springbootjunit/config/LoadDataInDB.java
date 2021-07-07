package com.dnyanesh.springbootjunit.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dnyanesh.springbootjunit.model.UserInfo;
import com.dnyanesh.springbootjunit.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDataInDB {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void loadData() {
		UserInfo user = new UserInfo(1L, "Dnyanesh", "Dake", "a@b.com");

		log.info("DB Loaded with UserInfo:: " +user);
		userRepository.save(user);
	}
}
