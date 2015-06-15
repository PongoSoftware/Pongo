package pongo;

import java.awt.Component;

import javafx.scene.input.KeyCode;
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
		int velocidad = 36;
		
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
			rackets[i] = new Racket(posx, posy, racketwidth, racketheight,panelx,panely);
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
		disc = new Disc(posx, posy, discSize, discSize,panelx,panely);
		
		
		back = new Background();
		
//		rackets[0].setPos(500,300);
//		rackets[1].setPos(481,271);
//		velocidad = 1000;
		
		frame = new GameFrame(panelx, panely, back);
		frame.setController(this);
		
		frame.drawGameObject(rackets[0]);
		frame.drawGameObject(rackets[1]);
		frame.drawGameObject(disc);
		frame.drawGameObject(goal[0]);
		frame.drawGameObject(goal[1]);
		
//		boolean sigueJuego = false;
		boolean sigueJuego = true;
		do{
			
			movement();
			frame.repaint();
			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				((Mobil) disc).move();
				Collider.checkCollisionList();
			}
		}while(sigueJuego);
	}

	public static void main(String[] args) {
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

	/**
	 * 37 izquierda
	 * 38 arriba
	 * 39 derecha
	 * 40 abajo
	 * @param keyCode
	 */
	public void recieveKeyPressed(int keyCode) {
		switch(keyCode){
		
		case 37:
			((Racket) rackets[1]).moveX(-1);
			break;
		case 38:
			((Racket) rackets[1]).moveY(-1);
			break;
		case 39:
			((Racket) rackets[1]).moveX(1);
			break;
		case 40:
			((Racket) rackets[1]).moveY(1);
			break;
			
		case 65:
			((Racket) rackets[0]).moveX(-1);
			break;
		case 87:
			((Racket) rackets[0]).moveY(-1);
			break;
		case 68:
			((Racket) rackets[0]).moveX(1);
			break;
		case 83:
			((Racket) rackets[0]).moveY(1);
			break;
		}
		
	}
	
	public void recieveKeyReleased(int keyCode) {
		switch(keyCode){
		
		case 37:
			((Racket) rackets[1]).moveX(0);
			break;
		case 38:
			((Racket) rackets[1]).moveY(0);
			break;
		case 39:
			((Racket) rackets[1]).moveX(0);
			break;
		case 40:
			((Racket) rackets[1]).moveY(0);
			break;
			
		case 65:
			((Racket) rackets[0]).moveX(0);
			break;
		case 87:
			((Racket) rackets[0]).moveY(0);
			break;
		case 68:
			((Racket) rackets[0]).moveX(0);
			break;
		case 83:
			((Racket) rackets[0]).moveY(0);
			break;
			
		}
	}
	
	public void movement(){
		
		((Racket)rackets[0]).move(true);
		((Racket)rackets[1]).move(true);
		
	}
		
}
