package shapes;

public class OctagonalPrism extends Prisms
{

	/**
	 * Constructor for the OctagonalPrism class.
	 * It initializes the height and the side.
	 * @param side the side of the OctagonalPrism.
	 * @param height the height of the OctagonalPrism.
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Calcutales the base area of the OctagonalPrism.
	 * Using the formula: 2*(1+√2)*side^2
	 * @return the base area of the OctagonalPrism.
	 */

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
	}

	/**
	 * This method returns the string representation of the OctagonalPrism object
	 * Inlcluding the height, side, area and the volume
	 * @return the string representation of the OctagonalPrism object
	 */
	@Override
	public String toString() {
		return "Octagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +calcBaseArea()+ "\nVolume: " +calcVolume();
	}
}
