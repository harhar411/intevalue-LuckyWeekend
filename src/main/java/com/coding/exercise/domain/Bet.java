package com.coding.exercise.domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Entity
public class Bet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapsId
	private Person person;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapsId
	private Ticket ticket;
	
	private Date betDate;
	
	// comma delimited number combination
	private String registeredNumberCombination;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Date getBetDate() {
		return betDate;
	}
	
	public void setBetDate(Date betDate) {
		this.betDate = betDate;
	}

	public String getRegisteredNumberCombination() {
		return registeredNumberCombination;
	}
	
	public void setRegisteredNumberCombination(String registeredNumberCombination) {
		this.registeredNumberCombination = registeredNumberCombination;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
