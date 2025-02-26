package shapes;

public class OctagonalPrism extends Prisms
{

	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
	}
	@Override
	public String toString() {
		return "Octagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +calcBaseArea()+ "\nVolume: " +calcVolume();
	}
}
