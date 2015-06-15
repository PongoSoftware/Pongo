package PongoGUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import pongo.*;
import pongo.physics.*;

public class GameField extends JPanel { // Area o campo donde se desarrolla el juego

	// ----------------------------------- Atributos
	
	private int[] resolution;
	private List toDraw;
	
	private int[] score;
	
	// ----------------------------------- Constructores
	
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
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
//		System.out.println(toDraw.size());
//		System.out.println(toDraw.isEmpty());
		
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
	
	public void draw(Object2D nToDraw){
		
		toDraw.add(nToDraw);
		
	}
	
	public void stopDraw(Object2D nStopDraw){
		
		toDraw.remove(nStopDraw);
		
	}
	
	public void scorePlayer(int play){
		
		score[play]++;
		
	}
	
	public void reset(){
		
		score[0] = 0;
		score[1] = 0;
				
	}
	
	
	
	
}
