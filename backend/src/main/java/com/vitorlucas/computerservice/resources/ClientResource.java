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

import com.vitorlucas.computerservice.dto.ClientDTO;
import com.vitorlucas.computerservice.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAllPaged(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "12") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		Page<ClientDTO> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		ClientDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
		ClientDTO client = service.update(dto, id);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
