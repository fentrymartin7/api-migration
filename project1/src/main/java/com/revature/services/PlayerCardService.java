package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;
import com.revature.repositories.PlayerCardRepository;

@Service
public class PlayerCardService {

	private PlayerCardRepository pcr;
	
	@Autowired
	public PlayerCardService(PlayerCardRepository pcr) {
		super();
		this.pcr = pcr;
	}
	
	public List<PlayerCard> getAllCards(){
		return pcr.findAll();
	}
	
	public PlayerCard getCardById(int id) {
		return pcr.findCardById(id);
	}
	
	public List<PlayerCard> getCardsByName(String name){
		return pcr.findCardsByName(name);
	}
	
	public List<PlayerCard> getCardsByPosition(String pos){
		return pcr.findCardsByPosition(pos);
	}
	
	public List<PlayerCard> getCardsByPoints(int points){
		return pcr.findCardsByPoints(points);
	}
	
	@Transactional
	public PlayerCard createCard(PlayerCard card) {
		return pcr.save(card);
	}
	
	@Transactional
	public PlayerCard updateCard(int id, PlayerCard card) {
		PlayerCard c = pcr.findById(id).orElseThrow(CardNotFoundException::new);
		card.setId(c.getId());
		return pcr.save(card);
	}
	
	@Transactional
	public void deleteCard(int id) throws CardNotFoundException {
		// this tries to retrieve a card by id, if it doesn't exist, throws an exception
		getCardById(id);

		pcr.deleteById(id);
	}
}
