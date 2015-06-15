package pongo.physics;

import pongo.Mobil;

public class Reactions {

	public static void circles(Mobil object, Mobil object2) {
		int centerAx = object.getCollider().getCenterx();
		int centerAy = object.getCollider().getCentery();
		int centerBx = object2.getCollider().getCenterx();
		int centerBy = object2.getCollider().getCentery();
		
//		int distance = Utils.calcDistance(centerAx, centerAy, centerBx, centerBy);
//		int distanceX = Math.abs(centerAx-centerBx);
//		int distanceY = Math.abs(centerAy-centerBy);
		
//		System.out.println(distance+"-"+distanceX);
//		double cosx = ((double) distanceX) / ((double) distance);
//		double cosy = ((double) distanceY) / ((double) distance);
//		double angulox = Math.toDegrees(Math.acos(cosx));
//		double anguloy = Math.toDegrees(Math.acos(cosy));

//		System.out.println(cosx+"_"+cosy);
//		System.out.println(angulox+"_"+anguloy);
		if (object.receiveCollision()){
			int distance = Utils.calcDistance(centerAx, centerAy, centerBx, centerBy);
			int distanceX = centerAx-centerBx;
			int distanceY =centerAy-centerBy;
			double cosX = ((double) distanceX) / ((double) distance);
			double cosY = ((double) distanceY) / ((double) distance);
			object.receivePower(cosX,cosY,object2.getPower());
		}
		if (object2.receiveCollision()){

			int distance = Utils.calcDistance(centerAx, centerAy, centerBx, centerBy);
			int distanceX = centerBx - centerAx;
			int distanceY = centerBy - centerAy;
			double cosX = ((double) distanceX) / ((double) distance);
			double cosY = ((double) distanceY) / ((double) distance);
			object2.receivePower(cosX,cosY,object.getPower());
		}
	}

}
