package PongoGUI;


import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pongo.Object2D;
import pongo.PongoMain;

/**
 * @author fgsebares
 * @version v0.1
 * @since 2015/06/16 *
 */
public class GameFrame extends JFrame {
	
	// La clase GameFrame se encarga de gestionar los elementos que compondrán la ventana.

	// --------------------------------------- Atributos
	
	/**
	 * En principio Background supone una posibilidad de amplición para utilizar
	 * más especializado que un simple color de fondo.
	 */
	private static final long serialVersionUID = 1L;
	private int[] resolution; // La posición 0 es ancho, 1 es alto.
	private Background back; // 
	
	private JPanel gameArea; // Esta clase hereda de Panel y contiene la representeación gráfica de los elementos.
	private PongoMain controller; // Es una referencia a la clase maestra. 
	
	private int[] score; // Puntuación que se mostrará por pantalla.
	
	// --------------------------------------- Constructores
	
	/**
	 * @param width
	 * @param height
	 * @param nBack
	 */
	public GameFrame(int width,int height, Background nBack){
	
		// Todos los elementos a continuación pertenecen a la inicialización por defecto de los elementos 
		// que componen el JFrame.
		
		setLayout(null);

		resolution = new int [2];
		resolution[0] = width;
		resolution[1] = height;
		
		setSize(resolution[0], resolution[1]);
		
		
		back = nBack;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// A partir de aquí se añade el panel que servirá de contenedor o canvas para los elementos visuales.
		
		gameArea = new GameField(resolution[0], resolution[1], new BorderLayout(0,0));
		getContentPane().add(gameArea, BorderLayout.CENTER);
				
		score = new int[2];
		score[0] = 0;
		score[1] = 0;		
		
		// Dado que JSwing incorpora un sistema de escucha por teclado, a continuación registramos
		// los tres eventos que nos interesan con respecto al input, que son presionar la tecla, mantenerla pulsada,
		// y liberarla. Lo primero activará el movimiento y actualizará la dirección, lo segundo mantendrá activo
		// el movimiento, y al liberarla se vuelven a actualizar los valores y se detiene el movimiento.
		
		requestFocus();
		this.addKeyListener(new KeyListener() {

	        @Override
	        public void keyTyped(KeyEvent e) {

	        	 controller.recieveKeyPressed(e.getKeyCode());
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	        	controller.recieveKeyPressed(e.getKeyCode());

	        }

	        @Override
	        public void keyReleased(KeyEvent e) {

	        	controller.recieveKeyReleased(e.getKeyCode());
	        }
	        
	    });
	}
	
	//------------------------------------ Métodos y Funcionalidad
	
	/**
	 * 
	 */
	public void launch(){
		
		setVisible(true);
		
	}
	
	/* (sin Javadoc)
	 * 
	 * Este método es importante ya que se encarga de repintar la escena llamando a dicho 
	 * método perteneciente al panel. La llamada corresponde por tanto a un fotograma.
	 * 	
	 * @see java.awt.Component#repaint()
	 */
	
	
	
	public void repaint(){
		
		gameArea.repaint();
		
	}
	
	/* 
	 * Los métodos drawGameObject y stopDraw se encargan de añadir y eliminar los
	 * elementos que deben dibujarse de la lista que los almacena.
	 * 
	 * @param nToDraw
	 */
	public void drawGameObject(Object2D nToDraw){
		
		((GameField)gameArea).draw(nToDraw);
		
	}

	/**
	 * 
	 * @param nStopDraw
	 */
	public void stopDraw(Object2D nStopDraw){
		
		((GameField)gameArea).stopDraw(nStopDraw);
		
	}	
	
	
	
	/**
	 * 
	 * Las dos versiones de scorePlayer se encargan de ir actualizando la puntuación
	 * en función a quién marca el tanto. Controlan además si se ha alcanzado el valor
	 * máximo que otorga la victoria, llamando a su vez al correspondiente método de 
	 * partida ganada.
	 * 
	 */
	public void scorePlayer1(){
		
		score[0]++;		
		((GameField)gameArea).scorePlayer(score);
		
		
		if(score[0] >= 7){
			
			controller.gameWon(1);
			
		}
		
	}
	
	/**
	 * 
	 */
	public void scorePlayer2(){
		
		score[1]++;		
		((GameField)gameArea).scorePlayer(score);
		
		if(score[1] >= 7){
			
			controller.gameWon(2);
			
		}
		
	}
	
	/**
	 * resetScores se encarga de resetear la puntuación en caso de ser necesario.
	 * 
	 */
	public void resetScores(){
		
		((GameField)gameArea).reset();
		
	}

	/**
	 * @param controller
	 */
	public void setController(PongoMain controller) {
		this.controller = controller;		
	}
	
		
	// ------------------------------- Pruebas
	


	
	/**
	 * @return
	 */
	public PongoMain getController(){
		
		return controller;
		
	}
	

}
