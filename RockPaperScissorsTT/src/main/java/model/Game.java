package model;

public class Game {
	
	Player player1;
	Player player2;
	boolean end;
	
	public Game(Player player1, Player player2, boolean end) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.end = end;
	}

	public Game() {
		
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Game [player1=" + player1 + ", player2=" + player2 + ", end=" + end + "]";
	}
	
	
	
	

}
