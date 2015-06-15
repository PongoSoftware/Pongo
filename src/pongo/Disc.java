package pongo;

import pongo.intefaces.IGoal;
import pongo.physics.Collider;

public class Disc extends Mobil  implements IGoal {

	private Collider collider;
	private int[][] goals;

	public Disc(int esX, int esY, int esAncho,
			int esAlto, int top, int rigth, int botton, int left) {
		super(esX, esY, esAncho, esAlto, top, rigth, botton, left);
		receiveCollision = true;
		aceleration = 0.1;
		type = 0;
	}	
	
	public void aceleration(){
		super.aceleration();
	}
	
	public void speedMove(){
		super.speedMove();
	}
	
	public void limitMove(){
		super.limitMove();
	}
	
	@Override
	public void moveAceleration(){
		aceleration();
		speedMove();
//		if (!checkGoal()){
			limitMove();
//		}
		collider.setRectCircle(posx,  posy, width, height);
	}
	
	@Override
	public boolean checkGoal() {
		
		
		if (posy > goals[0][0] && (posy + height) < goals[0][1] && (posx) <= goals[0][2]) {
			System.out.println("se mete aunque no hay gol");
			if (posy > goals[0][0] && (posy + height) < goals[0][1] && (posx + width) <= goals[0][2]) {
				System.out.println("hay gol");
			}
			return true;
		} else if (posy > goals[1][0] && (posy + height) < goals[1][1] && (posx + width) >= goals[1][2]) {
			System.out.println("Tambien se mete aunque no hay gol");
			if (posy > goals[1][0] && (posy + height) < goals[1][1] && (posx) >= goals[1][2]){
				System.out.println("tambien hay gol");
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setGoal(int[][] goals) {
		this.goals = goals;
		
	}
}