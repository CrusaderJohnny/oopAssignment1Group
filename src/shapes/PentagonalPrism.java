package shapes;

/**
 * Class to represent a Pentagonal Prism
 */

public class PentagonalPrism extends Prisms
{

	/**
	 * Creates a Pentagonal Prism Shape object
	 * @param height height of Pentagonal Prism
	 * @param side side length of Pentagonal Prism
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 5 * getSide() * getSide() * Math.tan(0.942478) / 4;
	}
	
	@Override
	public String toString() {
		return "Pentagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +String.format("%.2f", calcBaseArea())+
				"\nVolume: " +String.format("%.2f", calcVolume())+ "\n";
	}

}
