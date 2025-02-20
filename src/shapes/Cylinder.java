package shapes;

public class Cylinder extends Shapes
{
	
	private double rads;

	public Cylinder(double height, double rads) {
		super(height);
		this.rads = rads;
	}
	
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
		return "Cylinder height: " + getHeight() + "Cylinder radius: " + rads + "Base Area: "+ calcBaseArea() + "Volume: " +calcVolume();
	}

}
