package br.com.testsoc.domain;

import java.util.Date;
//import com.mysql.*;
//import javax.persistence.*;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@SuppressWarnings("serial")
@Entity
public class DadosPaciente extends GenericDomain {
    @Column(length =50 ,nullable=false)
	private String name;
    @Column
	private String name_exam;
    @Column(nullable=false)
	private String result;
    @Column(nullable=false)
	private String observation;
	@Temporal(TemporalType.DATE)
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_exam() {
		return name_exam;
	}

	public void setName_exam(String name_exam) {
		this.name_exam = name_exam;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
