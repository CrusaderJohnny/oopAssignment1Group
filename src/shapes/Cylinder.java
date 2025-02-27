package shapes;

public class Cylinder extends Shapes
{
	
	private double rads;

	/**
	 * Constructor for the Cylinder class.
	 * It initializes the height and from the shapes superclass the radius
	 * @param rads the radius of the cylinder
	 * @param height the height of the cylinder.
	 */
	public Cylinder(double height, double rads) {
		super(height);
		this.rads = rads;
	}
	
	/**
	 * Returns the radius 
	 */
	public double getRads() {
		return rads;
	}

	/**
	 * Method calculates the base area of the cylinder.
	 * @return the base area of the cylinder
	 */

	@Override
	public double calcBaseArea() {
		return 2 * Math.PI * rads * getHeight() + 2* Math.PI * rads * rads;
	}

	/**
	 * This calculates the volume of the cylinder using the formula pi*r^2*h
	 * Where r is the radius and h is the height
	 * 
	 * @return The volume of the cylinder.
	 */
	@Override
	public double calcVolume() {
		return Math.PI * rads * rads * getHeight();
	}

	/**
	 * This method returns the string representation of the Cylinder object.
	 * Including the radius, height, area, and the volume of the cylinder.
	 * @return the string representation of the Cylinder object.
	 */
	@Override
	public String toString() {
		return "Cylinder height: " + getHeight() + "Cylinder radius: " + rads + "Base Area: "+ calcBaseArea() + "Volume: " +calcVolume();
	}

}
