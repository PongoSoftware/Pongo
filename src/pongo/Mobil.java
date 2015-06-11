package pongo;

public abstract class Mobil extends Object2D{

	private int speedX;
	private int speedY;
//---------------Constructor---------------
	public Mobil(int esX, int esY, int esAncho,int esAlto) {
		super(esX, esY, esAncho, esAlto);
	}
	

//-----------------Métodos-----------------

	public void move(){
		posx += speedX;
		posy += speedY;
	}
	
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
		
	public double getSpeedY(){
		return speedY;
	}

	public void setSpeed(int x, int y) {
		speedX = x;
		speedY = y;		
	}
}
	
