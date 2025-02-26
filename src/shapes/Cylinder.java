package shapes;


/**
 * Class to represent a Cylinder Shape
 */
public class Cylinder extends Shapes
{
	/**
	 * Radius attribute of Cylinder
	 */
	private double rads;

	/**
	 * Creates a Cylinder object using height and radius
	 * @param height height of Cylinder
	 * @param rads radius of Cylinder
	 */
	public Cylinder(double height, double rads) {
		super(height);
		this.rads = rads;
	}
	
	/**
	 * Get object radius 
	 * @return radius
	 */
	public double getRads() {
		return rads;
	}

	@Override
	public double calcBaseArea() {
		return 2 * Math.PI * rads * getHeight() + 2* Math.PI * rads * rads;
	}

	@Override
	public double calcVolume() {
		return Math.PI * rads * rads * getHeight();
	}
	@Override
	public String toString() {
		return "Cylinder height: " + getHeight() + "\nCylinder radius: " + rads + "\nBase Area: "+ String.format("%.2f", calcBaseArea()) + 
				"\nVolume: " +String.format("%.2f", calcVolume())+ "\n";
	}

}
