package pongo;

import pongo.physics.Collider;

public abstract class Object2D {

	protected int posx; 
	protected int posy;
	protected int width;
	protected int height;
	protected Collider collider;

//--------------Costructor------------------

	public Object2D (int esX, int esY, int esAncho, int esAlto){
		posx = esX; 
		posy = esY; 
		width = esAncho;
		height = esAlto;
		collider = new Collider();
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	public Object2D (int esAncho, int esAlto){
		posx = 0;
		posy = 0;
		width = esAncho;
		height = esAlto;
	}
//-----------Setter-&-Getter----------------
	public void setX(int miX){
		posx = miX;
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	public double getX(){
		return posx;
	}	
	
	public void setY(int miY){
		posy = miY;
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	public double getY(){
		return posy;
	}
	
	public void setWidth(int miAncho){
			width = miAncho;
			collider.setRectCircle(posx,  posy, width, height);
	}
		
	public int getWidth(){
			return width;
	}	
	
	public void setHeight(int miAlto){
		height = miAlto;
		collider.setRectCircle(posx,  posy, width, height);
	}
		
	public double getHeight(){
		return height;
	}
	
// -----------------Métodos-----------------
		
	public int[] getPos (){
		int[] temp = new int[2];
		temp [0] = posx;
		temp [1] = posy;
		return temp;
	}
}
