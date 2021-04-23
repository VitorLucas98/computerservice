package com.vitorlucas.computerservice.dto;

import java.io.Serializable;

import com.vitorlucas.computerservice.entities.Address;

public class AddressDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String city;
	private String district;
	private Integer number;
	private String cep;
	private String complement;
	private Long clientId;
	
	public AddressDTO() {
	}

	public AddressDTO(Long id, String city, String district, Integer number, String cep, String complement,
			Long clientId) {
		this.id = id;
		this.city = city;
		this.district = district;
		this.number = number;
		this.cep = cep;
		this.complement = complement;
		this.clientId = clientId;
	}
	
	public AddressDTO(Address entity) {
		id = entity.getId();
		city = entity.getCity();
		district = entity.getDistrict();
		number = entity.getNumber();
		cep = entity.getCep();
		complement = entity.getComplement();
		clientId = entity.getClient().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}	
}
