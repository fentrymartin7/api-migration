package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.PlayerCard;

@Repository
public interface PlayerCardRepository extends JpaRepository<PlayerCard,Integer>{
	
	public PlayerCard findCardById(int id);
	
	
	public List<PlayerCard> findCardsByName(String name);
	
	public List<PlayerCard> findCardsByPosition(String position);
	
	@Query("select p from PlayerCard p where p.points >= :points")
	public List<PlayerCard> findCardsByPoints(int points);
	
	@Query("select p from PlayerCard p where p.points >= :points and p.rebounds >= :rebounds and p.assists >= :assists")
	public List<PlayerCard> findCardsByPRA(int points, int rebounds, int assists);
}
