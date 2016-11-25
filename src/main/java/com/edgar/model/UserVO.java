package com.edgar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USER")
public class UserVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private int idUser;
	
	private String username;
	
	private String password;
	
	private String nombres;
	
	private String apellidos;
	
	private Date creationDate;
	
	@ManyToMany
	@JoinTable(name="TBL_PROFILE_BY_USER", joinColumns={@JoinColumn(name="idUser")}, inverseJoinColumns={@JoinColumn(name="idProfile")})
	private List<ProfileVO> profiles = new ArrayList<ProfileVO>();
	
	public UserVO() {
		
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<ProfileVO> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ProfileVO> profiles) {
		this.profiles = profiles;
	}	
	
}
