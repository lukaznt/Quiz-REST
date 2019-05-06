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

import fr.epita.quiz.datamodel.Choice;
import fr.epita.quiz.services.dataaccess.ChoiceJPADAO;
import fr.epita.quiz.datamodel.Question;

@Path("/choices")
public class ChoiceResource {

	@Inject
	ChoiceJPADAO choiceDAO;
	
	
	@GET
	@Path("/{id}")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response findAllQuestions(@PathParam("id") int inputId) {
		Choice criteria = new Choice();
		//Question question = new Question();
		//question.setId(inputId);
		//criteria.setQuestion(question);
		criteria.setQId(inputId);
		List<Choice> searchResults = choiceDAO.search(criteria);
		
		return Response.ok(searchResults).build();
	}
	
	@POST
	@Path("/")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response createChoice(Choice choice) throws URISyntaxException {
		choiceDAO.create(choice);
		return Response.created(URI.create("choices/" + String.valueOf(choice.getId()))).build();
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response updateChoice(Choice choice) throws URISyntaxException {
		choiceDAO.update(choice);
		return Response.created(URI.create("choices/" + String.valueOf(choice.getId()))).build();
	}
	
	@DELETE
	@Path("/")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response deleteChoice(Choice choice) throws URISyntaxException {
		choiceDAO.delete(choice);
		return Response.status(javax.ws.rs.core.Response.Status.OK).build();
	}
	
	
}
