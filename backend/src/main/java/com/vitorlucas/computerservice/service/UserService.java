package com.vitorlucas.computerservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.computerservice.dto.UserDTO;
import com.vitorlucas.computerservice.entities.User;
import com.vitorlucas.computerservice.repositories.UserRepository;
import com.vitorlucas.computerservice.service.exceptions.DatabaseException;
import com.vitorlucas.computerservice.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> entity = repository.findById(id);
		User user = entity.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(user);
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User user = new User(null, dto.getName(), dto.getEmail(), dto.getPassword());
		user.getRoles().addAll(dto.getRoles());
		user = repository.save(user);
		return new UserDTO(user);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setPassword(dto.getPassword());
			entity = repository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found" + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found");
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
