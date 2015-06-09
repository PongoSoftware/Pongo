package pongo;

public abstract class Object2D {

	private int posx; 
	private int posy;
	private int SpeedX;
	private int SpeedY;
	private int Ancho;
	private int Alto;

//--------------Costructor------------------

	public Object2D (int esX, int esY, int esSpeedX, 
					int esSpeedY, int esAncho, int esAlto){
		posx = esX; 
		posy = esY; 
		SpeedX = esSpeedX;
		SpeedY = esSpeedY;
		Ancho = esAncho;
		Alto = esAlto;
	}
	
	public Object2D (int esAncho, int esAlto){
		posx = 0;
		posy = 0;
		SpeedX = 0;
		SpeedY = 0;
		Ancho = esAncho;
		Alto = esAlto;
	}
//-----------Setter-&-Getter----------------
	public void SetX(int miX){
		posx = miX;
	}
	
	public double GetX(){
		return posx;
	}
	
	
	public void SetY(int miY){
		posy = miY;
	}
	
	public double GetY(){
		return posy;
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
		posx = isX;
		posy = isY;
	}
	
	public int[] GivePos (){
		int[] temp = new int[2];
		temp [0] = posx;
		temp [1] = posy;
		return temp;
	}
}
