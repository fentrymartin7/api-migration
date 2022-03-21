package com.revature.models;

import java.util.Objects;

public class PlayerCard {
	
	private int id;
	private String name;
	private String position;
	private int draftYear;
	private int points;
	private int assists;
	private int rebounds;
	
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

	public void setPosition(String position) {
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

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, position, draftYear, points, position, rebounds);
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
				&& Objects.equals(name, other.name) && points == other.points
				&& Objects.equals(position, other.position) && rebounds == other.rebounds;
	}

	@Override
	public String toString() {
		return "PlayerCard [id=" + id + ", name=" + name + ", position=" + position + ", draftYear=" + draftYear
				+ ", points=" + points + ", assists=" + assists + ", rebounds=" + rebounds + "]";
	}

	
	
}
