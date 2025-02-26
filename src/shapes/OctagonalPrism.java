package shapes;

/**
 * Class to represent an Octagonal Prism
 */

public class OctagonalPrism extends Prisms
{

	/**
	 * Creates an Octagonal Prism object using height and side parameters
	 * @param height height of Octagonal Prism
	 * @param side side length of Octagonal Prism
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * getSide() * getSide();
	}
	@Override
	public String toString() {
		return "Octagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +String.format("%.2f", calcBaseArea())+
				"\nVolume: " +String.format("%.2f", calcVolume())+ "\n";
	}
}
