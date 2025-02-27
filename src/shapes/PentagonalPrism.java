package shapes;

public class PentagonalPrism extends Prisms
{
	/**
	 * Constructor for Pentagonal prism.
	 * This constructor initializes the height and side length of the prism
	 * 
	 * @param height The height of the prism
	 * @param side The length of the side 
	 */

	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Calculates the base area of the prism 
	 * Using the formula (5*side^2)/(4*tan(54)), where 54 is an internal angle of the prism.
	 */

	@Override
	public double calcBaseArea() {
		return (5 * Math.pow(getSide(), 2)) / (4 * Math.tan(Math.toRadians(54)));

	}

	/**
	 * A string reprsentation of the Pentagonal Prism object.
	 * Including the height, side, area and volume.
	 * 
	 * @return The string representation of the object.
	 */
	
	@Override
	public String toString() {
		return "Pentagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +calcBaseArea()+ "\nVolume: " +calcVolume();
	}

}
