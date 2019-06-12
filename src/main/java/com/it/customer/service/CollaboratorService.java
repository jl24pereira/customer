package com.it.customer.service;

import java.util.List;

import com.ti.customer.entity.Collaborator;

public interface CollaboratorService {
	
	public Collaborator getCollaboratorById(Long id);
	
	public List<Collaborator> getAllCollaborators();

}
