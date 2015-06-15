package pongo.physics;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public class Utils {
	
	/**
	 * @param ax
	 * @param ay
	 * @param bx
	 * @param by
	 * @return
	 */
	public static int calcDistance(int ax, int ay, int bx, int by){
		int sum1 = bx - ax ; 
		int sum2 = by - ay ;
		double square = (Math.pow(sum1, 2) + Math.pow(sum2, 2));
		int distance = (int) Math.sqrt(square);
		return distance;
	}
}
