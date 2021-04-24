package com.vitorlucas.computerservice.dto;

import java.io.Serializable;
import java.time.Instant;

import com.vitorlucas.computerservice.entities.OrderOfService;
import com.vitorlucas.computerservice.enums.StatusService;

public class OrderOfServiceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant openingDate;
	private Instant closingDate;
	private String note;
	private String equipment;
	private String defect;
	private String serialNumber;
	private StatusService status;
	private Long clientId;
	private Long employeeId;
	
	public OrderOfServiceDTO() {
	}

	public OrderOfServiceDTO(Long id, Instant openingDate, Instant closingDate, String note, String equipment,
			String defect, String serialNumber, StatusService status, Long clientId, Long employeeId) {
		super();
		this.id = id;
		this.openingDate = openingDate;
		this.closingDate = closingDate;
		this.note = note;
		this.equipment = equipment;
		this.defect = defect;
		this.serialNumber = serialNumber;
		this.status = status;
		this.clientId = clientId;
		this.employeeId = employeeId;
	}
	
	public OrderOfServiceDTO(OrderOfService entity) {
		id = entity.getId();
		openingDate = entity.getOpeningDate();
		closingDate = entity.getClosingDate();
		note = entity.getNote();
		equipment = entity.getEquipment();
		defect = entity.getDefect();
		serialNumber = entity.getSerialNumber();
		status = entity.getStatus();
		clientId = entity.getClient().getId();
		employeeId = entity.getEmployee().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Instant openingDate) {
		this.openingDate = openingDate;
	}

	public Instant getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Instant closingDate) {
		this.closingDate = closingDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getDefect() {
		return defect;
	}

	public void setDefect(String defect) {
		this.defect = defect;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public StatusService getStatus() {
		return status;
	}

	public void setStatus(StatusService status) {
		this.status = status;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
}
