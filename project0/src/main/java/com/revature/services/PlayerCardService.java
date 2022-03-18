package com.revature.services;


import java.util.List;

import com.revature.daos.PlayerCardDao;
import com.revature.daos.PlayerCardPostgres;
import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;

public class PlayerCardService {

	private PlayerCardDao playerCardDao;
	
	public PlayerCardService() {
		playerCardDao = new PlayerCardPostgres();
	}
	
	// get a card by its id
	public PlayerCard getById(int id) throws CardNotFoundException{
		PlayerCard card = playerCardDao.getById(id);
		
		if(card==null) {
			throw new CardNotFoundException();
		}
		
		return card;
	}
	
	//get all cards in db table
	public List<PlayerCard> getAllCards() throws CardNotFoundException{
		List<PlayerCard> cards = playerCardDao.getAllCards();
		
		if(cards==null) {
			throw new CardNotFoundException();
		}
		return cards;
	}
}
