package shapes;

import java.util.Comparator;

public class BaseAreaCompare implements Comparator<Shapes> {

	@Override
	public int compare(Shapes s1, Shapes s2) {
		if(s1.calcBaseArea() > s2.calcBaseArea()) {
			return -1;
		}
		if(s1.calcBaseArea() < s2.calcBaseArea()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
