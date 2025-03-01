package shapes;

/**
 * Class to represent the Cone Shape
 */
public class Cone extends Shapes
{
	/**
	 * Radius attribute of Cone Shape
	 */
	private double rads;	

	/**
	 * Constructor for cone shape extending from shape class adds height from super and radius
	 * @param height height
	 * @param rads radius
	 */
	public Cone(double height, double rads) {
		super(height);
		this.rads = rads;
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * rads * rads;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}
	
	/**
	 * Get object radius 
	 * @return radius
	 */
	public double getRads() {
		return rads;
	}

	@Override
	public String toString() {
		return "Cone height: " + getHeight() + "\nCone radius: " + rads + 
				"\nBase Area: "+ String.format("%.5f", calcBaseArea()) + 
				"\nVolume: " +String.format("%.5f", calcVolume())+ "\n";
	}
	
	

}
