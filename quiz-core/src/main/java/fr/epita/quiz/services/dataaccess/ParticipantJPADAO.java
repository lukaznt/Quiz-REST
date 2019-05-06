package fr.epita.quiz.services.dataaccess;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Participant;


@Repository
public class ParticipantJPADAO extends GenericDAO<Participant>{
	
	@Override
	public void prepareSearch(Participant criteria, QueryHolder<Participant> holder) {
		holder.setQueryString("from Participant as p where p.id = :id"); 
		holder.setClassName(Participant.class);
		holder.putParameter("id", criteria.getId());
	}


}