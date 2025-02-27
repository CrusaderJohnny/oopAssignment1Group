package shapes;

import java.util.Comparator;

public class VolumeCompare implements Comparator<Shapes> {

	/**
	 * Compares the two objects based on their volume.
	 * 
	 * @param s1. First shape to be compared.
	 * @param s2. Second shape to be compared.
	 * @return A positive integer if volume of s1 is greater that that of s2.
	 * 		   A negative integer if volume of s1 is smaller that that of s2.
	 *		   Zero if they are equal
	 */
	@Override
	public int compare(Shapes s1, Shapes s2) {
		if(s1.calcVolume() > s2.calcVolume()) {
			return 1;
		}
		if(s1.calcVolume() < s2.calcVolume()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
