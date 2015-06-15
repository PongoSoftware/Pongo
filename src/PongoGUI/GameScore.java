package PongoGUI;

import javax.swing.JLabel;

/**
 * @author fgsebares
 * @version v0.1
 * @since 2015/06/16 *
 */
public class GameScore extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int numPlayers = 0;
	
	private String playerName;
	private int playerScore;
	
	/**
	 * @param nPlayer
	 */
	public GameScore(String nPlayer){
		
		numPlayers++;
		playerName = nPlayer;
		playerScore = 0;
		
	}
	
	/**
	 * 
	 */
	public GameScore(){
		
		numPlayers++;
		playerName = "Player " + numPlayers;
		playerScore = 0;
		
	}
	
	/* (sin Javadoc)
	 * @see java.awt.Component#setName(java.lang.String)
	 */
	public void setName(String nName){
		
		playerName = nName;
		
	}
	
	/**
	 * 
	 */
	public void scored(){
		
		playerScore++;
		
	}
	
	/**
	 * 
	 */
	public void resetScore(){
		
		playerScore = 0;
		
	}

}
