package shapes;

public final class SquarePrism extends Prisms
{

	public SquarePrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return getSide() * getSide();
	}

	@Override
	public String toString() {
		return "Square Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +String.format("%.5f", calcBaseArea())+
				"\nVolume: " +String.format("%.5f", calcVolume())+ "\n";
	}

}
