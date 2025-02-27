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
		displaySortedResults(timeElapsed,sortType);

    }
	
	/**
	 * Displays First, Last, and every thousandth element in the array
	 * Takes two passed parameters of timeElapsed and sortType
	 * @param timeElapsed Passed parameter of the difference between start and stop time in milliseconds
	 * @param sortType Passed parameter of chosen sorting method
	 */
    private void displaySortedResults(long timeElapsed,char sortType) {

        String sortName = null ;
        switch(Character.toLowerCase(sortType)) {
        case'b':
            sortName = "Bubble sort";
            break;
        case'i':
            sortName = "Insertion sort";
            break;
        case's':
            sortName = "Selection sort";
            break;
        case'm':
            sortName = "Merge sort";
            break;
        case'q':
            sortName = "Quick sort";
            break;
        case'h':
            sortName = "Heap sort";
            break;
        }
        System.out.println("First Element : " +shapes[0]);
        for (int i = 1000;i <= shapes.length;i += 1000) {
            System.out.println(i+ "th Element : " +shapes[i-1]);
        }
        System.out.println("last Element : " +shapes[shapes.length-1]);

        System.out.println(sortName +" run time :"+timeElapsed+" milliseconds");
    }
	
	/**
	 * Sorts array of shapes from passed arguments
	 * sorts by compare type first
	 * chooses sorting method based off sort type
	 */

	private void sortShapesFromFile() {
		switch(Character.toLowerCase(compareType)) {
		case 'h':
			switch(Character.toUpperCase(sortType)) {
				case 'B':
					SortManager.bubbleSort(shapes);
					break;
				case 'I':
					SortManager.insertionSort(shapes);
					break;
				case 'S':
					SortManager.selectionSort(shapes);
					break;
				case 'M':
					SortManager.mergeSort(shapes);
					break;
				case 'Q':
					SortManager.quickSort(shapes);
					break;
				case 'H':
					SortManager.heapSort(shapes);
					break;
				default:
					System.out.println("Incorrect sort method chosen, options are 'b', 'i', 's', 'm', 'q', and 'h' ");
					break;
				}
			break;
		case 'a':
			BaseAreaCompare bac = new BaseAreaCompare();
			switch(Character.toUpperCase(sortType)) {
				case 'B':
					SortManager.bubbleSort(shapes, bac);
					break;
				case 'I':
					SortManager.insertionSort(shapes, bac);
					break;
				case 'S':
					SortManager.selectionSort(shapes, bac);
					break;
				case 'M':
					SortManager.mergeSort(shapes, bac);
					break;
				case 'Q':
					SortManager.quickSort(shapes, bac);
					break;
				case 'H':
					SortManager.heapSort(shapes, bac);
					break;
				default:
					System.out.println("Incorrect sort method chosen, options are 'b', 'i', 's', 'm', 'q', and 'h' ");
					break;
			}
			break;
		case 'v':
			VolumeCompare vc = new VolumeCompare();
			switch(Character.toUpperCase(sortType)) {
				case 'B':
					SortManager.bubbleSort(shapes, vc);
					break;
				case 'I':
					SortManager.insertionSort(shapes, vc);
					break;
				case 'S':
					SortManager.selectionSort(shapes, vc);
					break;
				case 'M':
					SortManager.mergeSort(shapes, vc);
					break;
				case 'Q':
					SortManager.quickSort(shapes, vc);
					break;
				case 'H':
					SortManager.heapSort(shapes, vc);
					break;
				default:
					System.out.println("Incorrect sort method chosen, options are 'b', 'i', 's', 'm', 'q', and 'h' ");
					break;
			}
			break;
		default:
			System.out.println("No proper method selected, options are 'h', 'a', and 'v' ");
			break;
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
