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
	
	// La clase GameFrame se encarga de gestionar los elementos que compondr�n la ventana.

	// --------------------------------------- Atributos
	
	/**
	 * En principio Background supone una posibilidad de amplici�n para utilizar
	 * m�s especializado que un simple color de fondo.
	 */
	private static final long serialVersionUID = 1L;
	private int[] resolution; // La posici�n 0 es ancho, 1 es alto.
	private Background back; // 
	
	private JPanel gameArea; // Esta clase hereda de Panel y contiene la representeaci�n gr�fica de los elementos.
	private PongoMain controller; // Es una referencia a la clase maestra. 
	
	private int[] score; // Puntuaci�n que se mostrar� por pantalla.
	
	// --------------------------------------- Constructores
	
	/**
	 * @param width
	 * @param height
	 * @param nBack
	 */
	public GameFrame(int width,int height, Background nBack){
	
		// Todos los elementos a continuaci�n pertenecen a la inicializaci�n por defecto de los elementos 
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
		
		// A partir de aqu� se a�ade el panel que servir� de contenedor o canvas para los elementos visuales.
		
		gameArea = new GameField(resolution[0], resolution[1], new BorderLayout(0,0));
		getContentPane().add(gameArea, BorderLayout.CENTER);
				
		score = new int[2];
		score[0] = 0;
		score[1] = 0;		
		
		// Dado que JSwing incorpora un sistema de escucha por teclado, a continuaci�n registramos
		// los tres eventos que nos interesan con respecto al input, que son presionar la tecla, mantenerla pulsada,
		// y liberarla. Lo primero activar� el movimiento y actualizar� la direcci�n, lo segundo mantendr� activo
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
	
	//------------------------------------ M�todos y Funcionalidad
	
	/**
	 * 
	 */
	public void launch(){
		
		setVisible(true);
		
	}
	
	/* (sin Javadoc)
	 * 
	 * Este m�todo es importante ya que se encarga de repintar la escena llamando a dicho 
	 * m�todo perteneciente al panel. La llamada corresponde por tanto a un fotograma.
	 * 	
	 * @see java.awt.Component#repaint()
	 */
	
	
	
	public void repaint(){
		
		gameArea.repaint();
		
	}
	
	/* 
	 * Los m�todos drawGameObject y stopDraw se encargan de a�adir y eliminar los
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
	 * Las dos versiones de scorePlayer se encargan de ir actualizando la puntuaci�n
	 * en funci�n a qui�n marca el tanto. Controlan adem�s si se ha alcanzado el valor
	 * m�ximo que otorga la victoria, llamando a su vez al correspondiente m�todo de 
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
	 * resetScores se encarga de resetear la puntuaci�n en caso de ser necesario.
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
