package PongoGUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

public class GameFrame extends JFrame {

	
	private int[] resolution; // 0 es ancho, 1 es alto.
	private Background back;
	
	private GameField gameArea;
	
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
		
		//getContentPane().setBackground(Color.green);
		
		//gameArea = new GameField((int)(resolution[0] * 2f/3f), (int)(resolution[1] * resolution[1] * 27f/30f));
		gameArea = new GameField(resolution[0], resolution[1]);
		getContentPane().add(gameArea);
		
		
	}
	
	public void launch(){
		
		setVisible(true);
		
	}
	
	public void repaint(){
		
	//	Image draw = back.imageToDraw();
		int[] pos = new int[2];
/*				
		for(int i = 0; i < toDraw.size(); i++){
			
			pos = toDraw[i].getPosition();			
			draw = toDraw[i].getImage();
			
		}
*/	
		
	}
	
	public void repaint(boolean prueba){
		
		gameArea.repaint();
		
	}
	
/*	
	public void drawObject(Object2D nToDraw){
		
		toDraw.Add(nToDraw);
		
	}
	
	public void drawUI(Object2D nToDraw){
		
		
		
	}
	
	public void stopDraw(Object2D nStopDraw){
		
		toDraw.Remove(nStopDraw);
		
	}	

*/
	
	public static void main (String[] args) throws InterruptedException{
		
		Background back = new Background();
		
		GameFrame frame = new GameFrame(800, 300, back);
		
		while(true){
			
			frame.repaint(true);
			
			Thread.sleep(100);
			
		}
		
	}

}
