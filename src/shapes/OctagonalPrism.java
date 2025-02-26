package shapes;

public class OctagonalPrism extends Prisms
{

	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * getSide() * getSide();
	}
	@Override
	public String toString() {
		return "Octagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +String.format("%.2f", calcBaseArea())+
				"\nVolume: " +String.format("%.2f", calcVolume())+ "\n";
	}
}
