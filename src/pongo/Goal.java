package pongo;

/**
 * @author  jfernandez
 * @version v0.1
 * @since 2015/06/16
 *
 */
public class Goal extends Object2D {
	/**
	 * @param posxGoal
	 * @param posyGoal
	 * @param widthGoal
	 * @param heightGoal
	 */
	public Goal(int posxGoal, int posyGoal, int widthGoal, int heightGoal){
		super(posxGoal, posyGoal, widthGoal, heightGoal);	
		type = 1;
	}
}
