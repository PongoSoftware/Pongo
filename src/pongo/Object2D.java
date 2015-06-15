package pongo;

import pongo.physics.Collider;

public abstract class Object2D {

	protected int type; // 0 es círculo, 1 es cuadrado, 2 es triángulo.
	protected int posx; 
	protected int posy;
	protected int width;
	protected int height;

//--------------Costructor------------------

	public Object2D (int esX, int esY, int esAncho, int esAlto){
		posx = esX; 
		posy = esY; 
		width = esAncho;
		height = esAlto;
	}
	
	public Object2D (int esAncho, int esAlto){
		posx = 0;
		posy = 0;
		width = esAncho;
		height = esAlto;
	}
//-----------Setter-&-Getter----------------
	public void setPos(int x, int y){
		posx = x;
		posy = y;
	}
	
	public void setX(int miX){
		posx = miX;
	}
	
	public double getX(){
		return posx;
	}	
	
	public void setY(int miY){
		posy = miY;
	}
	
	public double getY(){
		return posy;
	}
	
	public void setWidth(int miAncho){
		width = miAncho;
	}
		
	public int getWidth(){
		return width;
	}	
	
	public void setHeight(int miAlto){
		height = miAlto;
	}
		
	public double getHeight(){
		return height;
	}
	
	public int getType(){
		return type;
	}
	
// -----------------Métodos-----------------
		
	public int[] getPos (){
		int[] temp = new int[2];
		temp [0] = posx;
		temp [1] = posy;
		return temp;
	}
}
