package pongo.physics;

public class Utils {
	public static int calcDistance(int ax, int ay, int bx, int by){
		int sum1 = bx - ax ; 
		int sum2 = by - ay ;
		double square = (Math.pow(sum1, 2) + Math.pow(sum2, 2));
		int distance = (int) Math.sqrt(square);
		return distance;
	}
}