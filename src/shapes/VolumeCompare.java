package shapes;

import java.util.Comparator;

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
