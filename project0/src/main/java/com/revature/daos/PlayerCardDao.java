package com.revature.daos;


import java.util.List;

import com.revature.models.PlayerCard;

public interface PlayerCardDao {
	public PlayerCard getById(int id);
	public List<PlayerCard> getAllCards();

}
