package pongo;

import pongo.physics.Collider;

public class Disc extends Mobil  {

	private Collider collider;

	public Disc(int esX, int esY, int esAncho,
			int esAlto, int top, int rigth, int botton, int left) {
		super(esX, esY, esAncho, esAlto, top, rigth, botton, left);
		receiveCollision = true;
		aceleration = 0.1;
		type = 0;
	}	
}