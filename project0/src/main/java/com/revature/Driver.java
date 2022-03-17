package com.revature;

import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;
import com.revature.services.PlayerCardService;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[]args) {
		
		PlayerCardService pcs = new PlayerCardService();
		
		Javalin app = Javalin.create();
		app.start(8080);
		
		app.get("cards", (ctx)->{
			// within HTTP handlers, leverage methods from is to handle HTTP request
		});
		
		// example of a path param
		app.get("card/{id}", (ctx) -> {
			// returns the value of pathparam of name id, converted string to int
			int id = Integer.parseInt(ctx.pathParam("id"));
			// retrieve item using Item service method
			try {
				PlayerCard card = pcs.getById(id);
				ctx.json(card);
				ctx.status(200);
			} catch (CardNotFoundException e) {
				ctx.status(404);
				ctx.result("Card of id: " + id + " was not found");
				// log this to file
			}

		});
		
	}
}
