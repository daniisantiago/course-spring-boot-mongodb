package com.dani.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dani.mongo.domain.User;
import com.dani.mongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired //vai instaciar o objeto automatico
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
