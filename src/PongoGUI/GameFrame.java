package PongoGUI;

import javax.swing.*;

 
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

public class GameFrame extends JFrame {

	
	private int[] resolution; // 0 es ancho, 1 es alto.
	private Background back;
	
	
	
	GameFrame(int width,int height, Background nBack){
	
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
		
	}
	
	public void launch(){
		
		setVisible(true);
		
	}
	
	public void repaint(){
		
		Image draw = back.imageToDraw();
		int[] pos = new int[2];
				
		for(int i = 0; i < toDraw.size(); i++){
			
			pos = toDraw[i].getPosition();			
			draw = toDraw[i].getImage();
			
		}
		
	}
	
	public void drawObject(Object2D nToDraw){
		
		toDraw.Add(nToDraw);
		
	}
	
	public void drawUI(Object2D nToDraw){
		
		
		
	}
	
	public void stopDraw(Object2D nStopDraw){
		
		toDraw.Remove(nStopDraw);
		
	}	
	
}
