package shapes;

import java.util.Comparator;

/**
 * Volume compare class
 * takes the volume of two shape objects when the compare function is called
 * returns negative value if object 1 is greater than object 2
 * Allows sorting of array in descending order this way
 */

public class VolumeCompare implements Comparator<Shapes> {

	@Override
	public int compare(Shapes s1, Shapes s2) {
		if(s1.calcVolume() > s2.calcVolume()) {
			return -1;
		}
		if(s1.calcVolume() < s2.calcVolume()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
