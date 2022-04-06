package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;
import com.revature.models.User;
import com.revature.repositories.PlayerCardRepository;

@Service
public class PlayerCardService {

	private PlayerCardRepository pcr;
	
	@Autowired
	public PlayerCardService(PlayerCardRepository pcr) {
		super();
		this.pcr = pcr;
	}
	
	public List<PlayerCard> getAllCards()throws CardNotFoundException{
		return pcr.findAll();
	}
	
	public List<PlayerCard> getAvailableCards(){
		return pcr.findAvailableCards();
	}
	
	public PlayerCard getCardById(int id)throws CardNotFoundException {
		if(pcr.findCardById(id)==null) {
			throw new CardNotFoundException();
		}
		return pcr.findCardById(id);
	}
	
	public List<PlayerCard> getCardsByName(String name) {
		if(pcr.findCardsByName(name).isEmpty()) {
			throw new CardNotFoundException();
		}
		return pcr.findCardsByName(name);
	}
	
	public List<PlayerCard> getCardsByPoints(int points) {
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
	public boolean deleteCard(int id) throws CardNotFoundException {
		// try to retrieve a card by id, if it doesn't exist, throw an exception
		getCardById(id);

		pcr.deleteById(id);
		return true;
	}
}
