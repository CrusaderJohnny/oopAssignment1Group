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

	@Override
	public double calcBaseArea() {
		return Math.PI * rads * rads;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}

	public double getRads() {
		return rads;
	}

	@Override
	public String toString() {
		return "Cone height: " + getHeight() + "Cone radius: " + rads + 
				"Base Area: "+ calcBaseArea() + "Volume: " +calcVolume();
	}
	
	

}
