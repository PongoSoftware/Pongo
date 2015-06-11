package pongo;

import pongo.intefaces.ICollidable;
import pongo.intefaces.ICollidableRectCircle;
import pongo.physics.Collider;

public class Racket extends Mobil{
	private Collider collider;

	public Racket(int esX, int esY, int esAncho,
			int esAlto) {
		super(esX, esY, esAncho, esAlto);
	}
}
