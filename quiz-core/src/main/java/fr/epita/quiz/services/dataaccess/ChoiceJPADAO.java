package fr.epita.quiz.services.dataaccess;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Choice;


@Repository
public class ChoiceJPADAO extends GenericDAO<Choice> {
 
	@Override
	public void prepareSearch(Choice criteria, QueryHolder<Choice> holder) {
		holder.setQueryString("from Choice as choice where choice.q_id = :q_id"); 
		holder.setClassName(Choice.class);
		holder.putParameter("q_id", criteria.getQId());
		
		//holder.setQueryString("from Choice as choice where choice.question = :question");
		//holder.setClassName(Choice.class);
		//holder.putParameter("question", criteria.getQuestion());
		
	}



}
