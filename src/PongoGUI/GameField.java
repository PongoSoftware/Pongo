package PongoGUI;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JPanel { // Area o campo donde se desarrolla el juego

	private int[] resolution;
	private List toDraw;
	
	GameField(){
		
		toDraw = new ArrayList();
		setSize(resolution[0], resolution[1]);
		setVisible(true);
		
	}
	
	public void repaint(){
		
		int[] position;
		
		for(int i = 0; i < toDraw.size(); i++){
			
			position = toDraw[i].getPosition();
			
		}
		
	}
	
	public void draw(Image nToDraw){
		
		toDraw.add(nToDraw);
		
	}
	
	public void stopDraw(Image nStopDraw){
		
		toDraw.remove(nStopDraw);
		
	}
	
	
	
	
}
