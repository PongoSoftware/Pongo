package pongo.physics;

import pongo.Mobil;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public class Reactions {

	/**
	 * @param object
	 * @param object2
	 */
	public static void circles(Mobil object, Mobil object2) {
		int centerAx = object.getCollider().getCenterx();
		int centerAy = object.getCollider().getCentery();
		int centerBx = object2.getCollider().getCenterx();
		int centerBy = object2.getCollider().getCentery();
		int magicNum = 10;
		
		//Reacción del primer objeto
		int distanceX = centerAx-centerBx;
		int distanceY =centerAy-centerBy;
		
		if (object.getReceiveCollision()){
			int distance = Utils.calcDistance(centerAx, centerAy, centerBx, centerBy);
			double cosX = ((double) distanceX) / ((double) distance);
			double cosY = ((double) distanceY) / ((double) distance);
			object.receivePower(cosX,cosY,object2.getPower());
		} else {
			
			object.setX((int) (object.getX() + distanceX / magicNum));
			object.setY((int) (object.getY() + distanceY / magicNum));
		}
		
		
		//Reacción del segundo objeto
		
		distanceX = centerBx - centerAx;
		distanceY = centerBy - centerAy;
		
		if (object2.getReceiveCollision()){
			int distance = Utils.calcDistance(centerAx, centerAy, centerBx, centerBy);
			double cosX = ((double) distanceX) / ((double) distance);
			double cosY = ((double) distanceY) / ((double) distance);
			object2.receivePower(cosX,cosY,object.getPower());
		} else {
			object2.setX((int) (object2.getX() + distanceX / magicNum));
			object2.setY((int) (object2.getY() + distanceY / magicNum));
		}
	}
}