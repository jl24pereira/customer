package com.it.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.customer.dao.CollaboratorRepository;
import com.ti.customer.entity.Collaborator;

@Service("collaboratorService")
@Transactional
public class CollaboratorServiceImpl implements CollaboratorService {
	
	private static final Logger logger = LogManager.getLogger(CollaboratorServiceImpl.class);
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Override
	public Collaborator getCollaboratorById(Long id) {
		// TODO Auto-generated method stub
		return collaboratorRepository.getCollaborator(id);
	}

	@Override
	public List<Collaborator> getAllCollaborators() {
		// TODO Auto-generated method stub
		logger.info("TAMAÑO DE LA LISTA DE COLABORADORES EN CAPA SERVICE ES: "+collaboratorRepository.getListAllCollaborators().size());
		return collaboratorRepository.getListAllCollaborators();
	}

}
