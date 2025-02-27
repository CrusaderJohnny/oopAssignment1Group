package shapes;

public class TriangularPrism extends Prisms
{

	/**
	 * constructor for the Triangular prism class.
	 * Initializes the height and side of the prism.
	 * 
	 * @param height The height of the prism
	 * @param side The side of the prism.
	 */
	public TriangularPrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Method calculates the base area of the prism.
	 * Using the formula: (side^2*√3)/4
	 * @return the base area of the prism.
	 */
	@Override
	public double calcBaseArea() {
		return (Math.pow(getSide(), 2) * Math.sqrt(3)) / 4;
	}
	
	/**
	 * A string reprsentation of the Prism object.
	 * Including the height, side, area and volume.
	 * 
	 * @return The string representation of the object.
	 */
	@Override
	public String toString() {
		return "Triangular Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +calcBaseArea()+ "\nVolume: " +calcVolume();
	}

}
