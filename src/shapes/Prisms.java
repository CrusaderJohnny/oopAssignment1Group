package shapes;

public abstract class Prisms extends Shapes {

	private double side;

	/**
	 * Constructor for Prisms class
	 * Initializes the height and side of the prism.
	 * 
	 * @param height The height of the prism.
	 * @param side The length of the prism.
	 */
	public Prisms(double height, double side) {
		super(height);
		this.side = side;
	}
	
	/**
	 * Implemented the getter to access the side of the base
	 * 
	 * @return the side length of the prism base
	 */
	public double getSide() {
		return side;
	}

	/**
	 * Calculates the volume of the prism.
	 * Using the formula base area multiplied by the height.
	 * 
	 * @return The volume of the prism.
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}

}
