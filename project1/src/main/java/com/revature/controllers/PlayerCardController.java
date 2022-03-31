package com.revature.controllers;

import java.util.List;
import java.util.UUID;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.PlayerCard;
import com.revature.services.AuthService;
import com.revature.services.PlayerCardService;

@RestController
@RequestMapping("/cards")
public class PlayerCardController {

	private PlayerCardService pcs;
	private AuthService as;
	private static Logger log = LoggerFactory.getLogger(PlayerCardController.class); 
	
	@Autowired
	public PlayerCardController(PlayerCardService pcs, AuthService as) {
		super();
		this.pcs = pcs;
		this.as = as;
	}
	
	@GetMapping
	public ResponseEntity<List<PlayerCard>> getAllCards(@RequestParam(name="name",required=false)String name,
														@RequestParam(name="position",required=false)String position,
														@RequestParam(name="draftYear",required=false)String draftYear,
														@RequestParam(name="points",required=false)String points,
														@RequestParam(name="rebounds",required=false)String rebounds,
														@RequestParam(name="assists",required=false)String assists){
		
//		if(points!=null ) {
//			return new ResponseEntity<>(pcs.getCardsByPoints(Integer.parseInt(points)),HttpStatus.OK);
//		}
		log.info("Cards retrieved.");
		return new ResponseEntity<>(pcs.getAllCards(name,position,draftYear,points,rebounds,assists), HttpStatus.OK);
	}
	
	@PostMapping 
	public ResponseEntity<String> postPlayerCard(@RequestBody PlayerCard card, 
												@RequestHeader(value="Authorization",required=false) String token) {
		/*-
		 * logic to return appropriate response based on creation success
		 */
		// this logic should be handled as a filter
		MDC.put("requestId", UUID.randomUUID().toString());
		// auth logic throws a runtime exception if not verified, better placed as a filter
		as.verify(token);
			
		log.info("New card created.");
		pcs.createCard(card);
		return new ResponseEntity<>("Card created successfully!", HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PlayerCard> getById(@PathVariable("id")int id) {
		return new ResponseEntity<>(pcs.getCardById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PlayerCard> updateCard(@PathVariable("id")int id, @RequestBody PlayerCard card,
												@RequestHeader(value="Authorization",required=false)String token) {
		MDC.put("requestId", UUID.randomUUID().toString());
		as.verify(token);		
		log.info("Card of id "+ id + "was updated.");
		return new ResponseEntity<>(pcs.updateCard(id, card), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCardById(@PathVariable("id") int id,
												@RequestHeader(value="Authorization",required=false)String token) {
		MDC.put("requestId", UUID.randomUUID().toString());
		as.verify(token);		
		
		pcs.deleteCard(id);
		log.info("Card of id "+ id + "was deleted.");
		return new ResponseEntity<>("Card was deleted",HttpStatus.OK);
	}
}
