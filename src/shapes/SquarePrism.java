package shapes;

public final class SquarePrism extends Prisms
{

	/**
	 * constructor for the Square prism class.
	 * Initializes the height and side of the prism.
	 * 
	 * @param height The height of the prism
	 * @param side The side of the prism.
	 */
	public SquarePrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Method calculates the base area of the prism.
	 * @return the base area of the prism.
	 */
	@Override
	public double calcBaseArea() {
		return getSide() * getSide();
	}

	/**
	 * A string reprsentation of the Prism object.
	 * Including the height, side, area and volume.
	 * 
	 * @return The string representation of the object.
	 */
	@Override
	public String toString() {
		return "Square Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +calcBaseArea()+ "\nVolume: " +calcVolume();
	}

}
