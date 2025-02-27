package shapes;

public class Pyramid extends Shapes
{
	private double side;

	/**
	 * Constructor for Pyramid class.
	 * Initializes the height and side length of the pyramid.
	 * 
	 * @param height The height of the pyramid.
	 * @param side The side length of the pyramid.
	 */
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	/**
	 * Calculates the base area of the pyramid.
	 * @return The area of the base of pyramid.
	 */
	@Override
	public double calcBaseArea() {
		return side * side;
	}

	/**
	 * Calculates the volume of the pyramid.
	 * using the formula area*h/3
	 * @return The volume of the base of pyramid.
	 */

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}
	
	/**
	 * A string reprsentation of the Pyramid object.
	 * Including the height, side, area and volume.
	 * 
	 * @return The string representation of the object.
	 */
	@Override
	public String toString() {
		return "Pyramid height: " + getHeight() + "Pyramid side: " + side + 
				"Base Area: "+ calcBaseArea() + "Volume: " +calcVolume();
	}

}
