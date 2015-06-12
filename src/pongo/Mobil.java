package pongo;

import pongo.physics.Collider;

public abstract class Mobil extends Object2D{

	protected int speedX;
	protected int speedY;
	protected int acelerationx;
	protected int acelerationy;
	protected int limitx, limity;
	private Collider collider;
	protected boolean receiveCollision = false;
	protected double power;
	
	
	//---------------Constructor---------------

	public Mobil(int esX, int esY, int esAncho,
	int esAlto, int limx, int limy) {
		super(esX, esY, esAncho, esAlto);
		limitx = limx;
		limity = limy;
		collider = new Collider(this);
		collider.setRectCircle(posx,  posy, width, height);
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
		
	public int getSpeedX() {
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
	
	
	public void move(){
		posx += speedX;
		posy += speedY;
		if (posx < 0 ) {
			speedX = speedX * -1;
		} else if (posx > limitx){
			speedX = speedX * -1;
		}
		if (posy < 0 ) {
			speedY = speedY * -1;
		}else if (posy > limity){
			speedY = speedY * -1;
		}
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

	public void move(int x, int y) {
		posx += x;
		posy += y;
		collider.setRectCircle(posx,  posy, width, height);		
	}

	public Collider getCollider() {
		return collider;
	}	
	
	public boolean receiveCollision(){
		return receiveCollision;
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
	
