package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CHOICES")
public class Choice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column
	Integer q_id;
	
	@Column
	String text;
	
	@Column
	Boolean valid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQId() {
		return q_id;
	}

	public void setQId(Integer q_id) {
		this.q_id = q_id;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
}
