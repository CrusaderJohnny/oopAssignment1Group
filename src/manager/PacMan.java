package manager;

import shapes.BaseAreaCompare;
import shapes.Shapes;
import shapes.VolumeCompare;
import utilities.SortManager;

public class PacMan {
	
	//attribute
	private String fileName;
	private char compareType;
	private char sortType;
	private Shapes[] shapes;
	
	/**
	 * Creates class with args
	 * @param args
	 */

	public PacMan(String[] args) {
		for(String s : args) {
			System.out.println(s);
			if(s.startsWith("-f") || s.startsWith("-F")) {
				fileName = s.substring(2);
			}
			else if(s.startsWith("-t") || s.startsWith("-T")) {
				compareType = s.substring(2).charAt(0);
			}
			else if(s.startsWith("-s") || s.startsWith("-S")) {
				sortType = s.substring(2).charAt(0);
			}
		}
		System.out.println(fileName);
		System.out.println(compareType);
		System.out.println(sortType);
//		loadShapesFromFile();
//		sortShapesFromFile();
	}
	
	/**
	 * Sorts the shapes array
	 */

	private void sortShapesFromFile() {
		if(compareType == 'h' || compareType == 'H') {
			if(sortType == 'b' || sortType == 'B') {
				SortManager.bubbleSort(shapes);
			}
		}
		else if(compareType == 'a' || compareType == 'A') {
			if(sortType == 'b' || sortType == 'B') {
				BaseAreaCompare bac = new BaseAreaCompare();
				SortManager.bubbleSort(shapes, bac);
			}
		}
		else if(compareType == 'v' || compareType == 'V') {
			if(sortType == 'b' || sortType == 'B') {
				VolumeCompare vc = new VolumeCompare();
				SortManager.bubbleSort(shapes, vc);
			}
		}
	}
	
	/**
	 * loads shapes into shapes array
	 */

	private void loadShapesFromFile() {
		// TODO Auto-generated method stub
		
	}
	
}
