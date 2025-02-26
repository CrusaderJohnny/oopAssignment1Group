package shapes;

public class TriangularPrism extends Prisms
{

	public TriangularPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return getSide() * getSide() * Math.sqrt(3) / 4;
	}
	
	@Override
	public String toString() {
		return "Triangular Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +String.format("%.2f", calcBaseArea())+ 
				"\nVolume: " +String.format("%.2f", calcVolume())+ "\n";
	}

}
