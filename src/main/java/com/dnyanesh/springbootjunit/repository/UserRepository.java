package com.dnyanesh.springbootjunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnyanesh.springbootjunit.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{

}
