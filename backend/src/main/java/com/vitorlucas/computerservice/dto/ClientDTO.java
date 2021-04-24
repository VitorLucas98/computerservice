package com.vitorlucas.computerservice.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vitorlucas.computerservice.entities.Address;
import com.vitorlucas.computerservice.entities.Client;
import com.vitorlucas.computerservice.entities.OrderOfService;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpfCnpj;
	private String phone1;
	private String phone2;
	private List<AddressDTO> adresses = new ArrayList<>();
	private List<OrderOfServiceDTO> serviceOrders = new ArrayList<>();
	
	public ClientDTO(){
	}

	public ClientDTO(Long id, String name, String cpfCnpj, String phone1, String phone2) {
		this.id = id;
		this.name = name;
		this.cpfCnpj = cpfCnpj;
		this.phone1 = phone1;
		this.phone2 = phone2;
	}
	
	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpfCnpj = entity.getCpfCnpj();
		phone1 = entity.getPhone1();
		phone2 = entity.getPhone2();
	}
	
	public ClientDTO(Client entity, List<Address> adresses) {
		this(entity);
		adresses.forEach(x -> this.adresses.add(new AddressDTO(x)));
	}
	public ClientDTO(Client entity, List<Address> adresses, List<OrderOfService> serviceOrders) {
		this(entity);
		adresses.forEach(x -> this.adresses.add(new AddressDTO(x)));
		serviceOrders.forEach(x -> this.serviceOrders.add(new OrderOfServiceDTO(x)));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public List<AddressDTO> getAdresses() {
		return adresses;
	}
}
