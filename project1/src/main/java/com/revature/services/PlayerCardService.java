package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;
import com.revature.repositories.PlayerCardRepository;

@Service
public class PlayerCardService {

	private PlayerCardRepository pcr;
	
	@Autowired
	public PlayerCardService(PlayerCardRepository pcr) {
		super();
		this.pcr = pcr;
	}
	
	public List<PlayerCard> getAllCards(String name,String position,String draftYear,String points, String rebounds,String assists){
		if(name==null&&position==null&&draftYear==null&&points==null&&rebounds==null&&assists==null) {
			return pcr.findAll();
		}
		List<PlayerCard> cards = pcr.findAll().stream()
				.filter(c -> c.getName().equals(name))
				.filter(c -> c.getPosition().equals(position))
				.filter(c -> c.getDraftYear() == Integer.parseInt(draftYear))
				.filter(c -> c.getPoints() >= Integer.parseInt(points))
				.filter(c -> c.getRebounds() >= Integer.parseInt(rebounds))
				.filter(c -> c.getAssists() >= Integer.parseInt(assists))
				.collect(Collectors.toList());
		
		return cards;
	}
	
	public PlayerCard getCardById(int id) {
		return pcr.findCardById(id);
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
	public void deleteCard(int id) throws CardNotFoundException {
		// try to retrieve a card by id, if it doesn't exist, throw an exception
		getCardById(id);

		pcr.deleteById(id);
	}
}
