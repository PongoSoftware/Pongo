package pongo;

import pongo.physics.Collider;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public abstract class Mobil extends Object2D {

	protected double speedX, speedY;
	protected int acelerationx, acelerationy;
	protected int top,rigth,botton,left;
	protected Collider collider;
	protected boolean receiveCollision = false;
	protected double power;
	protected double aceleration, acelerationX, acelerationY;
	private int initialPosx, initialPosy;
	
	//---------------Constructor---------------

	/**
	 * @param esX
	 * @param esY
	 * @param esAncho
	 * @param esAlto
	 * @param top
	 * @param rigth
	 * @param botton
	 * @param left
	 */
	public Mobil(int esX, int esY, int esAncho,
			int esAlto, int top, int rigth, int botton, int left) {
		super(esX, esY, esAncho, esAlto);
		this.initialPosx = esX;
		this.initialPosy = esY;
		this.initialPosy = esY;
		this.top = top;
		this.rigth = rigth;
		this.botton = botton;
		this.left = left;
		collider = new Collider(this);
		collider.setRectCircle(posx,  posy, width, height);
		aceleration = 0;
	}

	
	

//-----------------Métodos-----------------

	/**
	 * 
	 */
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
	
	/**
	 * 
	 */
	public void aceleration(){		
		double acePos = Math.abs(aceleration); 
		double aceNeg = acePos * -1;
		
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

		speedX += acelerationX / 2d;
		speedY += acelerationY / 2d;
		
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * 
	 */
	public void move(){
		limitMove();
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	/**
	 * 
	 */
	public void moveAceleration(){
		aceleration();
		speedMove();
		limitMove();
		collider.setRectCircle(posx,  posy, width, height);
	}
	


	/**
	 * @param cosX
	 * @param cosY
	 * @param recPower
	 */
	public void receivePower(double cosX, double cosY, double recPower) {
		int preSpeedX = (int) speedX;
//		System.out.println("_"+speedX+"_"+cosX+"_POW"+recPower);
		speedX = (int) (speedX * cosX + cosX * recPower);
		speedY = (int) (speedY * cosY + cosY * recPower);
		System.out.println(preSpeedX+"_"+speedX+"_"+cosX+"_POW"+recPower);
	}	
	
	/**
	 * 
	 */
	public void reset(){
		posx = initialPosx;
		posy = initialPosy;
		speedX = 0;
		speedY = 0;
	}
	
//-------------Setter-&-Getter-------------
	

	
	/**
	 * @return
	 */
	public int getAcelerationx() {
		return acelerationx;
	}


	/**
	 * @param acelerationx
	 */
	public void setAcelerationx(int acelerationx) {
		this.acelerationx = acelerationx;
	}


	/**
	 * @return
	 */
	public int getAcelerationy() {
		return acelerationy;
	}


	/**
	 * @param acelerationy
	 */
	public void setAcelerationy(int acelerationy) {
		this.acelerationy = acelerationy;
	}

	/**
	 * @param miSpeedX
	 */
	public void setSpeedX(int miSpeedX){
		speedX = miSpeedX;
	}
		
	/**
	 * @return
	 */
	public double setSpeedX(){
		return speedX;
	}
	
	/**
	 * @param miSpeedY
	 */
	public void setSpeedY(int miSpeedY){
		speedY = miSpeedY;
	}
		
	/**
	 * @return
	 */
	public double getSpeedX() {
		return speedX;
	}

	/**
	 * @return
	 */
	public double getSpeedY(){
		return speedY;
	}

	/**
	 * @param x
	 * @param y
	 */
	public void setSpeed(int x, int y) {
		speedX = x;
		speedY = y;		
	}
	
	/* (sin Javadoc)
	 * @see pongo.Object2D#setPos(int, int)
	 */
	@Override
	public void setPos(int x, int y){
		posx = x;
		posy = y;
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	
	
	
	/* (sin Javadoc)
	 * @see pongo.Object2D#setX(int)
	 */
	@Override
	public void setX(int miX){
		posx = miX;
		collider.setRectCircle(posx,  posy, width, height);
	}

	/* (sin Javadoc)
	 * @see pongo.Object2D#setY(int)
	 */
	@Override
	public void setY(int miY){
		posy = miY;
		collider.setRectCircle(posx,  posy, width, height);
	}

	/* (sin Javadoc)
	 * @see pongo.Object2D#setWidth(int)
	 */
	@Override
	public void setWidth(int miAncho){
		width = miAncho;
		collider.setRectCircle(posx,  posy, width, height);
	}

	/* (sin Javadoc)
	 * @see pongo.Object2D#setHeight(int)
	 */
	@Override
	public void setHeight(int miAlto){
		height = miAlto;
		collider.setRectCircle(posx,  posy, width, height);
	}

	/**
	 * @return
	 */
	public Collider getCollider() {
		return collider;
	}	
	
	/**
	 * @return
	 */
	public boolean getReceiveCollision(){
		return receiveCollision;
	}
	
	/**
	 * @param b
	 */
	public void setReceiveCollision(boolean b){
		receiveCollision = b;
	}

	/**
	 * @return
	 */
	public double getPower() {
		return power;
	}
}
	
