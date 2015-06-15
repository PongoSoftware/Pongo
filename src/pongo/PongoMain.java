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
	Object2D[] fieldLimit;
	Goal[] goal;
	Background back;
	
	public PongoMain(int numPlayers){
		int top, rigth, botton, left;
		int speedGame = 36;
		
		int panelx, panely, framex, framey;
		framex = 800;
		framey = 600;
		panelx = framex - 10;
		panely = framey - 30;
			
		int racketwidth = 65;
		int racketheight = 65;

		rackets = new Racket[numPlayers];
		int discSize = 55;
		
		int widthGoal = 5;
		int heightGoal = 60;
		int marginGoalx = 5;
		int marginGoaly = 0;
		

		int widthField = 10;
		int heightField = 10;
		
		int marginFieldx = discSize;
		int marginFieldy = 0;
		
//<<<<<<< HEAD
		int posxGoal, posyGoal;
		
/*=======
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
>>>>>>> FernandoCuidao*/
		
		
		

		
		
		
		fieldLimit = new FieldLimit[4];
		widthField = panelx;
		top = 0;
		botton = panely - discSize;
		left = discSize;
		rigth = panelx - discSize;
		
		widthField = 10;
		heightField = panely;
		fieldLimit[0] = new FieldLimit(left, top, widthField, heightField);
		fieldLimit[1] = new FieldLimit(rigth, top, widthField, heightField); 
		
		widthField = panelx;
		heightField = 10;		
		fieldLimit[2] = new FieldLimit(left, top, widthField, heightField);		
		fieldLimit[3] = new FieldLimit(left, botton, widthField, heightField); 
		
		
		
		goal = new Goal[numPlayers];
		posxGoal = left + 20;
		posyGoal =  panely / 2 - heightGoal / 2;
		goal[0] = new Goal(posxGoal, posyGoal, widthGoal, heightGoal);
		posxGoal = rigth - 20;
		goal[1] = new Goal(posxGoal, posyGoal, widthGoal, heightGoal);

		
		for (int i = 0; i < numPlayers; i++){
			int posx = panelx / 3 * (i + 1) - racketwidth / 2;
			int posy = panely / 2 - racketheight / 2;
			rackets[i] = new Racket(posx, posy, racketwidth, racketheight, top, rigth, botton, left);
		}
		
		
		int posx = panelx / 2 - discSize / 2;
		int posy = panely / 2 - discSize / 2;
		disc = new Disc(posx, posy, discSize, discSize, top, rigth, botton, left);
				
		back = new Background();
		
//		rackets[0].setPos(500,300);
//		rackets[1].setPos(481,271);
//		velocidad = 1000;
		
		frame = new GameFrame(framex, framey, back);
		frame.setController(this);
		
		frame.drawGameObject(rackets[0]);
		frame.drawGameObject(rackets[1]);
		frame.drawGameObject(disc);
		frame.drawGameObject(goal[0]);
		frame.drawGameObject(goal[1]);
		frame.drawGameObject(fieldLimit[0]);
		frame.drawGameObject(fieldLimit[1]);
		frame.drawGameObject(fieldLimit[2]);
		frame.drawGameObject(fieldLimit[3]);

		
//		boolean sigueJuego = false;
		boolean sigueJuego = true;
		do{
			
			movement();
			frame.repaint();
			try {
				Thread.sleep(speedGame);

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
