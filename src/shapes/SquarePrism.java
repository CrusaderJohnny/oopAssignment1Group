package shapes;

public final class SquarePrism extends Prisms
{

	public SquarePrism(double height, double side) {
		super(height, side);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcBaseArea() {
		return getSide() * getSide();
	}

	@Override
	public String toString() {
		return "Square Prism with height: " + getHeight() + "\nSides: " 
				+getSide() + "\nHas a base area: " +calcBaseArea()+ "\nVolume: " +calcVolume();
	}

}
