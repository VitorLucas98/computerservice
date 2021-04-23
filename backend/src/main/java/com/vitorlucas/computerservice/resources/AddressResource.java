package com.vitorlucas.computerservice.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitorlucas.computerservice.dto.AddressDTO;
import com.vitorlucas.computerservice.service.AddressService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
	@GetMapping
	public ResponseEntity<Page<AddressDTO>> findAllPaged(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "city") String ordeBy){
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), ordeBy);
		Page<AddressDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> findById(@PathVariable Long id){
		AddressDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<AddressDTO> insert(@RequestBody AddressDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> updade(@RequestBody AddressDTO dto, @PathVariable Long id){
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
