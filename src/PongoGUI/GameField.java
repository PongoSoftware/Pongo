package PongoGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import pongo.Object2D;

/**
 * @author fgsebares
 * @version v0.1
 * @since 2015/06/16 *
 */
public class GameField extends JPanel { // Area o campo donde se desarrolla el juego

	// ----------------------------------- Atributos
	
	/**
	 * 
	 * La lista toDraw almacena todos los objetos de tipo Object2D que deben
	 * dibujarse en la escena.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] resolution;
	private List toDraw;
	
	private int[] score;
	
	// ----------------------------------- Constructores
	
	/**
	 * @param width
	 * @param height
	 * @param border
	 */
	GameField(int width, int height, BorderLayout border){
		
		super(border);
		
		resolution = new int [2];
		
		resolution[0] = width;
		resolution[1] = height;
		
		toDraw = new ArrayList();
		setSize(resolution[0], resolution[1]);
		setVisible(true);	
		
		setBackground(Color.RED);
		
		score = new int[2];
		score[0] = 0;
		score[1] = 0;
		
	}
	
	// ------------------------------------ Métodos y funcionalidad
	
	/* 
	 * Este método es llamado automáticamente cuando se utiliza repaint(), y se encarga de 
	 * recorrer la lista de elementos a dibujar, extrayendo su información (color, posición, 
	 * tipo de figura...).
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		Font f = new  Font ("SansSerif", Font.BOLD, 200); 
        g2.setFont(f);
        g2.setColor(Color.PINK);
		g2.drawString((score[0] + " - " + score[1]), 200, 350);
		
		if(toDraw.isEmpty() == false){
		
			int[] position;
			int[] size;
			size = new int[2];
			
			for(int i = 0; i < toDraw.size(); i++){
				
				position = ((Object2D) toDraw.get(i)).getPos();
				size[0] =  ((Object2D) toDraw.get(i)).getWidth();
				size[1] =  (int) ((Object2D) toDraw.get(i)).getHeight();				
				
				g.setColor(((Object2D)toDraw.get(i)).getColor());
				
				int type = ((Object2D)toDraw.get(i)).getType();
				
				switch(type){
				
				case 0:
					
					g.fillOval(position[0], position[1], size[0], size[1]);
					break;
					
				case 1:
					
					g.fillRect(position[0], position[1], size[0], size[1]);
					break;
					
				case 2:
					
					break;				
					
				}
			}
		}
	}
	
	/**
	 * @param nToDraw
	 */
	public void draw(Object2D nToDraw){
		
		toDraw.add(nToDraw);
		
	}
	
	/**
	 * @param nStopDraw
	 */
	public void stopDraw(Object2D nStopDraw){
		
		toDraw.remove(nStopDraw);
		
	}
	
	/**
	 * @param play
	 */
	public void scorePlayer(int[] play){
		
		score = play;
		
	}
	
	/**
	 * 
	 */
	public void reset(){
		
		score[0] = 0;
		score[1] = 0;
				
	}
	
	
	
	
}
