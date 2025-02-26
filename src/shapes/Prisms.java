package shapes;

/**
 * Class to represent the Prism Shape
 */

public abstract class Prisms extends Shapes {

	/**
	 * Prism side length attribute
	 */
	private double side;
	
	/**
	 * Prisms constructor that takes height and side attribute
	 * @param height height of Prism
	 * @param side side length of Prism
	 */
	public Prisms(double height, double side) {
		super(height);
		this.side = side;
	}
	
	/**
	 * Get object side
	 * @return side
	 */
	public double getSide() {
		return side;
	}
	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}

}
