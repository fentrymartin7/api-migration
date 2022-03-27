package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="player_cards")
public class PlayerCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String position;
	@Column(name="draft_year",nullable=false)
	private int draftYear;
	@Column(columnDefinition = "integer check (points > 0)" )
	private int points;
	@Column
	private int rebounds;
	@Column
	private int assists;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User cardOwner;
	
	public PlayerCard() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPos(String position) {
		this.position = position;
	}

	public int getDraftYear() {
		return draftYear;
	}

	public void setDraftYear(int draftYear) {
		this.draftYear = draftYear;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public User getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(User cardOwner) {
		this.cardOwner = cardOwner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assists, draftYear, id, name, cardOwner, points, position, rebounds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerCard other = (PlayerCard) obj;
		return assists == other.assists && draftYear == other.draftYear && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(cardOwner, other.cardOwner) && points == other.points
				&& Objects.equals(position, other.position) && rebounds == other.rebounds;
	}

	@Override
	public String toString() {
		return "PlayerCard [id=" + id + ", name=" + name + ", position=" + position + ", draftYear=" + draftYear + ", points="
				+ points + ", rebounds=" + rebounds + ", assists=" + assists + ", cardOwner=" + cardOwner + "]";
	}
	
}
