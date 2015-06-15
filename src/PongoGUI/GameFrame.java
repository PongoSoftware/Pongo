package PongoGUI;


import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pongo.Object2D;
import pongo.PongoMain;

/**
 * @author fgsebares
 * @version v0.1
 * @since 2015/06/16 *
 */
public class GameFrame extends JFrame {

	// --------------------------------------- Atributos
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] resolution; // 0 es ancho, 1 es alto.
	private Background back;
	
	private JPanel gameArea;
	private PongoMain controller;
	
	private int[] score;
	
	// --------------------------------------- Constructores
	
	/**
	 * @param width
	 * @param height
	 * @param nBack
	 */
	public GameFrame(int width,int height, Background nBack){
	
		setLayout(null);

		resolution = new int [2];
		resolution[0] = width;
		resolution[1] = height;
		
		setSize(resolution[0], resolution[1]);
		
		
		back = nBack;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameArea = new GameField(resolution[0], resolution[1], new BorderLayout(0,0));
		getContentPane().add(gameArea, BorderLayout.CENTER);
				
		score = new int[2];
		score[0] = 0;
		score[1] = 0;		
		
		requestFocus();
		this.addKeyListener(new KeyListener() {

	        @Override
	        public void keyTyped(KeyEvent e) {

	        	 controller.recieveKeyPressed(e.getKeyCode());
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	        	controller.recieveKeyPressed(e.getKeyCode());

	        }

	        @Override
	        public void keyReleased(KeyEvent e) {

	        	controller.recieveKeyReleased(e.getKeyCode());
	        }
	        
	    });
	}
	
	//------------------------------------ Métodos y Funcionalidad
	
	/**
	 * 
	 */
	public void launch(){
		
		setVisible(true);
		
	}
	
	/* (sin Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	public void repaint(){
		
		gameArea.repaint();
		
	}
	
	/**
	 * @param nToDraw
	 */
	public void drawGameObject(Object2D nToDraw){
		
		((GameField)gameArea).draw(nToDraw);
		
	}
	
	/**
	 * @param nToDraw
	 */
	public void drawUI(Object2D nToDraw){
		
		
		
	}
	
	/**
	 * @param nStopDraw
	 */
	public void stopDraw(Object2D nStopDraw){
		
		((GameField)gameArea).stopDraw(nStopDraw);
		
	}	
	
	
	
	/**
	 * 
	 */
	public void scorePlayer1(){
		
		score[0]++;		
		((GameField)gameArea).scorePlayer(score);
		
		
		if(score[0] >= 7){
			
			controller.gameWon(1);
			
		}
		
	}
	
	/**
	 * 
	 */
	public void scorePlayer2(){
		
		score[1]++;		
		((GameField)gameArea).scorePlayer(score);
		
		if(score[1] >= 7){
			
			controller.gameWon(2);
			
		}
		
	}
	
	/**
	 * 
	 */
	public void resetScores(){
		
		((GameField)gameArea).reset();
		
	}

	/**
	 * @param controller
	 */
	public void setController(PongoMain controller) {
		this.controller = controller;		
	}
	
		
	// ------------------------------- Pruebas
	


	
	/**
	 * @return
	 */
	public PongoMain getController(){
		
		return controller;
		
	}
	

}
