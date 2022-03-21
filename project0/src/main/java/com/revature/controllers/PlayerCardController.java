package com.revature.controllers;

import java.util.List;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.exceptions.CardNotCreatedException;
import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;
import com.revature.services.PlayerCardService;

import io.javalin.http.Context;

public class PlayerCardController {

	private static PlayerCardService pcs = new PlayerCardService();
	
	public static void addCard(Context ctx) throws CardNotCreatedException {
		PlayerCard newCard = ctx.bodyAsClass(PlayerCard.class);
		
		ctx.json(newCard);
		
		if(pcs.addCard(newCard)) {
			ctx.status(HttpStatus.CREATED_201);
		} else {
			ctx.status(400);
			ctx.result("Unable to create task.");
		}
	}
	
	public static void getCardById(Context ctx) {
		int cardId = Integer.parseInt(ctx.pathParam("id"));
		
		PlayerCard card;
		try {
			card = pcs.getById(cardId);
			ctx.json(card);
			ctx.status(200);
		} catch (CardNotFoundException e) {
			ctx.status(404);
			ctx.result("Unable to find card.");
			e.printStackTrace();
		}
	}
	
	public static void getAllCards(Context ctx) throws CardNotFoundException {
		ctx.json(pcs.getAllCards());
	}
	
	public static void getCardsByPosition(Context ctx) throws CardNotFoundException{
		String pos = ctx.pathParam("pos");
		
		List<PlayerCard> cards;
		try {
			cards = pcs.getCardsByPosition(pos);
			ctx.json(cards);
			ctx.status(200);
		} catch(CardNotFoundException e){
			ctx.status(404);
			ctx.result("Unable to get cards.");
			e.printStackTrace();
		}
		
	}
	
	public static void getCardsByPointsReboundsAssists(Context ctx) throws CardNotFoundException{
		int points = Integer.parseInt(ctx.pathParam("points"));
		int rebounds = Integer.parseInt(ctx.pathParam("rebounds"));
		int assists = Integer.parseInt(ctx.pathParam("assists"));
		
		List<PlayerCard> cards;
		try {
			cards = pcs.getCardsByPointsReboundsAssists(points,rebounds,assists);
			ctx.json(cards);
			ctx.status(200);
		} catch(CardNotFoundException e){
			ctx.status(404);
			ctx.result("Unable to get cards.");
			e.printStackTrace();
		}
		
	}
	
	public static void getCardsByPoints(Context ctx) throws CardNotFoundException{
		int points = Integer.parseInt(ctx.pathParam("points"));
		
		List<PlayerCard> cards;
		try {
			cards = pcs.getCardsByPoints(points);
			ctx.json(cards);
			ctx.status(200);
		} catch(CardNotFoundException e){
			ctx.status(404);
			ctx.result("Unable to get cards.");
			e.printStackTrace();
		}
		
	}
	
	public static void getCardsByRebounds(Context ctx) throws CardNotFoundException{
		int rebounds = Integer.parseInt(ctx.pathParam("rebounds"));
		
		List<PlayerCard> cards;
		try {
			cards = pcs.getCardsByRebounds(rebounds);
			ctx.json(cards);
			ctx.status(200);
		} catch(CardNotFoundException e){
			ctx.status(404);
			ctx.result("Unable to get cards.");
			e.printStackTrace();
		}
		
	}
	
	public static void getCardsByAssists(Context ctx) throws CardNotFoundException{
		int assists = Integer.parseInt(ctx.pathParam("assists"));
		
		List<PlayerCard> cards;
		try {
			cards = pcs.getCardsByPoints(assists);
			ctx.json(cards);
			ctx.status(200);
		} catch(CardNotFoundException e){
			ctx.status(404);
			ctx.result("Unable to get cards.");
			e.printStackTrace();
		}
		
	}
	
	public static void updateCard(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		PlayerCard card = ctx.bodyAsClass(PlayerCard.class);
		card.setId(id);
		if(pcs.updateCard(card)) {
			ctx.status(200);
			ctx.result("Successfully updated card of id: " + card.getId());
		} else {
			ctx.status(400);
			ctx.result("Unable to update.");
		}
		
	}
	
	public static void deleteCardById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		if(pcs.deleteCardById(id)) {
			ctx.status(200);
			ctx.result("Successfully deleted card of id: " + id);
		} else {
			ctx.status(400);
			ctx.result("Unable to delete.");
		}
		
	}
}
