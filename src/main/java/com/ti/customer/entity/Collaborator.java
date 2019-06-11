package com.ti.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "collaborator", schema = "developer")
public class Collaborator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5075427069535168395L;

	@Id
	@Column(name = "collab_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@SequenceGenerator(name = "sequence",sequenceName = "colla_seq")
	private Long collabId;
	
	@Column(name = "collab_name")
	private String collabName;
	
	@Column(name = "collab_alias")
	private String collabAlias;
	
	@Column(name = "collab_password")
	private String collabPassword;
	
	@Column(name = "collab_dni")
	private String collabDni;
	
	@Column(name = "collab_email")
	private String collabEmail;
	
	@Column(name = "collab_image")
	private byte[] collabImage;

	public Long getCollabId() {
		return collabId;
	}

	public void setCollabId(Long collabId) {
		this.collabId = collabId;
	}

	public String getCollabName() {
		return collabName;
	}

	public void setCollabName(String collabName) {
		this.collabName = collabName;
	}

	public String getCollabAlias() {
		return collabAlias;
	}

	public void setCollabAlias(String collabAlias) {
		this.collabAlias = collabAlias;
	}

	public String getCollabPassword() {
		return collabPassword;
	}

	public void setCollabPassword(String collabPassword) {
		this.collabPassword = collabPassword;
	}

	public String getCollabDni() {
		return collabDni;
	}

	public void setCollabDni(String collabDni) {
		this.collabDni = collabDni;
	}

	public String getCollabEmail() {
		return collabEmail;
	}

	public void setCollabEmail(String collabEmail) {
		this.collabEmail = collabEmail;
	}

	public byte[] getCollabImage() {
		return collabImage;
	}

	public void setCollabImage(byte[] collabImage) {
		this.collabImage = collabImage;
	}
	
}
