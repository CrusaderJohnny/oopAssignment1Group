package shapes;

public abstract class Prisms extends Shapes {

	private double side;
	public Prisms(double height, double side) {
		super(height);
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}

}
