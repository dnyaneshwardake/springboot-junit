package com.dnyanesh.springbootjunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnyanesh.springbootjunit.client.UserServiceClient;
import com.dnyanesh.springbootjunit.model.UserInfo;
import com.dnyanesh.springbootjunit.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceClient userServiceClient;

	public UserInfo addUser(UserInfo userInfo) {
		return userRepository.save(userInfo);
	}

	public Boolean getUserInfo(Long id) {
		// TODO Auto-generated method stub
		return userServiceClient.callExternalApi(id);
	}

}
