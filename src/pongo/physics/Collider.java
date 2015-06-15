package pongo.physics;

import java.util.ArrayList;
import java.util.Iterator;

import pongo.Mobil;
import pongo.Mobil;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public class Collider{

	Mobil object;
	int centerx, centery, initx, inity, endx, endy, radius;
	/**
	 * 
	 */
	static ArrayList<Collider> listCollider = new ArrayList();
	
	/**
	 * @param obj
	 */
	public Collider(Mobil obj){
		radius = -1;
		object = obj;
		listCollider.add(this);
	}
		
	/**
	 * @param centerx
	 * @param centery
	 * @param radius
	 */
	public void setCircle(int centerx, int centery, int radius){
		this.centerx = centerx;
		this.centery = centery;
		this.radius = radius;
		calcRect();
	}
	
	/**
	 * 
	 */
	private void calcRect(){
		initx = centerx - radius;
		inity = centery - radius;
		endx = centerx + radius;
		endy = centery + radius;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setRect(int x, int y, int width, int height){
		initx = x;
		inity = y;
		endx = x + width;
		endy = y + height;
		radius = -1;
		calcCenter();
	}
	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setRectCircle(int x, int y, int width, int height){
		setRect(x,y,width,height);
		setIsCircle();
	}
	
	/**
	 * 
	 */
	public void setIsCircle(){
		calcCircle();
	}
	
	//Unused
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	private void calcCircle(int x, int y, int width, int height){
		setRect(x,y,width,height);
	}

	/**
	 * 
	 */
	public void calcCircle(){
		if (initx >= inity) {
			radius = (endx - initx) / 2;
		} else {
			radius = (endy - inity) / 2;
		}
		
		calcCenter();
	}
	
	/**
	 * 
	 */
	private void calcCenter(){
		centerx = initx + (endx - initx) / 2; 
		centery = inity + (endy - inity) / 2; 
	}
	
	/**
	 * 
	 */
	public static void checkCollisionList(){ //Check collision of all collider.
		for (int i = 0; i < listCollider.size(); i++){
			for (int k = i+1; k < listCollider.size(); k++){
				boolean col = listCollider.get(i).checkCollision(listCollider.get(k));
			}
		}
	}
	
	/**
	 * @param collider
	 * @return
	 */
	private boolean checkCollision(Collider collider){
		boolean hasCollision = false;
		int colInitx, colEndx, colInity, colEndy;
		colInitx = collider.getInitx();
		colEndx = collider.getEndx();
		colInity = collider.getInity();
		colEndy = collider.getEndy();
		
		//NOTA: Radio se inicializa a -1 si es un cuadrado
		
		//Si hay colisiones en los ejes
		if ( checkCollisionEje(initx, endx, colInitx,colEndx) && 
				checkCollisionEje(inity, endy, colInity, colEndy) ){

			//Calcular si ambos son cuadrados:
			if (radius > 0 && collider.getRadius() > 0 ){ //No son dos cadrados
				//Comprobar si son dos circulos o dos figuras distintas
				if(!(radius > 0) && !(collider.getRadius() > 0)) { //No son dos circulos (cuadrado y circulo).
					//CIRCULO Y CUADRADO
					

//					System.out.println("Un cuadrado y un circulo");
					
					//Si la mitad de la longitud del lado del cuadrado más el radio es mayor que la distancia, 
					//no hay colision
					// (Se omite con comprobación anterior)
					
					//¿El primero es un cuadrado o un circulo? Se pondrán los parametros en otro orden.
					if (radius < 0) { //El primero es un cuadrado
//						System.out.println("el primero es un cuadrado");
						hasCollision = checkColisionRectCircle(
							centerx, centery, initx, endx, inity, endy, 
							collider.getCenterx(), collider.getCentery(), collider.getRadius());
					} else {
//						System.out.println("el primero es un circulo");
						hasCollision = checkColisionRectCircle(
							collider.getCenterx(), collider.getCentery(), collider.getInitx(), collider.getEndx(),
								collider.getInity(), collider.getEndy(),
							centerx, centery, radius);
					}
					
					
				} else { //Son dos circulos
					//SON DOS CIRCULOS
//					System.out.println("Son dos circulos");
					if(checkCollisionCircle(this.object, collider.object,
							centerx, centery, radius, 
							collider.getCenterx(), collider.getCentery(), collider.getRadius()))
					{
						hasCollision = true;
					}
				}
			} else { //Son dos cuadrados
				//SON DOS CUADRADOS
//				System.out.println("Son dos cuadrados");
				hasCollision = true;
			}
		}    
		return hasCollision;
	}

	/**
	 * @param a1
	 * @param a2
	 * @param b1
	 * @param b2
	 * @return
	 */
	private boolean checkCollisionEje(int a1, int a2, int b1, int b2){
        if ( 
                ((b1 >= a1) && (b1 <= a2)) ||
                ((a1 >= b1) && (a1 <= b2)) ||
                ((a2 >= b1) && (a2 <= b2)) ||
                ((b2 >= a1) && (b2 <= a2))
        ){
            // HAY INTERECCION
            return true;
        } else {
            //no la hay
            return false;
             
        }		
	}
	
	/**
	 * @param object
	 * @param object2
	 * @param centerx
	 * @param centery
	 * @param radius
	 * @param colCenterx
	 * @param colCentery
	 * @param colRadius
	 * @return
	 */
	private boolean checkCollisionCircle(Mobil object, Mobil object2, int centerx, int centery,
			int radius, int colCenterx, int colCentery, int colRadius) {
		int distance = Utils.calcDistance(centerx, centery, colCenterx, colCentery);
		if (distance <= (radius + colRadius)){
			Reactions.circles(object,object2);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param centerx
	 * @param centery
	 * @param initx
	 * @param endx
	 * @param inity
	 * @param endy
	 * @param colCenterx
	 * @param colCentery
	 * @param colRadius
	 * @return
	 */
	private boolean checkColisionRectCircle(
			int centerx, int centery, int initx, int endx, int inity, int endy, //El primero es un cuadrado
			int colCenterx, int colCentery, int colRadius){ //El segundo es un circulo
		
		int distancex = centerx - colCenterx;
		int distancey = centery - colCentery;
		
		int lengthx = endx - initx;
		int lengthy = endy - inity;
		int calc = (int) (Math.pow(lengthx,2) +  Math.pow(lengthy,2));
						
		int hipotenuse = (int) Math.sqrt(calc);
		
		if (hipotenuse <= colRadius) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return
	 */
	public int getCenterx() {
		return centerx;
	}

	/**
	 * @return
	 */
	public int getCentery() {
		return centery;
	}

	/**
	 * @return
	 */
	public int getInitx() {
		return initx;
	}

	/**
	 * @return
	 */
	public int getInity() {
		return inity;
	}

	/**
	 * @return
	 */
	public int getEndx() {
		return endx;
	}

	/**
	 * @return
	 */
	public int getEndy() {
		return endy;
	}

	/**
	 * @return
	 */
	public int getRadius() {
		return radius;
	}

}
