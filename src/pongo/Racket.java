package pongo;

import pongo.intefaces.ICollidable;
import pongo.intefaces.ICollidableRectCircle;
import pongo.physics.Collider;

public class Racket extends Mobil{

	public Racket(int esX, int esY, int esAncho,
			int esAlto, int limx, int limy) {
		super(esX, esY, esAncho, esAlto, limx, limy);
		power = 10;
	}
}
