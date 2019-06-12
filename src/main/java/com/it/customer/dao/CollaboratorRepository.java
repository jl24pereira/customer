package com.it.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ti.customer.entity.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
	
	@Query("select c from Collaborator c where c.collabId = :id")
	public Collaborator getCollaborator(@Param("id") Long id);
	
	@Query("select c from Collaborator c")
	public List<Collaborator> getListAllCollaborators();

}
