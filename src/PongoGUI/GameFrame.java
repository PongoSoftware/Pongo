package PongoGUI;


import pongo.*;
import pongo.intefaces.*;
import pongo.physics.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

public class GameFrame extends JFrame {

	// --------------------------------------- Atributos
	
	private int[] resolution; // 0 es ancho, 1 es alto.
	private Background back;
	
	private JPanel gameArea;
	
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
		
		Background back = new Background();
		
		GameFrame frame = new GameFrame(800, 500, back);
		Object2D circ1 = new Racket(100, 100, 10, 20, 20, 20);
		Object2D circ2 = new Racket(200, 150, 10, 20, 20, 20);
		Object2D circ3 = new Racket(300, 200, 10, 20, 20, 20);
		Object2D circ4 = new Racket(400, 250, 10, 20, 20, 20);
		Object2D circ5 = new Racket(500, 300, 10, 20, 20, 20);
		Object2D circ6 = new Racket(600, 350, 10, 20, 20, 20);
		
		frame.drawGameObject(circ1);
		frame.drawGameObject(circ2);
		frame.drawGameObject(circ3);
		frame.drawGameObject(circ4);
		frame.drawGameObject(circ5);
		frame.drawGameObject(circ6);
		//frame.stopDraw(circ4);
		
		while(true){
			
			frame.repaint();
			
			circ1.SetX((int)circ1.GetX()+1);
			
			Thread.sleep(30);
			
		}
		
	}
	
	

}
