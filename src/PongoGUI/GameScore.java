package PongoGUI;

import javax.swing.JLabel;

public class GameScore extends JLabel {
	
	private static int numPlayers = 0;
	
	private String playerName;
	private int playerScore;
	
	public GameScore(String nPlayer){
		
		numPlayers++;
		playerName = nPlayer;
		playerScore = 0;
		
	}
	
	public GameScore(){
		
		numPlayers++;
		playerName = "Player " + numPlayers;
		playerScore = 0;
		
	}
	
	public void setName(String nName){
		
		playerName = nName;
		
	}
	
	public void scored(){
		
		playerScore++;
		
	}
	
	public void resetScore(){
		
		playerScore = 0;
		
	}

}
