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
	//private Scanner input;
	//private File file;
	private Scanner newFile;
	private int destinedLength;
	private Comparator<Shapes> comparator = null;

	/**
	 * Creates class with args
	 * 
	 * @param args
	 */

	public PacMan(String[] args) {
		for (String s : args) {
			System.out.println(s);
			if (s.startsWith("-f") || s.startsWith("-F")) {
				fileName = s.substring(2);
			} else if (s.startsWith("-t") || s.startsWith("-T")) {
				compareType = Character.toLowerCase(s.substring(2).charAt(0));
				switch (compareType) {
					case 'h':
						comparator = null;
						break;
					case 'v':
						comparator = new VolumeCompare();
						break;
					case 'a':
						comparator = new BaseAreaCompare();
						break;
				}

				comparator = (comparator != null) ? comparator.reversed() : null;

			} else if (s.startsWith("-s") || s.startsWith("-S")) {
				sortType = s.substring(2).charAt(0);
			}
		}
		System.out.println(fileName);
		System.out.println(compareType);
		System.out.println(sortType);
		loadShapesFromFile(fileName);
		sortShapesFromFile();
	}

	/**
	 * Sorts the shapes array
	 */

	private void sortShapesFromFile() {

		SortManager.printResult(shapes, compareType);

		sortType = Character.toUpperCase(sortType);

		switch (sortType) {
			case 'B':
				SortManager.bubbleSort(shapes, comparator);
				break;

			case 'I':
				SortManager.insertionSort(shapes, comparator);
				break;

			case 'S':
				SortManager.selectionSort(shapes, comparator);
				break;

			case 'M':
				SortManager.mergeSort(shapes, comparator);

				break;

			case 'Q':
				SortManager.quickSort(shapes, comparator);
				break;
			/*
			 * case 'H':
			 * SortManager.heapSort(shapes, comparator);//TODO : implement heap sort
			 * break;
			 */
			default:
				break;
		}

		SortManager.printResult(shapes, compareType);


	}

	/**
	 * loads shapes into shapes array
	 */

	private void loadShapesFromFile(String file) {
		File loadFile = new File("res/" + file);
		Integer shapeNumber = 0;
		try {
			newFile = new Scanner(loadFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		while (newFile.hasNext()) {
			String line = newFile.nextLine();
			String[] fields = line.split(" ");
			String shapeID = fields[0];

			if (shapeID.matches("\\d+")) {
				destinedLength = Integer.parseInt(shapeID);
				shapes = new Shapes[destinedLength];
				continue;
			}

			double field1 = Double.parseDouble(fields[1]);
			double field2 = Double.parseDouble(fields[2]);

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
