package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;
import com.revature.repositories.PlayerCardRepository;
import com.revature.repositories.UserRepository;

@Service
public class PlayerCardService {

	private PlayerCardRepository pcr;
	private UserRepository ur;
	
	@Autowired
	public PlayerCardService(PlayerCardRepository pcr,UserRepository ur) {
		super();
		this.pcr = pcr;
		this.ur = ur;
	}
	
	public List<PlayerCard> getAllCards()throws CardNotFoundException{
		return pcr.findAll();
	}
	
	public List<PlayerCard> getMyCards(int id)throws CardNotFoundException{
		return pcr.findMyCards(ur.findById(id).get()); 
	}
	
	public List<PlayerCard> getAvailableCards(){
		return pcr.findAvailableCards();
	}
	
	public PlayerCard getCardById(int id)throws CardNotFoundException {
		if(pcr.findCardById(id)==null) {
			throw new CardNotFoundException("No card was found of that id.");
		}
		return pcr.findCardById(id);
	}
	
	public List<PlayerCard> getCardsByName(String name) {
		if(pcr.findCardsByName(name).isEmpty()) {
			throw new CardNotFoundException("No card was found of that name.");
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
