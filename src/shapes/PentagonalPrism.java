package shapes;

public class PentagonalPrism extends Prisms
{

	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (5 * Math.pow(getSide(), 2)) / (4 * Math.tan(Math.toRadians(54)));

	}
	
	@Override
	public String toString() {
		return "Pentagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +calcBaseArea()+ "\nVolume: " +calcVolume();
	}

}
