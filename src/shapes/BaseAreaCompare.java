package shapes;

import java.util.Comparator;

/**
 * Base area compare class
 * Takes the base are of two shape objects when compare function is called
 * returns negative value if object 1 is greater than object 2
 * Designed to sort the array in descending order
 */

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
