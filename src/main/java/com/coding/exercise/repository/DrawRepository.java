package com.coding.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.coding.exercise.domain.Draw;

public interface DrawRepository 
	extends CrudRepository<Draw, Integer>{

}
