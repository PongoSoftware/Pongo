package pongo;

import PongoGUI.Background;
import PongoGUI.GameFrame;

public class PongoMain {
	
	public PongoMain(int numPlayers){
		int panelx, panely;
		panelx = 800;
		panely = 600;
		
		int racketwidth = 40;
		int racketheight = 40;

		Racket[] rackets = new Racket[2];
		for (int i = 0; i < numPlayers; i++){
			int posx = panelx / 3 * (i + 1) - racketwidth;
			int posy = panely / 2 - racketheight;
			rackets[i] = new Racket(posx, posy, 0, 0, racketwidth, racketheight);
		}
		
		int discSize = 30;
		int posx = panelx / 2 - discSize;
		int posy = panely / 2 - discSize;
		Disc disc = new Disc(posx, posy, 0, 0, discSize, discSize);
		
		int marginFieldx = 0;
		int marginFieldy = 0;
		int widthFieldx = panelx;
		int heightFieldx = panely;
		
		Field field = new Field(marginFieldx, marginFieldy, 0, 0, widthFieldx, heightFieldx); 
		
		int sizeGoal = 50;
		int marginGoalx = 0;
		int marginGoaly = 0;
		
		Goal goal = new Goal();
		
		Background back = new Background();
		
		GameFrame frame = new GameFrame(panelx, panely, back);
		
		while(true){
			
			frame.repaint(true);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		int numPlayers = 2;
		PongoMain pongoMain = new PongoMain(numPlayers);
	}

}
