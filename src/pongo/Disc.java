package pongo;

import pongo.intefaces.IGoal;

/**
 * @author  jfernandez
 *
 */
public class Disc extends Mobil implements IGoal {

	private int[][] goals;
	private PongoMain controller;

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
	public Disc(int esX, int esY, int esAncho, int esAlto, int top, int rigth,
			int botton, int left) {
		super(esX, esY, esAncho, esAlto, top, rigth, botton, left);
		receiveCollision = true;
		aceleration = 0.1;
		type = 0;
	}

	
	/* (sin Javadoc)
	 * @see pongo.Mobil#aceleration()
	 */
	public void aceleration() {
		super.aceleration();
	}

	/* (sin Javadoc)
	 * @see pongo.Mobil#speedMove()
	 */
	public void speedMove() {
		super.speedMove();
	}

	/* (sin Javadoc)
	 * @see pongo.Mobil#limitMove()
	 */
	public void limitMove() {
		super.limitMove();
	}

	/* (sin Javadoc)
	 * @see pongo.Mobil#moveAceleration()
	 */
	@Override
	public void moveAceleration() {
		aceleration();
		speedMove();
		if (!checkGoal()) {
			limitMove();
		}
		collider.setRectCircle(posx, posy, width, height);
	}

	/* (sin Javadoc)
	 * @see pongo.intefaces.IGoal#checkGoal()
	 */
	@Override
	public boolean checkGoal() {

		if (posy > goals[0][0] && (posy + height) < goals[0][1]
				&& (posx) <= goals[0][2]) {
			if (posy > goals[0][0] && (posy + height) < goals[0][1]
					&& (posx + width) <= goals[0][2]) {
				controller.receiveGoal(0);
			}
			return true;
		} else if (posy > goals[1][0] && (posy + height) < goals[1][1]
				&& (posx + width) >= goals[1][2]) {
			if (posy > goals[1][0] && (posy + height) < goals[1][1]
					&& (posx) >= goals[1][2]) {
				controller.receiveGoal(1);
			}
			return true;
		} else {
			return false;
		}
	}

	/* (sin Javadoc)
	 * @see pongo.intefaces.IGoal#setGoal(int[][])
	 */
	@Override
	public void setGoal(int[][] goals) {
		this.goals = goals;

	}

	/**
	 * @param pongoMain
	 */
	public void setController(PongoMain pongoMain) {
		this.controller = pongoMain;
	}
}