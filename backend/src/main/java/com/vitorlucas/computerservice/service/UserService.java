package com.vitorlucas.computerservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.computerservice.dto.UserDTO;
import com.vitorlucas.computerservice.entities.User;
import com.vitorlucas.computerservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; 
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list =repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id){
		Optional<User> entity = repository.findById(id);
		return new UserDTO(entity.get());
	}
}
