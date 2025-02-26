package shapes;


/**
 * Class to represent Pyramid Shapes
 * 
 */
public class Pyramid extends Shapes
{
	/**
	 * Attribute to represent length of side as a double for a Pyramid object
	 */
	private double side;
	
	/**
	 * Pyramid constructor with height and side attributes
	 * @param height height of pyramid
	 * @param side side length of pyramid
	 */
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	@Override
	public double calcBaseArea() {
		return side * side;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}
	
	@Override
	public String toString() {
		return "Pyramid height: " + getHeight() + "\nPyramid side: " + side + 
				"\nBase Area: "+ String.format("%.2f", calcBaseArea()) + 
				"\nVolume: " +String.format("%.2f", calcVolume())+ "\n";
	}

}
