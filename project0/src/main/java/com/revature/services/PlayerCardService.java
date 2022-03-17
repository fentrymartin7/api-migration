package com.revature.services;

import com.revature.daos.PlayerCardDao;
import com.revature.daos.PlayerCardPostgres;
import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;

public class PlayerCardService {

	private PlayerCardDao playerCardDao;
	
	public PlayerCardService() {
		playerCardDao = new PlayerCardPostgres();
	}
	
	public PlayerCard getById(int id) throws CardNotFoundException{
		PlayerCard card = playerCardDao.getById(id);
		
		if(card==null) {
			throw new CardNotFoundException();
		}
		
		return card;
	}
}
