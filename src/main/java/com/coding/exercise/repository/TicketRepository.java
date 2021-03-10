package com.coding.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.coding.exercise.domain.Ticket;

public interface TicketRepository 
	extends CrudRepository<Ticket, Integer> {


}
