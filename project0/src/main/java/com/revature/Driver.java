package com.revature;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.PlayerCardController;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[]args) {
		
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
			
			config.defaultContentType = "application/json";
			
		});
		
		app.start(8080);
		
		// paths for all the different requests
		app.routes(() -> {
			path("cards", () -> {
				get(PlayerCardController::getAllCards);
				post(PlayerCardController::addCard);
				
				path("{id}", () -> {
					get(PlayerCardController::getCardById);
					put(PlayerCardController::updateCard);
					delete(PlayerCardController::deleteCardById);
				});
				
				path("pos",() -> {
					path("{pos}",() -> {
						get(PlayerCardController::getCardsByPosition);
					});
				});
				
				path("points-rebounds-assists",() -> {
					path("{points}pts{rebounds}reb{assists}a",() -> {
						get(PlayerCardController::getCardsByPointsReboundsAssists);
					});
				});
				
				path("points",() -> {
					path("{points}",() -> {
						get(PlayerCardController::getCardsByPoints);
					});
				});
				
				path("rebounds",() -> {
					path("{rebounds}",() -> {
						get(PlayerCardController::getCardsByRebounds);
					});
				});
				
				path("assists",() -> {
					path("{assists}",() -> {
						get(PlayerCardController::getCardsByAssists);
					});
				});
				
			});
			
		
		});
		
	}
}
