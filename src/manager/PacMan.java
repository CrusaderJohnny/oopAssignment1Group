package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
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

public class PacMan {

	// attribute
	private String fileName;
	private char compareType;
	private char sortType;
	private Shapes[] shapes;
	// private Scanner input;
	// private File file;
	private Scanner newFile;
	private int destinedLength;
	private Comparator<Shapes> comparator = null;

	/**
	 * Creates class with args
	 * Processes the input arguments for filename, comparison type, and sorting type
	 * 
	 * @param args
	 */

	public PacMan(String[] args) {
		// Commmand-line arguments
		for (String s : args) {
			System.out.println(s);
			if (s.startsWith("-f") || s.startsWith("-F")) {
				// Helps extracting the file name.
				fileName = s.substring(2);
			} else if (s.startsWith("-t") || s.startsWith("-T")) {
				// Helps extracting the comparison type and sets the comparator.
				compareType = Character.toLowerCase(s.substring(2).charAt(0));
				switch (compareType) {
					case 'h':
						// No comparison for 'h'
						comparator = null;
						break;
					case 'v':
						// Volume comparison for 'v'
						comparator = new VolumeCompare();
						break;
					case 'a':
						// BaseArea comparison for 'a'
						comparator = new BaseAreaCompare();
						break;
				}

				// Reverse comparator
				comparator = (comparator != null) ? comparator.reversed() : null;

			} else if (s.startsWith("-s") || s.startsWith("-S")) {
				// Helps extracting the sorting type
				sortType = s.substring(2).charAt(0);
			}
		}
		// File input
		System.out.println(fileName);
		System.out.println(compareType);
		System.out.println(sortType);

		// Loads the shapes from the file and sorts them.
		loadShapesFromFile(fileName);
		sortShapesFromFile();
	}

	/**
	 * Sorts the shapes array
	 */

	private void sortShapesFromFile() {

		// Prints the result before sorting
		SortManager.printResult(shapes, compareType);

		sortType = Character.toUpperCase(sortType);
		long start = System.currentTimeMillis();
		String sortMethod;

		// Sorts the shapes array based on the sorting type
		switch (sortType) {
			case 'B':
				sortMethod = "Bubble Sort";
				SortManager.bubbleSort(shapes, comparator);
				break;
			case 'I':
				sortMethod = "Insertion Sort";
				SortManager.insertionSort(shapes, comparator);
				break;
			case 'S':
				sortMethod = "Selection Sort";
				SortManager.selectionSort(shapes, comparator);
				break;
			case 'M':
				sortMethod = "Merge Sort";
				SortManager.mergeSort(shapes, comparator);
				break;
			case 'Q':
				sortMethod = "Quick Sort";
				SortManager.quickSort(shapes, comparator);
				break;
			case 'H':
				sortMethod = "Heap Sort";
				SortManager.heapSort(shapes, comparator); // TODO: test
				break;
			default:
				sortMethod = "Unknown Sort";
				break;
		}

		long end = System.currentTimeMillis();

		System.out.println("-----------------Sorted-----------------");
		// prints the sorted result.
		SortManager.printResult(shapes, compareType);

		System.out.println("-------------------------------------------------Time taken by " + sortMethod + ": " + (end - start) + " ms");


	}

	/**
	 * loads shapes from file into shapes array
	 */

	private void loadShapesFromFile(String file) {

		// opens the file and keeps track of current index of shape.
		File loadFile = new File("res/" + file);
		Integer shapeNumber = 0;

		// Creates the new scanner for the reading and handles the file not found
		// exception.
		try {
			newFile = new Scanner(loadFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		while (newFile.hasNext()) {
			String line = newFile.nextLine();
			String[] fields = line.split(" ");
			String shapeID = fields[0];

			// If shapeID is number then it specifies the number of shapes.
			if (shapeID.matches("\\d+")) {
				destinedLength = Integer.parseInt(shapeID);
				// Initialize the array of shapes with length given.
				shapes = new Shapes[destinedLength];
				continue;
			}

			// Helps in extracting the dimensions of the shape.
			double field1 = Double.parseDouble(fields[1]);
			double field2 = Double.parseDouble(fields[2]);

			// Creates the shape based on the shapeID and dimensions.
			switch (shapeID) {
				case "Cone":
					shapes[shapeNumber] = new Cone(field1, field2);
					break;
				case "Cylinder":
					shapes[shapeNumber] = new Cylinder(field1, field2);
					break;
				case "Pyramid":
					shapes[shapeNumber] = new Pyramid(field1, field2);
					break;
				case "OctagonalPrism":
					shapes[shapeNumber] = new OctagonalPrism(field1, field2);
					break;
				case "PentagonalPrism":
					shapes[shapeNumber] = new PentagonalPrism(field1, field2);
					break;
				case "SquarePrism":
					shapes[shapeNumber] = new SquarePrism(field1, field2);
					break;
				case "TriangularPrism":
					shapes[shapeNumber] = new TriangularPrism(field1, field2);
					break;
				default:
					System.out.println("No shape ID found: [" + shapeID + "]");
					break;
			}
			shapeNumber++;
		}

	}

}
