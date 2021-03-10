package com.coding.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.coding.exercise.domain.Bet;

public interface BetRepository 
	extends CrudRepository<Bet, Integer>{
	
}
