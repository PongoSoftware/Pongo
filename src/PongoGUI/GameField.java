package PongoGUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JPanel { // Area o campo donde se desarrolla el juego

	private int[] resolution;
	private List toDraw;
	
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
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
/*		int[] position;
		
		for(int i = 0; i < toDraw.size(); i++){
			
			position = toDraw[i].getPosition();
			
		}
*/
		g.setColor(Color.yellow);
		g.fillOval(500, 100, 100, 100);
		
	}
	
	public void draw(Image nToDraw){
		
		toDraw.add(nToDraw);
		
	}
	
	public void stopDraw(Image nStopDraw){
		
		toDraw.remove(nStopDraw);
		
	}
	
	
	
	
}
