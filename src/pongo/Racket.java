package pongo;

import pongo.intefaces.IKeyMobil;
import pongo.physics.Collider;

/**
 * @author jfernandezpe
 * @version v0.1
 * @since 2015/06/16
 *
 */
public class Racket extends Mobil implements IKeyMobil{

	protected int dirX; // 1 y -1 
	protected int dirY;
	
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
	public Racket(int esX, int esY, int esAncho,
			int esAlto, int top, int rigth, int botton, int left) {
		super(esX, esY, esAncho, esAlto, top, rigth, botton, left);
		power = 50;
		type = 0;
	}

	/* (sin Javadoc)
	 * @see pongo.intefaces.IKeyMobil#moveKey(boolean)
	 */
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

	/* (sin Javadoc)
	 * @see pongo.intefaces.IKeyMobil#moveKeyX(int)
	 */
	@Override
	public void moveKeyX(int x) {
		dirX = x;
		
	}

	/* (sin Javadoc)
	 * @see pongo.intefaces.IKeyMobil#moveKeyY(int)
	 */
	@Override
	public void moveKeyY(int y) {
		dirY = y;
	}
}
