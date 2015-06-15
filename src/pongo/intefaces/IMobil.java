package pongo.intefaces;

public interface IMobil {
	
		public void setSpeedX(int miSpeedX);
			
		public double setSpeedX();
		
		public void setSpeedY(int miSpeedY);
			
		public int getSpeedX();

		public double getSpeedY();

		public void setSpeed(int x, int y);
		
		public void move();
			
		public void setReceiveCollision(boolean b);
		
		public boolean getReceiveCollision();
}
