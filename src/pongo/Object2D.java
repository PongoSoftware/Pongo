package pongo;

import java.awt.Color;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public abstract class Object2D {

	protected int type; // 0 es círculo, 1 es cuadrado, 2 es triángulo.
	protected int posx; 
	protected int posy;
	protected int width;
	protected int height;

	protected Color color;
	
//--------------Costructor------------------

	/**
	 * @param esX
	 * @param esY
	 * @param esAncho
	 * @param esAlto
	 */
	public Object2D (int esX, int esY, int esAncho, int esAlto){
		posx = esX; 
		posy = esY; 
		width = esAncho;
		height = esAlto;
		color = Color.YELLOW;
	}
	
	/**
	 * @param esX
	 * @param esY
	 * @param esAncho
	 * @param esAlto
	 * @param nColor
	 */
	public Object2D (int esX, int esY, int esAncho, int esAlto, Color nColor){
		posx = esX; 
		posy = esY; 
		width = esAncho;
		height = esAlto;
		color = nColor;
	}

	
	/**
	 * @param esAncho
	 * @param esAlto
	 */
	public Object2D (int esAncho, int esAlto){
		posx = 0;
		posy = 0;
		width = esAncho;
		height = esAlto;
	}
//-----------Setter-&-Getter----------------
	/**
	 * @param x
	 * @param y
	 */
	public void setPos(int x, int y){
		posx = x;
		posy = y;
	}
	
	/**
	 * @param miX
	 */
	public void setX(int miX){
		posx = miX;
	}
	
	/**
	 * @return
	 */
	public double getX(){
		return posx;
	}	
	
	/**
	 * @param miY
	 */
	public void setY(int miY){
		posy = miY;
	}
	
	/**
	 * @return
	 */
	public double getY(){
		return posy;
	}
	
	/**
	 * @param miAncho
	 */
	public void setWidth(int miAncho){
		width = miAncho;
	}
		
	/**
	 * @return
	 */
	public int getWidth(){
		return width;
	}	
	
	/**
	 * @param miAlto
	 */
	public void setHeight(int miAlto){
		height = miAlto;
	}
		
	/**
	 * @return
	 */
	public double getHeight(){
		return height;
	}
	
	/**
	 * @return
	 */
	public int getType(){
		return type;
	}
	
	/**
	 * @return
	 */
	public Color getColor(){
		
		return color;
		
	}
	
	/**
	 * @return
	 */
	public int[] getPos (){
		int[] temp = new int[2];
		temp [0] = posx;
		temp [1] = posy;
		return temp;
	}
	
	
}
