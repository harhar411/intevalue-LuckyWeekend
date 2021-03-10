package com.coding.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.exercise.domain.Bet;
import com.coding.exercise.domain.Draw;
import com.coding.exercise.domain.Prize;
import com.coding.exercise.repository.DrawRepository;

@Service
public class DrawMethods {
	@Autowired
	DrawRepository drawRepository;
	
	public void grabPrize(Draw d) {
		d.setPrizeClaimed(true);
		
		drawRepository.save(d);
	}
	
	public Draw generatePersistentWinner(Integer drawId, Bet b, Prize p) {
		Draw d = new Draw();
		
		d.setId(drawId);
		d.setBet(b);
		d.setPrize(p);
		d.setWinningNumberCombination(b.getRegisteredNumberCombination());
		
		drawRepository.save(d);
		
		return d;
	}
	
	public Draw generateNonPersistentWinner(Integer drawId, Bet b, Prize p) {
		Draw d = new Draw();
		
		d.setId(drawId);
		d.setBet(b);
		d.setPrize(p);
		d.setWinningNumberCombination(b.getRegisteredNumberCombination());
		
		return d;
	}
}
