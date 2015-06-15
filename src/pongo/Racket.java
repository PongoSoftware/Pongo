package pongo;

import pongo.physics.Collider;

public class Racket extends Mobil{

	public Racket(int esX, int esY, int esAncho,
			int esAlto, int top, int rigth, int botton, int left) {
		super(esX, esY, esAncho, esAlto, top, rigth, botton, left);
		power = 70;
		type = 0;
	}
}
