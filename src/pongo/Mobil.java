package pongo;

import pongo.physics.Collider;

public abstract class Mobil extends Object2D {

	protected double speedX, speedY;
	protected int acelerationx;
	protected int acelerationy;
	protected int top,rigth,botton,left;
	protected Collider collider;
	protected boolean receiveCollision = false;
	protected double power;
	protected double aceleration, acelerationX, acelerationY;
	
	//---------------Constructor---------------

	public Mobil(int esX, int esY, int esAncho,
			int esAlto, int top, int rigth, int botton, int left) {
		super(esX, esY, esAncho, esAlto);
		this.top = top;
		this.rigth = rigth;
		this.botton = botton;
		this.left = left;
		collider = new Collider(this);
		collider.setRectCircle(posx,  posy, width, height);
		aceleration = 0;
	}
	
	public int getAcelerationx() {
		return acelerationx;
	}


	public void setAcelerationx(int acelerationx) {
		this.acelerationx = acelerationx;
	}


	public int getAcelerationy() {
		return acelerationy;
	}


	public void setAcelerationy(int acelerationy) {
		this.acelerationy = acelerationy;
	}


	
	

//-----------------Métodos-----------------

	
	
//-------------Setter-&-Getter-------------
	
	public void setSpeedX(int miSpeedX){
		speedX = miSpeedX;
	}
		
	public double setSpeedX(){
		return speedX;
	}
	
	public void setSpeedY(int miSpeedY){
		speedY = miSpeedY;
	}
		
	public double getSpeedX() {
		return speedX;
	}

	public double getSpeedY(){
		return speedY;
	}

	public void setSpeed(int x, int y) {
		speedX = x;
		speedY = y;		
	}
	
	@Override
	public void setPos(int x, int y){
		posx = x;
		posy = y;
		collider.setRectCircle(posx,  posy, width, height);
	}
	public void limitMove(){
		if ((posx  ) < left ) {
			speedX = speedX * -1;
			posx = left;
		} else if ((posx + width) > rigth){
			speedX = speedX * -1;
			posx = rigth - width;
		}
		if ((posy) < top ) {
			speedY = speedY * -1;
			posy = top;
		}else if ((posy + height) > botton){
			speedY = speedY * -1;
			posy = botton - height;
		}
	}
	
	public void aceleration(){		
		double acePos = Math.abs(aceleration); 
		double aceNeg = acePos * -1;
//		System.out.println(acePos+"_"+aceNeg);
		
		if (speedX > 0){
			acelerationX = aceNeg;
		} else if (speedX < 0){
			acelerationX = acePos;
		} else {
			acelerationX = 0;
		}
		
		if (speedY > 0){
			acelerationY = aceNeg;
		} else if (speedY < 0) {
			acelerationY = acePos;
		}else {
			acelerationY = 0;
		}

//		System.out.println(acelerationX);
		
		speedX += acelerationX / 2d;
		speedY += acelerationY / 2d;
		
//		System.out.println(speedX);
	}
	
	public void speedMove(){
		int limit = 30;
		int limitNeg = limit * -1;
		if (speedX > limit ) {
			speedX = limit;
		} else if (speedX < limitNeg){
			speedX = limitNeg;
		}
		if (speedY > limit ) {
			speedY = limit;
		} else if (speedY < limitNeg){
			speedY = limitNeg;
		}
		posx += speedX;
		posy += speedY;
	}
	
	public void move(){
		limitMove();
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	public void moveAceleration(){
		aceleration();
		speedMove();
		limitMove();
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	
	@Override
	public void setX(int miX){
		posx = miX;
		collider.setRectCircle(posx,  posy, width, height);
	}

	@Override
	public void setY(int miY){
		posy = miY;
		collider.setRectCircle(posx,  posy, width, height);
	}

	@Override
	public void setWidth(int miAncho){
		width = miAncho;
		collider.setRectCircle(posx,  posy, width, height);
	}

	@Override
	public void setHeight(int miAlto){
		height = miAlto;
		collider.setRectCircle(posx,  posy, width, height);
	}

	public Collider getCollider() {
		return collider;
	}	
	
	public boolean getReceiveCollision(){
		return receiveCollision;
	}
	
	public void setReceiveCollision(boolean b){
		receiveCollision = b;
	}

	public double getPower() {
		return power;
	}

	public void receivePower(double cosX, double cosY, double recPower) {
		speedX = (int) (speedX * cosX + cosX * recPower);
		speedY = (int) (speedY * cosY + cosY * recPower);
//		System.out.println(speedX+"_"+speedY);
	}
	
}
	
