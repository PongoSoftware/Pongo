package pongo.intefaces;

public interface ICollidableRectCircle extends ICollidable {
	abstract void setRect();
	abstract void calcCircle();
	abstract void setWidth(int miAncho);
	abstract void setHeight(int miAlto);
}
