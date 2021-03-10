package com.coding.exercise.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;

@Entity
public class Draw {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapsId
	private Bet bet;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapsId
	private Prize prize;
	
	private Date drawDate;
	
	// comma delimited number combination
	private String winningNumberCombination;
	
	private boolean prizeClaimed;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Bet getBet() {
		return bet;
	}
	
	public void setBet(Bet bet) {
		this.bet = bet;
	}
	
	public Prize getPrize() {
		return prize;
	}
	
	public void setPrize(Prize prize) {
		this.prize = prize;
	}
	
	public Date getDrawDate() {
		return drawDate;
	}
	
	public void setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
	}
	
	public String getWinningNumberCombination() {
		return winningNumberCombination;
	}

	public void setWinningNumberCombination(String winningNumberCombination) {
		this.winningNumberCombination = winningNumberCombination;
	}

	public boolean isPrizeClaimed() {
		return prizeClaimed;
	}

	public void setPrizeClaimed(boolean prizeClaimed) {
		this.prizeClaimed = prizeClaimed;
	}
}
