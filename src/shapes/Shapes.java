package shapes;
/**
 * Class to represent all shapes with height.
 * @author Mark
 */
public abstract class Shapes implements Comparable<Shapes> {
	private double height;
	

	/**
	 * Creates a shape with the height attribute
	 * @param height height of shapes
	 */
	public Shapes(double height) {
		super();
		this.height = height;
	}
	/**
	 * Gets the height of the shape object
	 * @return height of object
	 */
	public double getHeight() {
		return height;
	}
	
	@Override
	public int compareTo(Shapes o) {
		if(this.height > o.height) {
			return 1;
		}
		if(this.height < o.height) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * Returns the base area of the shape
	 * @return base area
	 */
	public abstract double calcBaseArea();
	
	
	/**
	 * Returns the volume of the shape
	 * @return volume
	 */
	public abstract double calcVolume();
}
