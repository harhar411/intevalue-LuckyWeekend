package com.coding.exercise.domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Date registeredDate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getRegisteredDate() {
		return registeredDate;
	}
	
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

}
