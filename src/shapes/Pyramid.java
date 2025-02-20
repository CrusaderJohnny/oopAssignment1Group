package shapes;

public class Pyramid extends Shapes
{
	private double side;

	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	@Override
	public double calcBaseArea() {
		return side * side;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}
	
	@Override
	public String toString() {
		return "Pyramid height: " + getHeight() + "Pyramid side: " + side + 
				"Base Area: "+ calcBaseArea() + "Volume: " +calcVolume();
	}

}
