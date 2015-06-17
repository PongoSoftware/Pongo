package pongo;

import java.awt.event.WindowEvent;

import pongo.physics.Collider;
import PongoGUI.Background;
import PongoGUI.GameFrame;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public class PongoMain {
	
	private static boolean nextGame = true;
	
	GameFrame frame;
	Object2D[] rackets;
	Object2D disc;
	Object2D[] fieldLimit;
	Goal[] goal;
	Background back;
	
	boolean sigueJuego;
	boolean gamePaused = false;
	
	/**
	 * @param numPlayers
	 */
	public PongoMain(int numPlayers){
		
		int top, rigth, middle, botton, left, beginGoal, endGoal;
		int fieldSizex, fieldSizey, framex, framey;
		int racketwidth, racketheight, discSize;
		int widthGoal;
		int widthField, heightField;
		int posxGoal, posxDisc, posyDisc;
		
		int speedGame = 36;
				
		int[][] goalsDisc;
		rackets = new Racket[numPlayers];
		fieldLimit = new FieldLimit[6];
		
		//Tamaño de la ventana
		framex = 800;
		framey = 600;
		//Tamaño del campo.
		fieldSizex = framex - 10;
		fieldSizey = framey - 30;
			
		//Tamaño de la raqueta
		racketwidth = 65;
		racketheight = 65;
		
		//Tamaño del disco
		discSize = 55;		
		
		//Tamaño de porterías y límite del campo
		widthGoal = 5;
		widthField = 10;
		heightField = 10;
		
		widthField = fieldSizex;
		top = 0;
		botton = fieldSizey - discSize;
		left = discSize;
		rigth = fieldSizex - discSize;
		
		widthField = 10;
		heightField = (int) (((botton - top) - discSize * 3 ) / 2) ;
		middle = (int) (top + heightField + discSize * 3) + 1;
		//Creo límites del campo
		fieldLimit[0] = new FieldLimit(left, top, widthField, heightField);
		fieldLimit[1] = new FieldLimit(rigth, top, widthField, heightField);
		fieldLimit[2] = new FieldLimit(left, middle, widthField, heightField); 
		fieldLimit[3] = new FieldLimit(rigth, middle, widthField, heightField); 
		
		beginGoal = top + heightField;
		endGoal = middle;
		
		widthField = fieldSizex;
		heightField = 10;		
		fieldLimit[4] = new FieldLimit(left, top, widthField, heightField);
		fieldLimit[5] = new FieldLimit(left, botton, widthField, heightField); 
		
		
		// Creo porterias
		goal = new Goal[numPlayers];
		posxGoal = left + 20;
		goal[0] = new Goal(posxGoal, beginGoal, widthGoal, endGoal - beginGoal);
		posxGoal = rigth - 20;
		goal[1] = new Goal(posxGoal, beginGoal, widthGoal,endGoal - beginGoal);

		//Creo raquetas
		for (int i = 0; i < numPlayers; i++){
			int posx = fieldSizex / 3 * (i + 1) - racketwidth / 2;
			int posy = (botton - top) / 2 - racketheight / 2;
			rackets[i] = new Racket(posx, posy, racketwidth, racketheight, top, rigth, botton, left);
		}
		
		//Creo disco
		posxDisc =  fieldSizex / 2 - discSize / 2;
		posyDisc = (botton - top)  / 2 - discSize / 2;
		disc = new Disc(posxDisc, posyDisc, discSize, discSize, top, rigth, botton, left);
		((Disc)disc).setController(this);
		int[][] tmpGoalsDisc = {{beginGoal, endGoal, left},{beginGoal, endGoal, rigth}};
		
		goalsDisc = tmpGoalsDisc;
		
		((Disc)disc).setGoal(goalsDisc);
				
		back = new Background();
				
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
		frame.drawGameObject(fieldLimit[4]);
		frame.drawGameObject(fieldLimit[5]);
		
//		boolean sigueJuego = false;
		gamePaused = false;
		sigueJuego = true;
		while(sigueJuego){
			
			movement();
			frame.repaint();
			try {
				Thread.sleep(speedGame);

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				((Mobil) disc).moveAceleration();
				((Mobil) rackets[0]).move();
				((Mobil) rackets[1]).move();
				Collider.checkCollisionList();
			}
		}
	
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numPlayers = 2;
		
		while(nextGame == true){
			System.out.println("Nuevo juego");
			PongoMain pongoMain = new PongoMain(numPlayers);
		}
	}

	
	
	/**
	 * 37 izquierda
	 * 38 arriba
	 * 39 derecha
	 * 40 abajo
	 * @param keyCode
	 */

	/**
	 * @param keyCode
	 */
	public void recieveKeyPressed(int keyCode) {
		
		if(gamePaused == false){
		
			switch(keyCode){
			
			case 37:
				((Racket) rackets[1]).moveKeyX(-1);
				break;
			case 38:
				((Racket) rackets[1]).moveKeyY(-1);
				break;
			case 39:
				((Racket) rackets[1]).moveKeyX(1);
				break;
			case 40:
				((Racket) rackets[1]).moveKeyY(1);
				break;
				
			case 65:
				((Racket) rackets[0]).moveKeyX(-1);
				break;
			case 87:
				((Racket) rackets[0]).moveKeyY(-1);
				break;
			case 68:
				((Racket) rackets[0]).moveKeyX(1);
				break;
			case 83:
				((Racket) rackets[0]).moveKeyY(1);
				break;
				
			}
		}	
			// Para continuar o salir del juego.
		switch(keyCode){
		
		case 13: 
			
			sigueJuego = false;
			nextGame = true;
			break;
			
		case 27:
			
			sigueJuego = false;
			nextGame = false;
			break;
		}
		
		
	}
	
	/**
	 * @param keyCode
	 */
	public void recieveKeyReleased(int keyCode) {
		
		if(gamePaused == false) {
		
			switch(keyCode){
			
			case 37:
				((Racket) rackets[1]).moveKeyX(0);
				break;
			case 38:
				((Racket) rackets[1]).moveKeyY(0);
				break;
			case 39:
				((Racket) rackets[1]).moveKeyX(0);
				break;
			case 40:
				((Racket) rackets[1]).moveKeyY(0);
				break;
				
			case 65:
				((Racket) rackets[0]).moveKeyX(0);
				break;
			case 87:
				((Racket) rackets[0]).moveKeyY(0);
				break;
			case 68:
				((Racket) rackets[0]).moveKeyX(0);
				break;
			case 83:
				((Racket) rackets[0]).moveKeyY(0);
				break;
				
			}
		
		}
	}
	
	/**
	 * 
	 */
	public void movement(){
		
		((Racket)rackets[0]).moveKey(true);
		((Racket)rackets[1]).moveKey(true);
	}

	/**
	 * @param i
	 */
	public void receiveGoal(int i) {
		//Recibe gol: 
		// 0 = porteria izquierda
		// 1 = porteria derecha
		
		if(i == 0){		   
		   frame.scorePlayer1();
		}else if(i == 1){		   
		   frame.scorePlayer2();		   
		}

		((Mobil) disc).reset();
		((Mobil) rackets[0]).reset();
		((Mobil) rackets[1]).reset();
	}
	
	
	/**
	 * @param player
	 */
	public void gameWon(int player){
		
		System.out.println("Ha ganado el Jugador " + player);
		
		System.out.println("Pulsa Enter para seguir jugando, o Escape para salir");
		
		gamePaused = true;
		// Implementar reseteo.
		
	}

}
