package com.edgar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.edgar.model.DoorVO;

@Entity
@Table(name="TBL_SYSTEM")
public class SystemVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idSystem;
	
	private String name;
	
	//@OneToMany(fetch = FetchType.EAGER)
	//@OneToMany
	//@JoinTable(name="TBL_DOORS_BY_SYSTEM", joinColumns=@JoinColumn(name="idSystem"), inverseJoinColumns=@JoinColumn(name="idDoor"))
	//private List<DoorVO> doors = new ArrayList<DoorVO>();
	
	public SystemVO() {
		
	}

	public int getIdSystem() {
		return idSystem;
	}

	public void setIdSystem(int idSystem) {
		this.idSystem = idSystem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public List<DoorVO> getDoors() {
		return doors;
	}

	public void setDoors(List<DoorVO> doors) {
		this.doors = doors;
	}*/	
	
}
