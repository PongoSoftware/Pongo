package pongo;

public abstract class Object2D {

	private int X; 
	private int Y;
	private int SpeedX;
	private int SpeedY;
	private int Ancho;
	private int Alto;

//--------------Costructor------------------

	public Object2D (int esX, int esY, int esSpeedX, 
					int esSpeedY, int esAncho, int esAlto){
		X = esX; 
		Y = esY; 
		SpeedX = esSpeedX;
		SpeedY = esSpeedY;
		Ancho = esAncho;
		Alto = esAlto;
	}
	
	public Object2D (int esAncho, int esAlto){
		X = 0;
		Y = 0;
		SpeedX = 0;
		SpeedY = 0;
		Ancho = esAncho;
		Alto = esAlto;
	}
//-----------Setter-&-Getter----------------
	public void SetX(int miX){
		X = miX;
	}
	
	public double GetX(){
		return X;
	}
	
	
	public void SetY(int miY){
		Y = miY;
	}
	
	public double GetY(){
		return Y;
	}

	public void SetSpeedX(int miSpeedX){
		SpeedX = miSpeedX;
	}
		
	public double GetSpeedX(){
		return SpeedX;
	}
	
	public void SetSpeedY(int miSpeedY){
		SpeedY = miSpeedY;
	}
		
	public double GetSpeedY(){
		return SpeedY;
	}
	
	public void SetAncho(int miAncho){
			Ancho = miAncho;
		}
		
	public int GetAncho(){
			return Ancho;
	}
	
	
	public void SetAlto(int miAlto){
		Alto = miAlto;
	}
		
	public double GetAlto(){
		return Alto;
	}
	
// -----------------Métodos-----------------
	
	public void ChangePos (int isX, int isY){
		X = isX;
		Y = isY;
	}
	
	public int[] GivePos (){
		int[] temp = new int[2];
		temp [0] = X;
		temp [1] = Y;
		return temp;
	}
}
