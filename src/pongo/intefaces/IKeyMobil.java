package pongo.intefaces;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public interface IKeyMobil {
	/**
	 * @param moving
	 */
	public void moveKey(boolean moving);
	
	/**
	 * @param x
	 */
	public void moveKeyX(int x);
	
	/**
	 * @param y
	 */
	public void moveKeyY(int y);
}
