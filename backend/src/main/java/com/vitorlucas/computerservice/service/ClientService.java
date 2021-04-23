package com.vitorlucas.computerservice.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.computerservice.dto.ClientDTO;
import com.vitorlucas.computerservice.entities.Client;
import com.vitorlucas.computerservice.repositories.ClientRepository;
import com.vitorlucas.computerservice.service.exceptions.DatabaseException;
import com.vitorlucas.computerservice.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;


	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest request) {
		Page<Client> list = repository.findAll(request);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> entity = repository.findById(id);
		Client client = entity.orElseThrow(() -> new ResourceNotFoundException("id not found"));
		return new ClientDTO(client, client.getAdresses());
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyEntityToDto(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(ClientDTO dto, Long id) {
		try {
			Client entity = repository.getOne(id);
			copyEntityToDto(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found");
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not Found");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Referential Integrity error");
		}
	}

	private void copyEntityToDto(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpfCnpj(dto.getCpfCnpj());
		entity.setPhone1(dto.getPhone1());
		entity.setPhone2(dto.getPhone2());
	}

}
