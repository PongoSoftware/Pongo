package pongo;

import pongo.physics.Collider;

public class Disc extends Mobil  {

	private Collider collider;

	public Disc(int esX, int esY, int esAncho,
			int esAlto, int limx, int limy) {
		super(esX, esY, esAncho, esAlto, limx, limy);
		receiveCollision = true;
		type = 0;
	}	
}