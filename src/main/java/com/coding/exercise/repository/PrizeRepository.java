package com.coding.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.coding.exercise.domain.Prize;

public interface PrizeRepository 
	extends CrudRepository<Prize, Integer> {

}
