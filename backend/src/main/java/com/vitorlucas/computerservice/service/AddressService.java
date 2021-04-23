package com.vitorlucas.computerservice.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.computerservice.dto.AddressDTO;
import com.vitorlucas.computerservice.entities.Address;
import com.vitorlucas.computerservice.entities.Client;
import com.vitorlucas.computerservice.repositories.AddressRepository;
import com.vitorlucas.computerservice.repositories.ClientRepository;
import com.vitorlucas.computerservice.service.exceptions.DatabaseException;
import com.vitorlucas.computerservice.service.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private ClientRepository clientRepository; 
	
	@Transactional(readOnly = true)
	public Page<AddressDTO> findAllPaged(PageRequest pageRequest){
		Page<Address> list = repository.findAll(pageRequest);
		return list.map(x -> new AddressDTO(x));
	}
	
	@Transactional(readOnly = true)
	public AddressDTO findById(Long id) {
		Optional<Address> entity = repository.findById(id);
		Address address= entity.orElseThrow(() -> new ResourceNotFoundException("id not Found")); 
		return new AddressDTO(address);
	}
	
	@Transactional
	public AddressDTO insert(AddressDTO dto) {
		Address entity = new Address();
		copyDtotoEntity(entity, dto);
		entity = repository.save(entity);
		return new AddressDTO(entity);
	}
	
	@Transactional
	public AddressDTO update(Long id, AddressDTO dto){
		try {
		Address entity = repository.getOne(id);
		copyDtotoEntity(entity, dto);
		entity = repository.save(entity);
		return new AddressDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("id not found");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtotoEntity(Address entity, AddressDTO dto) {
		entity.setCep(dto.getCep());
		entity.setCity(dto.getCity());
		entity.setComplement(dto.getComplement());
		entity.setNumber(dto.getNumber());
		entity.setDistrict(dto.getDistrict());
		Client client = clientRepository.getOne(dto.getClientId());
		entity.setClient(client);
	}
	
}
