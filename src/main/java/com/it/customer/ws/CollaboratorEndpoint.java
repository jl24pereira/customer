package com.it.customer.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.it.customer.service.CollaboratorServiceImpl;
import com.ti.customer.entity.Collaborator;
import com.ti.customer.schema.CollaboratorDetails;
import com.ti.customer.schema.CollaboratorRequest;
import com.ti.customer.schema.CollaboratorResponse;
import com.ti.customer.schema.ObjectFactory;

@Endpoint
public class CollaboratorEndpoint<collaboratorResponse> {

	private static final String NAMESPACE_URI = "http://www.example.org/Collaborator";
	
	@Autowired
	CollaboratorServiceImpl collaboratorServiceImpl;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "collaboratorRequest")
	@ResponsePayload
	public JAXBElement<CollaboratorResponse> getCollaborator(@RequestPayload JAXBElement<CollaboratorRequest> request){
		ObjectFactory objectFactory = new ObjectFactory();
		CollaboratorResponse collaboratorResponseFactory = objectFactory.createCollaboratorResponse();
		JAXBElement<CollaboratorResponse> collaboratorResponse = objectFactory.createCollaboratorResponse(collaboratorResponseFactory);
		try {
			int action = request.getValue().getAction();
			if (action == 1) {
				CollaboratorResponse collaboratorResponseObject = new CollaboratorResponse();
				List<Collaborator> listColaborator = collaboratorServiceImpl.getAllCollaborators();
				if(listColaborator!=null) {
					for(Collaborator collab:listColaborator) {
						CollaboratorDetails collaboratorDetails = new CollaboratorDetails();
						collaboratorDetails.setId(collab.getCollabId().intValue());
						collaboratorDetails.setName(collab.getCollabName());
						collaboratorDetails.setPassword(collab.getCollabPassword());
						collaboratorDetails.setAlias(collab.getCollabAlias());
						collaboratorDetails.setDni(collab.getCollabDni());
						collaboratorDetails.setEmail(collab.getCollabEmail());
						collaboratorDetails.setImageCollaborator(collab.getCollabImage());
						collaboratorResponseObject.getCollaboratorDetails().add(collaboratorDetails);
					}
				}
				collaboratorResponse.setValue(collaboratorResponseObject);
			} else if(action ==2){
				CollaboratorResponse collaboratorResponseObject = new CollaboratorResponse();
				Collaborator collab = collaboratorServiceImpl.getCollaboratorById(new Long(request.getValue().getId()));
				CollaboratorDetails collaboratorDetails = new CollaboratorDetails();
				if(collab!=null) {
					collaboratorDetails.setId(collab.getCollabId().intValue());
					collaboratorDetails.setName(collab.getCollabName());
					collaboratorDetails.setPassword(collab.getCollabPassword());
					collaboratorDetails.setAlias(collab.getCollabAlias());
					collaboratorDetails.setDni(collab.getCollabDni());
					collaboratorDetails.setEmail(collab.getCollabEmail());
					collaboratorDetails.setImageCollaborator(collab.getCollabImage());
					collaboratorResponseObject.getCollaboratorDetails().add(collaboratorDetails);
					collaboratorResponse.setValue(collaboratorResponseObject);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return collaboratorResponse;
	}
	
}
