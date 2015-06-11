package pongo.physics;

import java.util.ArrayList;
import java.util.Iterator;

public class Collider{

	int centerx, centery, initx, inity, endx, endy, radius;
	static ArrayList<Collider> listCollider = new ArrayList();
	
	public Collider(){
		radius = -1;
		listCollider.add(this);
	}
		
	public void setCircle(int centerx, int centery, int radius){
		this.centerx = centerx;
		this.centery = centery;
		this.radius = radius;
		calcRect();
	}
	
	private void calcRect(){
		initx = centerx - radius;
		inity = centery - radius;
		endx = centerx + radius;
		endy = centery + radius;
	}
	
	public void setRect(int x, int y, int width, int height){
		initx = x;
		inity = y;
		endx = x + width;
		endy = y + height;
		radius = -1;
		calcCenter();
	}
	
	public void setRectCircle(int x, int y, int width, int height){
		setRect(x,y,width,height);
		setIsCircle();
	}
	
	public void setIsCircle(){
		calcCircle();
	}
	
	//Unused
	private void calcCircle(int x, int y, int width, int height){
		setRect(x,y,width,height);
	}

	public void calcCircle(){
		if (initx >= inity) {
			radius = (endx - initx) / 2;
		} else {
			radius = (endy - inity) / 2;
		}
		
		calcCenter();
	}
	
	private void calcCenter(){
		centerx = initx + (endx - initx) / 2; 
		centery = inity + (endy - inity) / 2; 
	}
	
	public static void checkCollisionList(){ //Check collision of all collider.
		for (int i = 0; i < listCollider.size(); i++){
			for (int k = i+1; k < listCollider.size(); k++){
				boolean col = listCollider.get(i).checkCollision(listCollider.get(k));
//				System.out.println(col);
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
					
					//Si la mitad de la longitud del lado del cuadrado m�s el radio es mayor que la distancia, 
					//no hay colision
					// (Se omite con comprobaci�n anterior)
					
					//�El primero es un cuadrado o un circulo? Se pondr�n los parametros en otro orden.
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
					if(checkCollisionCircle(centerx, centery, radius, 
							collider.getCenterx(), collider.getCentery(), collider.getRadius())){
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
		int distance = calcularDistancia(centerx,centery,colCenterx,colCentery);
		
		if (distance <= (radius + colRadius)){
			return true;
		} else {
			return false;
		}
	}
	
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
	
	private int calcularDistancia(int centerx, int centery, int colCenterx, int colCentery){
		int sum1 = colCenterx - centerx ; 
		int sum2 = colCentery - centery ;
		double square = (Math.pow(sum1, 2) + Math.pow(sum2, 2));
		int distance = (int) Math.sqrt(square);
		return distance;
	}

	
	public int getCenterx() {
		return centerx;
	}

//	public void setCenterx(int centerx) {
//		this.centerx = centerx;
//	}

	public int getCentery() {
		return centery;
	}

//	public void setCentery(int centery) {
//		this.centery = centery;
//	}

	public int getInitx() {
		return initx;
	}

//	public void setInitx(int initx) {
//		this.initx = initx;
//	}

	public int getInity() {
		return inity;
	}

//	public void setInity(int inity) {
//		this.inity = inity;
//	}

	public int getEndx() {
		return endx;
	}

//	public void setEndx(int endx) {
//		this.endx = endx;
//	}

	public int getEndy() {
		return endy;
	}

//	public void setEndy(int endy) {
//		this.endy = endy;
//	}

	public int getRadius() {
		return radius;
	}

//	public void setRadius(int radius) {
//		this.radius = radius;
//	}
}
