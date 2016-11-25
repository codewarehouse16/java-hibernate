package com.edgar.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.edgar.model.SystemVO;

@Entity
@Table(name="TBL_DOOR")
public class DoorVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private int idDoor;
	
	private int code;
	
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private SystemVO system;
	
	public DoorVO() {
		
	}

	public int getIdDoor() {
		return idDoor;
	}

	public void setIdDoor(int idDoor) {
		this.idDoor = idDoor;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SystemVO getSystem() {
		return system;
	}

	public void setSystem(SystemVO system) {
		this.system = system;
	}
	
}
