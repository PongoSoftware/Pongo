package pongo.phisics;

import java.util.ArrayList;
import java.util.Iterator;

public class Collider{

	int centerx, centery, initx, inity, endx, endy, radius, diameter;
	static ArrayList<Collider> listCollider;
	
	public Collider(){
		listCollider.add(this);
		diameter = -1;
		radius = -1;
	}
	
	public void setCircle(int centerx, int centery, int radius){
		this.centerx = centerx;
		this.centery = centery;
		this.radius = radius;
		calcRect();
	}
	
	private void callRect(int centerx, int centery, int radius){
//		setCircle(centerx, centery,radius);
	}
	
	private void calcRect(){
		initx = centerx - radius;
		inity = centery - radius;
		endx = centerx + radius;
		endy = centery + radius;
	}
	
	public void setRect(int x, int y, int w, int h){
		initx = x;
		inity = x;
		endx = x + w;
		endy = x + h;
		callCenter();
	}
	
	//Unused
	private void calcCircle(int x, int y, int w, int h){
		setRect(x,y,w,h);
	}
	//unused
	private void calcCircle(){
		if (initx > inity) {
			radius = inity;
		} else {
			radius = inity;
		}
		
		callCenter();
	}
	
	private void callCenter(){
		centerx = initx + (endx - initx) / 2; 
		centery = inity + (endy - inity) / 2; 
	}
	
	public static void checkCollision(){ //Check collision of all collider.
		for (int i = 0; i < listCollider.size(); i++){
			for (int k = i; i < listCollider.size(); k++){
				listCollider.get(i).checkCollision(listCollider.get(k));
			}
		}
	}
	
	private boolean checkCollision(Collider collider){
		boolean hasCollision = false;
		int colInitx, colEndx, colInity, colEndy;
		colInitx = collider.getInitx();
		colEndx = collider.getEndx();
		colInity = collider.getInity();
		colEndy = collider.getEndy();
		
		//Si hay colisiones en los ejes
		if ( checkCollisionEje(initx, endx, colInitx,colEndx) && checkCollisionEje(inity, endy, colInity, colEndy) ){
			//Calcular si ambos son cuadrados:
			if (diameter < 0 && collider.getDiameter() < 0 ){ //No son dos cadrados
				//Comprobar si son dos circulos o dos figuras distintas
				if(radius < 0 && collider.getRadius() < 0) { //No son dos circulos (cuadrado y circulo).
					//Si la mitad de la longitud del lado del cuadrado más el radio es mayor que la distancia, 
					//no hay colision
					// (Se omite con comprobación anterior)
					
					//¿El primero es un cuadrado o un circulo? Se pondrán los parametros en otro orden.
					if (radius < 0) { //El primero es un cuadrado
						hasCollision = checkColisionRectCircle(
							centerx, centery, initx, endx, inity, endy, 
							collider.getCenterx(), collider.getCentery(), collider.getRadius());
					} else {
						hasCollision = checkColisionRectCircle(
							collider.getCenterx(), collider.getCentery(), collider.getInitx(), collider.getEndx(),
								collider.getInity(), collider.getEndy(),
							centerx, centery, radius);
					}
					
					
				} else { //Son dos circulos
					if(checkCollisionCircle(centerx, centery, radius, 
							collider.getCenterx(), collider.getCentery(), collider.getRadius())){
						hasCollision = true;
					}
				}
			} else { //Son dos cuadrados
				hasCollision = true;
			}
		}    
		
		return hasCollision;
	}

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
	
	private boolean checkCollisionCircle(int centerx, int centery,
			int radius, int colCenterx, int colCentery, int colRadius) {

		int distancia = calcularDistancia(centerx,centery,colCenterx,colCentery);
		
		if (distancia <= (radius + colRadius)){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkColisionRectCircle(
			int centerx, int centery, int initx, int endx, int inity, int endy, //El primero es un cuadrado
			int colCenterx, int colCentery, int colRadius){ //El segundo es un circulo
		
		int distanciax = centerx - colCenterx;
		int distanciay = centery - colCentery;
		
		int lengthx = endx - initx;
		int lengthy = endy - inity;
		int calcular = (int) (Math.pow(lengthx,2) +  Math.pow(lengthy,2));
						
		int hipotenusa = (int) Math.sqrt(calcular);
		
		if (hipotenusa <= colRadius) {
			return true;
		} else {
			return false;
		}
	}
	
	private int calcularDistancia(int centerx, int centery, int colCenterx, int colCentery){
		int suma1 = centerx - colCentery; 
		int suma2 = centery - colCentery;
		double cuadrado = (Math.pow(suma1, 2) + Math.pow(suma2, 2));
		int distancia = (int) Math.sqrt(cuadrado);
		return distancia;
	}

	
	public int getCenterx() {
		return centerx;
	}

	public void setCenterx(int centerx) {
		this.centerx = centerx;
	}

	public int getCentery() {
		return centery;
	}

	public void setCentery(int centery) {
		this.centery = centery;
	}

	public int getInitx() {
		return initx;
	}

	public void setInitx(int initx) {
		this.initx = initx;
	}

	public int getInity() {
		return inity;
	}

	public void setInity(int inity) {
		this.inity = inity;
	}

	public int getEndx() {
		return endx;
	}

	public void setEndx(int endx) {
		this.endx = endx;
	}

	public int getEndy() {
		return endy;
	}

	public void setEndy(int endy) {
		this.endy = endy;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
}
