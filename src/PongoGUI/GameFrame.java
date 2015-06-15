package PongoGUI;


import pongo.*;
import pongo.physics.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

public class GameFrame extends JFrame {

	// --------------------------------------- Atributos
	
	private int[] resolution; // 0 es ancho, 1 es alto.
	private Background back;
	
	private JPanel gameArea;
	private PongoMain controller;
	
	// --------------------------------------- Constructores
	
	public GameFrame(int width,int height, Background nBack){
	
		setLayout(null);

		resolution = new int [2];
		resolution[0] = width;
		resolution[1] = height;
		
		//setBounds(resolution[0], resolution[1], (resolution[0] * (int)(2f/3f)), resolution[1]);
		
		setSize(resolution[0], resolution[1]);
		
		
		back = nBack;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//gameArea = new GameField((int)(resolution[0] * 2f/3f), (int)(resolution[1] * resolution[1] * 27f/30f));
		gameArea = new GameField(resolution[0], resolution[1], new BorderLayout(0,0));
		getContentPane().add(gameArea, BorderLayout.CENTER);
		
		
		requestFocus();
		this.addKeyListener(new KeyListener() {

	        @Override
	        public void keyTyped(KeyEvent e) {
//	            System.out.println(e.getKeyCode());
	        	 controller.recieveKeyPressed(e.getKeyCode());
	        	// controller.movement();
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
//	            System.out.println(e.getKeyCode());
	        	controller.recieveKeyPressed(e.getKeyCode());
	        //	controller.movement();
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
//	            System.out.println(e.getKeyCode());
	        	controller.recieveKeyReleased(e.getKeyCode());
	        //	controller.movement();
	        }
	        
	    });
	}
	
	//------------------------------------ Métodos y Funcionalidad
	
	public void launch(){
		
		setVisible(true);
		
	}
	
	public void repaint(){
		
		gameArea.repaint();
		
	}
	
	public void drawGameObject(Object2D nToDraw){
		
		((GameField)gameArea).draw(nToDraw);
		
	}
	
	public void drawUI(Object2D nToDraw){
		
		
		
	}
	
	public void stopDraw(Object2D nStopDraw){
		
		((GameField)gameArea).stopDraw(nStopDraw);
		
	}	
	
	
	// ------------------------------- Pruebas
	

	public static void main (String[] args) throws InterruptedException{
		
		
		
	}

	public void setController(PongoMain controller) {
		this.controller = controller;		
	}
	
	

}
