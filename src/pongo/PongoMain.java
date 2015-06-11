package pongo;

import pongo.physics.Collider;
import PongoGUI.Background;
import PongoGUI.GameFrame;

public class PongoMain {
	
	GameFrame frame;
	Object2D[] rackets;
	Object2D disc;
	Field field;
	Goal[] goal;
	Background back;
	
	public PongoMain(int numPlayers){
		int velocicdad = 200;
		
		int panelx, panely;
		panelx = 800;
		panely = 600;
			
		int racketwidth = 40;
		int racketheight = 40;

		rackets = new Racket[numPlayers];
		
		int widthGoal = 5;
		int heightGoal = 60;
		int marginGoalx = 0;
		int marginGoaly = 0;
		
		int marginFieldx = 0;
		int marginFieldy = 0;
		int widthFieldx = panelx;
		int heightFieldx = panely;
		
		field = new Field(marginFieldx, marginFieldy, widthFieldx, heightFieldx); 
		
		goal = new Goal[numPlayers];
		
		for (int i = 0; i < numPlayers; i++){
			int posx = panelx / 3 * (i + 1) - racketwidth / 2;
			int posy = panely / 2 - racketheight / 2;
			rackets[i] = new Racket(posx, posy, racketwidth, racketheight);
			int posxGoal = panelx * i - marginFieldx / 2 - widthGoal * i * 2;
//			if (i == 1){
//				posxGoal = panelx * i - marginFieldx / 2;
//			}
			int posyGoal = panely / 2 - heightGoal / 2;
			goal[i] = new Goal(posxGoal, posyGoal, widthGoal, heightGoal);
		}
		
		int discSize = 30;
		int posx = panelx / 2 - discSize / 2;
		int posy = panely / 2 - discSize / 2;
		disc = new Disc(posx, posy, discSize, discSize);
		
		
		back = new Background();
		
		frame = new GameFrame(panelx, panely, back);
		
		frame.drawGameObject(rackets[0]);
		frame.drawGameObject(rackets[1]);
		frame.drawGameObject(disc);
		frame.drawGameObject(goal[0]);
		frame.drawGameObject(goal[1]);
		
		boolean sigueJuego = false;
		do{
			
			frame.repaint();
			try {
				Thread.sleep(velocicdad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
//				((Mobil) disc).move();
				Collider.checkCollisionList();
			}
		}while(sigueJuego);
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
