package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random; 
import java.util.ArrayList;

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
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.dataaccess.ChoiceJPADAO;
import fr.epita.quiz.services.dataaccess.QuestionJPADAO;

@Path("/questions")
public class QuestionResource {

	@Inject
	QuestionJPADAO questionDAO;
	ChoiceJPADAO choiceDAO;
	
	
	@GET
	@Path("/{id}")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response findQuestions(@PathParam("id") String inputString) {
		Question criteria = new Question();
		criteria.setContent(inputString);
		List<Question> searchResults = questionDAO.search(criteria);
		//List<Question> searchResults2 =  getRandomElement(searchResults, 2);
		return Response.ok(searchResults).build();
	}
	
	@GET
	@Path("/")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response findAllQuestions() {
		Question criteria = new Question();
		criteria.setContent("");
		List<Question> searchResults = questionDAO.search(criteria);
		//List<Question> searchResults2 =  getRandomElement(searchResults, 2);
		return Response.ok(searchResults).build();
	}
	

	
	@POST
	@Path("/")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response createQuestion(Question question) throws URISyntaxException {
		questionDAO.create(question);
		return Response.created(URI.create("questions/" + String.valueOf(question.getId()))).build();
		
	}
	
	@PUT
	@Path("/")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response updateQuestion(Question question) throws URISyntaxException {
		questionDAO.update(question);
		return Response.status(javax.ws.rs.core.Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response deleteQuestion(Question question) throws URISyntaxException {
		//Choice choice = new Choice();
		//choice.setQId(question.getId());
		//choiceDAO.delete(choice);
		questionDAO.delete(question);
		return Response.status(javax.ws.rs.core.Response.Status.OK).build();
	}
	
	
} 
	
	
	

