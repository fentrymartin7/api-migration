package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.PlayerCard;
import com.revature.util.ConnectionUtil;

public class PlayerCardPostgres implements PlayerCardDao{
	
	private static Logger log = LogManager.getRootLogger();
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
	public List<PlayerCard> getCardsByPosition(String pos) {
		String sql = "select * from player_cards where pos = ?;";
		
		List<PlayerCard> cards = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){		
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, pos);
			
			ResultSet rs = ps.executeQuery();
			
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

	@Override
	public List<PlayerCard> getCardsByPointsReboundsAssists(int points, int rebounds, int assists) {
		String sql = "select * from player_cards where points > ? and rebounds > ? and assists > ? order by points desc;";
		
		List<PlayerCard> cards = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){		
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, points);
			ps.setInt(2, rebounds);
			ps.setInt(3, assists);
			
			ResultSet rs = ps.executeQuery();
			
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

	@Override
	public List<PlayerCard> getCardsByPoints(int points) {
		String sql = "select * from player_cards where points > ? order by points desc;";
		
		List<PlayerCard> cards = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){		
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, points);
			
			ResultSet rs = ps.executeQuery();
			
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

	@Override
	public List<PlayerCard> getCardsByRebounds(int rebounds) {
		String sql = "select * from player_cards where rebounds > ? order by rebounds desc;";
		
		List<PlayerCard> cards = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){		
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, rebounds);
			
			ResultSet rs = ps.executeQuery();
			
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

	@Override
	public List<PlayerCard> getCardsByAssists(int assists) {
		String sql = "select * from player_cards where assists > ? order by assists desc;";
		
		List<PlayerCard> cards = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){		
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, assists);
			
			ResultSet rs = ps.executeQuery();
			
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

	@Override
	public int addCard(PlayerCard card) {
		int generatedId = -1;
		String sql = "insert into player_cards(name,pos,draft_year,points,rebounds,assists) "
				+ "values(?,?,?,?,?,?) returning id;";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, card.getName());
			ps.setString(2, card.getPosition());
			ps.setInt(3, card.getDraftYear());
			ps.setInt(4, card.getPoints());
			ps.setInt(5, card.getRebounds());
			ps.setInt(6, card.getAssists());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				generatedId = rs.getInt("id");
				System.out.print(generatedId);
				log.info("A new card was added.");
			}
			
		} catch(SQLException | IOException e) {
			log.error("Exception was thrown: " + e.fillInStackTrace());
			e.printStackTrace();
		}
		return generatedId;
	}

	@Override
	public boolean updateCard(PlayerCard card) {
		
		String sql = "update player_cards set name = ?, pos = ?, draft_year = ?, "
				+ "points = ?, rebounds = ?, assists = ? where id = ? returning id;";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, card.getName());
			ps.setString(2, card.getPosition());
			ps.setInt(3, card.getDraftYear());
			ps.setInt(4, card.getPoints());
			ps.setInt(5, card.getRebounds());
			ps.setInt(6, card.getAssists());
			ps.setInt(7, card.getId());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				log.info("An existing card was updated.");
				return true;
			}
			
		} catch(SQLException | IOException e) {
			e.printStackTrace();
			log.error("An exception was thrown while trying to update card: "+e.fillInStackTrace());
		}
		return false;
		
	}

	@Override
	public boolean deleteCardById(int id) {
		String sql = "delete from player_cards where id = ? returning id;";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				log.info("An existing card was deleted.");
				return true;
			}
			
		} catch(SQLException | IOException e) {
			e.printStackTrace();
			log.error("An exception was thrown while trying to delete card: "+e.fillInStackTrace());
		}
		return false;
	}
	
}
