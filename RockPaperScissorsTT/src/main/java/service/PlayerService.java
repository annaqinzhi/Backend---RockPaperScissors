package service;


import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

import model.Game;
import model.Player;

@Service
public class PlayerService {
	
	UUID uuid;
	HashMap<UUID, Game> gameHashmap = new HashMap<UUID, Game>();
	
	public Game getGameByUuid(UUID id) {
		return gameHashmap.get(id);
	}
	
	public String createGame(String name) {
		UUID id = UUID.randomUUID();
		uuid = id;
		Player player1 = new Player (name, null, false);
		Player player2 = new Player (null, null, false);
		Game game = new Game(player1, player2, false);
		gameHashmap.put(uuid, game);
		
		return uuid.toString();
	} 
	
	public String addPlayerByName(String name, UUID id) {
		Game game = gameHashmap.get(id);
		game.getPlayer2().setName(name);
		
		return name;
	}
	
	public String setMove(String move,String name, UUID id) {
		Game game = gameHashmap.get(id);
		
		if(game.getPlayer1().getName().toLowerCase().equals(name.toLowerCase())) {
			game.getPlayer1().setMove(move);
			
		} else {
			game.getPlayer2().setMove(move);
		}
		
		String move1 = game.getPlayer1().getMove();
		String move2 = game.getPlayer2().getMove();
		
		if (move1 != null && move1 != null) {
			if (move1.toLowerCase().equals(move2.toLowerCase())) {
				game.setEnd(true);
			} else if (move1.toLowerCase().equals("rock") && move2.toLowerCase().equals("paper")) {
				game.getPlayer1().setWin(false);
				game.getPlayer2().setWin(true);
				game.setEnd(true);
			} else if (move1.toLowerCase().equals("rock") && move2.toLowerCase().equals("scissors")) {
				game.getPlayer2().setWin(false);
				game.getPlayer1().setWin(true);
				game.setEnd(true);
			} else if (move1.toLowerCase().equals("paper") && move2.toLowerCase().equals("scissors")) {
				game.getPlayer1().setWin(false);
				game.getPlayer2().setWin(true);
				game.setEnd(true);
			} else if (move1.toLowerCase().equals("paper") && move2.toLowerCase().equals("rock")) {
				game.getPlayer2().setWin(false);
				game.getPlayer1().setWin(true);
				game.setEnd(true);
			} else if (move1.toLowerCase().equals("scissors") && move2.toLowerCase().equals("paper")) {
				game.getPlayer2().setWin(false);
				game.getPlayer1().setWin(true);
				game.setEnd(true);
			} else if (move1.toLowerCase().equals("scissors") && move2.toLowerCase().equals("rock")) {
				game.getPlayer1().setWin(false);
				game.getPlayer2().setWin(true);
				game.setEnd(true);
			}
		} 
		
		return name+" "+ move;
	}
	
}
