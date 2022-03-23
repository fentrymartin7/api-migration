package com.revature.services;


import java.util.List;

import com.revature.daos.PlayerCardDao;
import com.revature.daos.PlayerCardPostgres;
import com.revature.exceptions.CardNotCreatedException;
import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;

public class PlayerCardService {

	private PlayerCardDao playerCardDao;
	
	public PlayerCardService() {
		
		playerCardDao = new PlayerCardPostgres();
	}
	
	public PlayerCardService(PlayerCardDao playerCardDao) {
		
		this.playerCardDao = playerCardDao;
	}
	
	// get a card by its id
	public PlayerCard getById(int id) throws CardNotFoundException{
		PlayerCard card = playerCardDao.getById(id);
		
		if(card==null) {
			throw new CardNotFoundException();
		}
		
		return card;
	}
	
	public List<PlayerCard>getCardsByPosition(String position) {
		List<PlayerCard> cards = playerCardDao.getCardsByPosition(position);
		
		return cards;
	}
	
	public List<PlayerCard> getCardsByPointsReboundsAssists(int points,int rebounds,int assists) {
		List<PlayerCard> cards = playerCardDao.getCardsByPointsReboundsAssists(points, rebounds, assists);
		
		return cards;
	}
	
	public List<PlayerCard>getCardsByPoints(int points) {
		List<PlayerCard> cards = playerCardDao.getCardsByPoints(points);
		
		return cards;
	}
	
	public List<PlayerCard>getCardsByRebounds(int rebounds) {
		List<PlayerCard> cards = playerCardDao.getCardsByRebounds(rebounds);
		
		return cards;
	}
	
	public List<PlayerCard>getCardsByAssists(int assists) {
		List<PlayerCard> cards = playerCardDao.getCardsByAssists(assists);
		
		return cards;
	}
	
	public List<PlayerCard>getCardsByTeam(String teamName) {
		List<PlayerCard> cards = playerCardDao.getCardsByTeam(teamName);
		
		return cards;
	}
	
	public List<PlayerCard> getAllCards() {
		List<PlayerCard> cards = playerCardDao.getAllCards();
		
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
