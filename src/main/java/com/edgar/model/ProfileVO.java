package com.edgar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PROFILE")
public class ProfileVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idProfile;
	
	private String name;	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private SystemVO system;
	
	@ManyToMany
	@JoinTable(name="TBL_ACCESS_BY_PROFILE", joinColumns={@JoinColumn(name="idProfile")}, inverseJoinColumns={@JoinColumn(name="idDoor")})
	private List<DoorVO> access = new ArrayList<DoorVO>();
	
	public ProfileVO() {
		
	}

	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SystemVO getSystem() {
		return system;
	}

	public void setSystem(SystemVO system) {
		this.system = system;
	}

	public List<DoorVO> getAccesos() {
		return access;
	}

	public void setAccesos(List<DoorVO> doors) {
		this.access = doors;
	}
	
}
