package pongo;

import pongo.intefaces.IKeyMobil;
import pongo.physics.Collider;

public class Racket extends Mobil implements IKeyMobil{

	protected int dirX; // 1 y -1 
	protected int dirY;
	
	public Racket(int esX, int esY, int esAncho,
			int esAlto, int top, int rigth, int botton, int left) {
		super(esX, esY, esAncho, esAlto, top, rigth, botton, left);
		power = 50;
		type = 0;
	}

	@Override
	public void moveKey(boolean moving) {
		//if(moving == true){		
			speedX = 10;
			speedY = 10;
			
			posx += (speedX * dirX);
			posy += (speedY * dirY);
			collider.setRectCircle(posx,  posy, width, height);	
			
		//}		
	}

	@Override
	public void moveKeyX(int x) {
		dirX = x;
		
	}

	@Override
	public void moveKeyY(int y) {
		dirY = y;
	}
}
