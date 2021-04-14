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
import com.vitorlucas.computerservice.service.exceptions.EntityNotFoundException;

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
		User user = entity.orElseThrow(() ->new EntityNotFoundException("Entity not found"));
		return new UserDTO(user);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User user = new User(null, dto.getName(), dto.getEmail(), dto.getPassword());
		user.getRoles().addAll(dto.getRoles());
		user = repository.save(user);
		return new UserDTO(user);
	}
}
