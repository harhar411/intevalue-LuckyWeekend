package com.coding.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.coding.exercise.domain.Person;

public interface PersonRepository 
	extends CrudRepository<Person, Integer>{
}
