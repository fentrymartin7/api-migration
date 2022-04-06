package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.exceptions.CardNotFoundException;
import com.revature.models.PlayerCard;
import com.revature.repositories.PlayerCardRepository;

@ExtendWith(MockitoExtension.class)
public class PlayerCardServiceTest {
	
	static PlayerCardRepository cardRepo;
	static PlayerCardService cardServ;
	static List<PlayerCard> cards = new ArrayList<>();
	static PlayerCard card;
	
	@BeforeAll
	public static void setup() {
		cardRepo = mock(PlayerCardRepository.class);
		cardServ = new PlayerCardService(cardRepo);
		card = new PlayerCard(1,"x","x",1999,1,1,1,null);
		cards.add(card);
	}
	
	@Test
	public void getAllCardsTest() {
		when(cardRepo.findAll()).thenReturn(cards);
		assertEquals(cards, cardServ.getAllCards());
	}
	
	@Test
	public void getAllCardsFailTest() {
		when(cardRepo.findAll()).thenReturn(null);
		assertThrows(CardNotFoundException.class,()->{
			cardServ.getAllCards();
		});
	}
	
	@Test
	public void getAvailableCardsTest() {
		when(cardRepo.findAvailableCards()).thenReturn(cards);
		assertEquals(cards, cardServ.getAvailableCards());
	}
	
	@Test
	public void getCardByIdTest() {
		when(cardRepo.findCardById(1)).thenReturn(card);
		assertEquals(card, cardServ.getCardById(1));
	}
	
	@Test
	public void getCardByIdFailTest() {
		when(cardRepo.findCardById(4)).thenReturn(null);
		assertThrows(CardNotFoundException.class, ()->{
			cardServ.getCardById(4);
		});
	}
	
	@Test
	public void getCardsByNameTest() {
		cards.add(new PlayerCard(2,"x","g",1998,1,1,1,null));
		when(cardRepo.findCardsByName("x")).thenReturn(cards);
		assertEquals(cards, cardServ.getCardsByName("x"));
	}
	
	@Test
	public void getCardByNameFailTest() {
		when(cardRepo.findCardsByName("ooo")).thenReturn(new ArrayList<PlayerCard>());
		assertThrows(CardNotFoundException.class, ()->{
			cardServ.getCardsByName("ooo");
		});
	}
	
	@Test
	public void getCardsByPointsTest() {
		cards.add(new PlayerCard(2,"x","g",1998,1,1,1,null));
		when(cardRepo.findCardsByPoints(1)).thenReturn(cards);
		assertEquals(cards, cardServ.getCardsByPoints(1));
	}
	
	@Test
	public void createCardTest() {
		when(cardRepo.save(card)).thenReturn(card);
		assertEquals(card, cardServ.createCard(card));
	}
	
	@Test
	public void updateCardTest() throws CardNotFoundException {
		when(cardRepo.findById(1)).thenReturn(Optional.of(card));
		when(cardRepo.save(card)).thenReturn(card);
		assertEquals(card, cardServ.updateCard(1, card));
	}
	
	@Test
	public void deleteCardByIdTest() {
		when(cardRepo.getById(1)).thenReturn(card);
		assertEquals(cardServ.deleteCard(1),true);
	}
	
}
