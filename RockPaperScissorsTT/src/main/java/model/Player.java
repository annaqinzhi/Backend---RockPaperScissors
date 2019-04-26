package model;


public class Player {
	String name;
	String move;
	boolean win;
	
	public Player(String name, String move, boolean win) {
		super();
		this.name = name;
		this.move = move;
		this.win = win;
	}

	public Player() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", move=" + move + ", win=" + win + "]";
	}	
	
	
}
