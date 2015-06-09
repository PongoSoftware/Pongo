package PongoGUI;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JPanel { // Area o campo donde se desarrolla el juego

	private int[] resolution;
	private List toDraw;
	
	GameField(int width, int height){
		
		resolution = new int [2];
		
		resolution[0] = width;
		resolution[1] = height;
		
		toDraw = new ArrayList();
		setSize(resolution[0], resolution[1]);
		setVisible(true);	
		
		setBackground(Color.RED);
		
	}
	
	public void repaint(Graphics g){
		
/*		int[] position;
		
		for(int i = 0; i < toDraw.size(); i++){
			
			position = toDraw[i].getPosition();
			
		}
*/
		g.setColor(Color.yellow);
		g.fillOval(100, 200, 100, 100);
		g.fillRect(0, 0, 300, 100);
		
	}
	
	public void draw(Image nToDraw){
		
		toDraw.add(nToDraw);
		
	}
	
	public void stopDraw(Image nStopDraw){
		
		toDraw.remove(nStopDraw);
		
	}
	
	
	
	
}
