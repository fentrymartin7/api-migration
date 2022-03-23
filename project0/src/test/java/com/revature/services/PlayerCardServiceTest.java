package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.PlayerCardDao;
import com.revature.exceptions.CardNotCreatedException;
import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;

@ExtendWith(MockitoExtension.class)
public class PlayerCardServiceTest {

	static PlayerCardDao cardDao;
	static PlayerCardService pcs;
	static List<PlayerCard> cards = new ArrayList<>();
	static PlayerCard card;
	
	@BeforeAll
	public static void setup() {
		cardDao = mock(PlayerCardDao.class);
		pcs = new PlayerCardService(cardDao);
		card = new PlayerCard(1,"X","X",2000,100,100,100);
		cards.add(card);
	}
	
	@Test
	public void getByIdTest() throws CardNotFoundException {
		when(cardDao.getById(1)).thenReturn(card);
		assertDoesNotThrow( () ->{
			pcs.getById(1);
		});
		assertEquals(card, pcs.getById(1));
	}
	
	@Test
	public void getCardsByPositionTest() {
		when(cardDao.getCardsByPosition("X")).thenReturn(cards);
		assertEquals(cards,pcs.getCardsByPosition("X"));
	}
	
	@Test
	public void getCardsByPointsReboundsAssistTest() {
		when(cardDao.getCardsByPointsReboundsAssists(10, 10, 10)).thenReturn(cards);
		assertEquals(cards,pcs.getCardsByPointsReboundsAssists(10, 10, 10));
	}
	
	@Test
	public void getCardsByPointsTest() {
		when(cardDao.getCardsByPoints(10)).thenReturn(cards);
		assertEquals(cards,pcs.getCardsByPoints(10));
	}
	
	@Test
	public void getCardsByReboundsTest() {
		when(cardDao.getCardsByRebounds(10)).thenReturn(cards);
		assertEquals(cards,pcs.getCardsByRebounds(10));
	}
	
	@Test
	public void getCardsByAssistsTest() {
		when(cardDao.getCardsByAssists(10)).thenReturn(cards);
		assertEquals(cards,pcs.getCardsByAssists(10));
	}
	
	@Test
	public void getCardsByTeamTest() {
		when(cardDao.getCardsByTeam("x")).thenReturn(cards);
		assertEquals(cards,pcs.getCardsByTeam("x"));
	}
	
	@Test
	public void getAllCardsTest() {
		when(cardDao.getAllCards()).thenReturn(cards);
		assertEquals(cards,pcs.getAllCards());
	}
	
	@Test
	public void addCardTest() throws CardNotCreatedException {
		when(cardDao.addCard(card)).thenReturn(2);
		assertDoesNotThrow( () ->{
			pcs.addCard(card);
		});
		assertEquals(true,pcs.addCard(card));
	}
	
	@Test
	public void updateCardTest() {
		when(cardDao.updateCard(card)).thenReturn(true);
		assertEquals(pcs.updateCard(card),true);
	}
	
	@Test
	public void deleteCardTest() {
		when(cardDao.deleteCardById(1)).thenReturn(true);
		assertEquals(pcs.deleteCardById(1),true);
	}
}
