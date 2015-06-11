package pongo;

import PongoGUI.Background;
import PongoGUI.GameFrame;

public class PongoMain {
	
	GameFrame frame;
	Object2D[] rackets;
	Object2D disc;
	Field field;
	Goal goal;
	Background back;
	
	public PongoMain(int numPlayers){
		int panelx, panely;
		panelx = 800;
		panely = 600;
		
		int racketwidth = 40;
		int racketheight = 40;

		rackets = new Racket[2];
		for (int i = 0; i < numPlayers; i++){
			int posx = panelx / 3 * (i + 1) - racketwidth;
			int posy = panely / 2 - racketheight;
			rackets[i] = new Racket(posx, posy, 0, 0, racketwidth, racketheight);
		}
		
		int discSize = 30;
		int posx = panelx / 2 - discSize;
		int posy = panely / 2 - discSize;
		disc = new Disc(posx, posy, 0, 0, discSize, discSize);
		
		int marginFieldx = 0;
		int marginFieldy = 0;
		int widthFieldx = panelx;
		int heightFieldx = panely;
		
		field = new Field(marginFieldx, marginFieldy, 0, 0, widthFieldx, heightFieldx); 
		
		int sizeGoal = 50;
		int marginGoalx = 0;
		int marginGoaly = 0;
		
		goal = new Goal();
		
		back = new Background();
		
		frame = new GameFrame(panelx, panely, back);
		
		frame.drawGameObject(rackets[0]);
		frame.drawGameObject(rackets[1]);
		frame.drawGameObject(disc);
		
		while(true){
			
			frame.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int numPlayers = 2;
		PongoMain pongoMain = new PongoMain(numPlayers);
		
		/*    Este era el while de prueba para repintar.
		
		while(true){
			
			frame.repaint();
			
			circ1.SetX((int)circ1.GetX()+1);
			
			Thread.sleep(30);
			
		}
		
		*/
	}

}
