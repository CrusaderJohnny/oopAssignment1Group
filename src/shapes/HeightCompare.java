package shapes;

import java.util.Comparator;

public class HeightCompare implements Comparator<Shapes> {

	@Override
	public int compare(Shapes s1, Shapes s2) {
		if(s1.getHeight() > s2.getHeight()) {
			return 1;
		}
		if(s1.getHeight() < s2.getHeight()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
