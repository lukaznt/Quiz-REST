package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.quiz.datamodel.Participant;
import fr.epita.quiz.services.dataaccess.ParticipantJPADAO;

@Path("/participants")
public class ParticipantResource {

	@Inject
	ParticipantJPADAO participantDAO;
	
	
	@GET
	@Path("/{id}")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response findParticipant(@PathParam("id") int inputId) {
		Participant criteria = new Participant();
		criteria.setId(inputId);
		List<Participant> searchResults = participantDAO.search(criteria);
		return Response.ok(searchResults).build();
	}
	
	@POST
	@Path("/")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response createParticipant(Participant participant) throws URISyntaxException {
		participantDAO.create(participant);
		return Response.created(URI.create("participants/" + String.valueOf(participant.getId()))).build();
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response updateParticipant(Participant participant) throws URISyntaxException {
		participantDAO.update(participant);
		return Response.created(URI.create("participants/" + String.valueOf(participant.getId()))).build();
	}
	
	@DELETE
	@Path("/")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response deleteParticipant(Participant participant) throws URISyntaxException {
		participantDAO.delete(participant);
		return Response.status(javax.ws.rs.core.Response.Status.OK).build();
	}
	
	
}
