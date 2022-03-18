package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.PlayerCard;
import com.revature.util.ConnectionUtil;

public class PlayerCardPostgres implements PlayerCardDao{

	@Override
	public PlayerCard getById(int id) {
		// set up query to get a player card by its id
		String sql = "select * from player_cards where id = ?;";
		PlayerCard playerCard = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			// Executing the query from the ps, and assigning the db's query result to a result set
			ResultSet rs = ps.executeQuery();
						
			if(rs.next()) {
				playerCard = new PlayerCard();
				playerCard.setId(rs.getInt("id"));
				playerCard.setName(rs.getString("name"));
				playerCard.setPosition(rs.getString("pos"));
				playerCard.setDraftYear(rs.getInt("draft_year"));
				playerCard.setPoints(rs.getInt("points"));
				playerCard.setRebounds(rs.getInt("rebounds"));
				playerCard.setAssists(rs.getInt("assists"));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return playerCard;
	}

	@Override
	public List<PlayerCard> getAllCards() {
		String sql = "select * from player_cards;";
		
		List<PlayerCard> cards = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			Statement statement = c.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				PlayerCard playerCard = new PlayerCard();
				playerCard.setId(rs.getInt("id"));
				playerCard.setName(rs.getString("name"));
				playerCard.setPosition(rs.getString("pos"));
				playerCard.setDraftYear(rs.getInt("draft_year"));
				playerCard.setPoints(rs.getInt("points"));
				playerCard.setRebounds(rs.getInt("rebounds"));
				playerCard.setAssists(rs.getInt("assists"));
				
				cards.add(playerCard);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return cards;
	}
	

}
