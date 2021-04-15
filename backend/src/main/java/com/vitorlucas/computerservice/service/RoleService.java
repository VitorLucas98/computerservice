package com.vitorlucas.computerservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.computerservice.dto.RoleDTO;
import com.vitorlucas.computerservice.entities.Role;
import com.vitorlucas.computerservice.repositories.RoleRepository;
import com.vitorlucas.computerservice.service.exceptions.ResourceNotFoundException;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	@Transactional(readOnly = true)
	public List<RoleDTO> findAll() {
		List<Role> roles = repository.findAll();
		return roles.stream().map(x -> new RoleDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public RoleDTO findById(Long id) {
		Optional<Role> entity = repository.findById(id);
		 Role role = entity.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		 return new RoleDTO(role);
	}
	
	
}
