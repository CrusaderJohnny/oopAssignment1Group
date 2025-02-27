package shapes;

public class Cone extends Shapes
{
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

	/**
	 * This method calculates the base area of the cone 
	 * 
	 * @return The base area of the cone.
	 */
	@Override
	public double calcBaseArea() {
		return Math.PI * rads * rads;
	}

	/**
	 * This method calculates the volume of the cone
	 * 
	 * @return The volume of the cone.
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}

	/**
	 * This method returns the radius of the base of the cone.
	 * 
	 * @return The radius of the cone.
	 */
	public double getRads() {
		return rads;
	}

	/**
	 * This method returns a string representation of the object cone.
	 * It displays all the parameters including the height, radius, base area and the volume of the cone.
	 * 
	 * @return A string representation of the cone object.
	 */
	@Override
	public String toString() {
		return "Cone height: " + getHeight() + "Cone radius: " + rads + 
				"Base Area: "+ calcBaseArea() + "Volume: " +calcVolume();
	}
	
	

}
