package com.revature.services;


import java.util.List;

import com.revature.daos.PlayerCardDao;
import com.revature.daos.PlayerCardPostgres;
import com.revature.exceptions.CardNotCreatedException;
import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;

public class PlayerCardService {

	private PlayerCardDao playerCardDao = new PlayerCardPostgres();
	
	// get a card by its id
	public PlayerCard getById(int id) throws CardNotFoundException{
		PlayerCard card = playerCardDao.getById(id);
		
		if(card==null) {
			throw new CardNotFoundException();
		}
		
		return card;
	}
	
	public List<PlayerCard>getCardsByPosition(String position) throws CardNotFoundException{
		List<PlayerCard> cards = playerCardDao.getCardsByPosition(position);
		
		if(cards==null) {
			throw new CardNotFoundException();
		}
		return cards;
	}
	
	public List<PlayerCard> getCardsByPointsReboundsAssists(int points,int rebounds,int assists) throws CardNotFoundException{
		List<PlayerCard> cards = playerCardDao.getCardsByPointsReboundsAssists(points, rebounds, assists);
		
		if(cards==null) {
			throw new CardNotFoundException();
		}
		return cards;
	}
	
	public List<PlayerCard>getCardsByPoints(int points) throws CardNotFoundException{
		List<PlayerCard> cards = playerCardDao.getCardsByPoints(points);
		if(cards==null) {
			throw new CardNotFoundException();
		}
		return cards;
	}
	
	public List<PlayerCard>getCardsByRebounds(int rebounds) throws CardNotFoundException{
		List<PlayerCard> cards = playerCardDao.getCardsByRebounds(rebounds);
		if(cards==null) {
			throw new CardNotFoundException();
		}
		return cards;
	}
	
	public List<PlayerCard>getCardsByAssists(int assists) throws CardNotFoundException{
		List<PlayerCard> cards = playerCardDao.getCardsByPoints(assists);
		if(cards==null) {
			throw new CardNotFoundException();
		}
		return cards;
	}
	
	public List<PlayerCard> getAllCards() throws CardNotFoundException{
		List<PlayerCard> cards = playerCardDao.getAllCards();
		
		if(cards==null) {
			throw new CardNotFoundException();
		}
		return cards;
	}
	
	public boolean addCard(PlayerCard card) throws CardNotCreatedException {
		int newId = playerCardDao.addCard(card);
		
		if(newId == -1) {
			return false;
		}
		
		return true;
	}
	
	public boolean updateCard(PlayerCard card) {
		return playerCardDao.updateCard(card);
	}
	
	public boolean deleteCardById(int id) {
		return playerCardDao.deleteCardById(id);
	}
}
