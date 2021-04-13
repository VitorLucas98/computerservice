package com.vitorlucas.computerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.computerservice.entities.User;
import com.vitorlucas.computerservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; 
	
	@Transactional
	public List<User> findAll(){
		List<User> list = repository.findAll();
	return list;
	}
}
