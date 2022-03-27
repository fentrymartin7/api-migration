package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.PlayerCard;
import com.revature.services.PlayerCardService;

@RestController
@RequestMapping("/cards")
public class PlayerCardController {

	private PlayerCardService pcs;
	
	@Autowired
	public PlayerCardController(PlayerCardService pcs) {
		super();
		this.pcs = pcs;
	}
	
	@GetMapping
	public ResponseEntity<List<PlayerCard>> getAllCards(@RequestParam(name="position",required=false)String position){
		if(position!=null) {
			return new ResponseEntity<>(pcs.getCardsByPosition(position),HttpStatus.OK);
		}
		return new ResponseEntity<>(pcs.getAllCards(), HttpStatus.OK);
	}
	
	@PostMapping 
	public ResponseEntity<String> postPlayerCard(@RequestBody PlayerCard card) {
		/*-
		 * logic to return appropriate response based on creation success
		 */
		pcs.createCard(card);
		return new ResponseEntity<>("Card created successfully!", HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PlayerCard> getById(@PathVariable("id")int id) {
		return new ResponseEntity<>(pcs.getCardById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PlayerCard> updateCard(@PathVariable("id")int id, @RequestBody PlayerCard card) {
		
		return new ResponseEntity<>(pcs.updateCard(id, card), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCardById(@PathVariable("id") int id) {
		pcs.deleteCard(id);
		return new ResponseEntity<>("Card was deleted",HttpStatus.OK);
	}
}
