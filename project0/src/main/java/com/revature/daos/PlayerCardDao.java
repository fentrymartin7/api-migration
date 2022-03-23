package com.revature.daos;


import java.util.List;

import com.revature.models.PlayerCard;

public interface PlayerCardDao {
	public PlayerCard getById(int id);
	public List<PlayerCard> getAllCards();
	public List<PlayerCard> getCardsByPosition(String pos);
	public List<PlayerCard> getCardsByPointsReboundsAssists(int points,int rebounds,int assists);
	public List<PlayerCard> getCardsByPoints(int points);
	public List<PlayerCard> getCardsByRebounds(int rebounds);
	public List<PlayerCard> getCardsByAssists(int assists);
	public List<PlayerCard> getCardsByTeam(String teamName);
	public int addCard(PlayerCard card);
	public boolean updateCard(PlayerCard card);
	public boolean deleteCardById(int id);
}
