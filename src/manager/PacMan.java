package manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import shapes.BaseAreaCompare;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shapes;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import shapes.VolumeCompare;
import utilities.SortManager;
/**
 * Package manager class to handle included arguments to program
 */
public class PacMan {
	
	//attribute
	private String fileName;
	private char compareType;
	private char sortType;
	private Shapes[] shapes;
	private Scanner input;
	private File file;
	private	Scanner newFile;
	private int destinedLength;
	
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
		loadShapesFromFile(fileName);
		long start = System.currentTimeMillis();
		sortShapesFromFile();
		long stop = System.currentTimeMillis();
		long timeElapsed = stop - start;
		System.out.println(timeElapsed);
		
	}
	
	/**
	 * Sorts array of shapes from passed arguments
	 * sorts by compare type first
	 * chooses sorting method based off sort type
	 */

	private void sortShapesFromFile() {
		switch(Character.toLowerCase(compareType)) {
		case 'h':
			if(sortType == 'b' || sortType == 'B') {
			SortManager.bubbleSort(shapes);
			}
			else if(sortType == 'i' || sortType == 'I') {
				SortManager.insertionSort(shapes);
			}
			else if(sortType == 's' || sortType == 'S') {
				SortManager.selectionSort(shapes);
			}
			else if(sortType == 'm' || sortType == 'm') {
				SortManager.mergeSort(shapes);
			}
			else if(sortType == 'q' || sortType == 'Q') {
				SortManager.quickSort(shapes);
			}
			else if(sortType == 'h' || sortType == 'H') {
				SortManager.heapSort(shapes);
			}
			break;
		case 'a':
			if(sortType == 'b' || sortType == 'B') {
			BaseAreaCompare bac = new BaseAreaCompare();
			SortManager.bubbleSort(shapes, bac);
			}
			else if(sortType == 'i' || sortType == 'I') {
				BaseAreaCompare bac = new BaseAreaCompare();
				SortManager.insertionSort(shapes, bac);
			}
			else if(sortType == 's' || sortType == 'S') {
				BaseAreaCompare bac = new BaseAreaCompare();
				SortManager.selectionSort(shapes, bac);
			}
			else if(sortType == 'm' || sortType == 'm') {
				BaseAreaCompare bac = new BaseAreaCompare();
				SortManager.mergeSort(shapes, bac);
			}
			else if(sortType == 'q' || sortType == 'Q') {
				BaseAreaCompare bac = new BaseAreaCompare();
				SortManager.quickSort(shapes, bac);
			}
			else if(sortType == 'h' || sortType == 'H') {
				BaseAreaCompare bac = new BaseAreaCompare();
				SortManager.heapSort(shapes, bac);
			}
			break;
		case 'v':
			if(sortType == 'b' || sortType == 'B') {
			VolumeCompare vc = new VolumeCompare();
			SortManager.bubbleSort(shapes, vc);
			}
			else if(sortType == 'i' || sortType == 'I') {
				VolumeCompare vc = new VolumeCompare();
				SortManager.insertionSort(shapes, vc);
			}
			else if(sortType == 's' || sortType == 'S') {
				VolumeCompare vc = new VolumeCompare();
				SortManager.selectionSort(shapes, vc);
			}
			else if(sortType == 'm' || sortType == 'm') {
				VolumeCompare vc = new VolumeCompare();
				SortManager.mergeSort(shapes, vc);
			}
			else if(sortType == 'q' || sortType == 'Q') {
				VolumeCompare vc = new VolumeCompare();
				SortManager.quickSort(shapes, vc);
			}
			else if(sortType == 'h' || sortType == 'H') {
				VolumeCompare vc = new VolumeCompare();
				SortManager.heapSort(shapes, vc);
			}
			break;
		default:
			System.out.println("No proper method selected, options are 'h', 'a', and 'v' ");
		}	
	}
	
	/**
	 * Takes in file arg and reads from the file specified
	 * takes first line of file and sets array length to it
	 * Sorts next lines based on switch case from first field of the line
	 * creates new shape objects based on switch case
	 * adds shape object to array at specified index and then increments index by 1
	 */

	private void loadShapesFromFile(String file) {
		File loadFile = new File("res/"+file);
		int index = 0;

		try {
			newFile = new Scanner(loadFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		String length = newFile.nextLine();
		destinedLength = Integer.parseInt(length);
		shapes = new Shapes[destinedLength];
		while(newFile.hasNext()) {
			String line = newFile.nextLine();
			String[] fields = line.split(" ");
			String shapeID = fields[0].toLowerCase();
			Shapes s = null;
			switch(shapeID) {
			case "cone":
				s = new Cone(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				break;
			case "cylinder":
				s = new Cylinder(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				break;
			case "pyramid":
				s = new Pyramid(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				break;
			case "octagonalprism":
				s = new OctagonalPrism(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				break;
			case "pentagonalprism":
				s = new PentagonalPrism(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				break;
			case "squareprism":
				s = new SquarePrism(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				break;
			case "triangularprism":
				s = new TriangularPrism(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				break;
			default:
				System.out.println("No shape ID found");
				break;
			}
			shapes[index] = s;
			index++;
		}	
	}	
}
