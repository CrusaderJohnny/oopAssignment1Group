package shapes;

public class PentagonalPrism extends Prisms
{

	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 5 * getSide() * getSide() * Math.tan(0.942478) / 4;
	}
	
	@Override
	public String toString() {
		return "Pentagonal Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +String.format("%.2f", calcBaseArea())+
				"\nVolume: " +String.format("%.2f", calcVolume())+ "\n";
	}

}
