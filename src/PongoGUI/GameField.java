package PongoGUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import pongo.*;
import pongo.physics.*;

public class GameField extends JPanel { // Area o campo donde se desarrolla el juego

	// ----------------------------------- Atributos
	
	private int[] resolution;
	private List toDraw;
	
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
		
	}
	
	// ------------------------------------ M�todos y funcionalidad
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
//		System.out.println(toDraw.size());
//		System.out.println(toDraw.isEmpty());
		
		if(toDraw.isEmpty() == false){
		
			int[] position;
			int[] size;
			size = new int[2];
			
			for(int i = 0; i < toDraw.size(); i++){
				
				position = ((Object2D) toDraw.get(i)).getPos();
				size[0] =  ((Object2D) toDraw.get(i)).getWidth();
				size[1] =  (int) ((Object2D) toDraw.get(i)).getHeight();				
				
				g.setColor(Color.yellow);
				
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
	
	
	
	
}
