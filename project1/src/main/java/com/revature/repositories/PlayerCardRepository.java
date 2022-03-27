package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.PlayerCard;

@Repository
public interface PlayerCardRepository extends JpaRepository<PlayerCard,Integer>{
	
	public PlayerCard findCardById(int id);
	public List<PlayerCard> findCardsByName(String name);
	public List<PlayerCard> findCardsByPosition(String position);
	public List<PlayerCard> findCardsByPoints(int points);
	
}
