package com.coding.exercise.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.exercise.domain.Prize;
import com.coding.exercise.repository.PrizeRepository;

@Service
public class PrizeMethods {
	@Autowired
	PrizeRepository prizeRepository;
	
	public Prize createPersistingPrize(Integer id, String name, String description) {
		Prize p = new Prize();
		
		java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().get(Calendar.DATE));
		p.setId(id);
		p.setCreationDate(sqlDate);
		p.setName(name);
		p.setDescription(description);
		
		prizeRepository.save(p);
		
		return p;
	}
	
	public Prize createNonPersistingPrize(Integer id, String name, String description) {
		Prize p = new Prize();
		
		java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().get(Calendar.DATE));
		p.setId(id);
		p.setCreationDate(sqlDate);
		p.setName(name);
		p.setDescription(description);
		
		return p;
	}
}
