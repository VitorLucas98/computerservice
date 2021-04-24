package com.vitorlucas.computerservice.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.computerservice.dto.OrderOfServiceDTO;
import com.vitorlucas.computerservice.entities.Client;
import com.vitorlucas.computerservice.entities.OrderOfService;
import com.vitorlucas.computerservice.entities.User;
import com.vitorlucas.computerservice.repositories.ClientRepository;
import com.vitorlucas.computerservice.repositories.OrderOfServiceRepository;
import com.vitorlucas.computerservice.repositories.UserRepository;
import com.vitorlucas.computerservice.service.exceptions.DatabaseException;
import com.vitorlucas.computerservice.service.exceptions.ResourceNotFoundException;

@Service
public class OrderOfServiceService {

	@Autowired
	private OrderOfServiceRepository repository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Page<OrderOfServiceDTO> findAllPaged(PageRequest pageRequest){
		Page<OrderOfService> list = repository.findAll(pageRequest);
		return list.map(x -> new OrderOfServiceDTO(x));
	}
	@Transactional(readOnly = true)
	public OrderOfServiceDTO findById(Long id) {
		Optional<OrderOfService> entity = repository.findById(id);
		OrderOfService orderOfService = entity.orElseThrow(() -> new ResourceNotFoundException("id not Found"));
		return new OrderOfServiceDTO(orderOfService);
	}
	
	@Transactional
	public OrderOfServiceDTO insert(OrderOfServiceDTO dto) {
		OrderOfService entity = new OrderOfService();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new OrderOfServiceDTO(entity);
	}
	
	@Transactional
	public OrderOfServiceDTO update(OrderOfServiceDTO dto, Long id) {
		try {
			OrderOfService entity = repository.getOne(id);
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new OrderOfServiceDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found");
		}

	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	} 
	
	private void copyDtoToEntity(OrderOfService entity, OrderOfServiceDTO dto) {
		entity.setOpeningDate(dto.getOpeningDate());
		entity.setClosingDate(dto.getClosingDate());
		entity.setNote(dto.getNote());
		entity.setEquipment(dto.getEquipment());
		entity.setDefect(dto.getDefect());
		entity.setSerialNumber(dto.getSerialNumber());
		entity.setStatus(dto.getStatus());
		
		User user = userRepository.getOne(dto.getEmployeeId());
		entity.setEmployee(user);
		Client client = clientRepository.getOne(dto.getClientId());
		entity.setClient(client);
	}
}
