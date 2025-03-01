package utilities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import shapes.Shapes;

public class SortManager {

	// Method to print the results of the sorting
	public static void printResult(Shapes[] shapes, char compareType) {
		for (int i = 0; i < shapes.length; i++) {
			// Determine if we should print this element
			if (i == 0 || i == shapes.length - 1 || (shapes.length > 1000 && i % 1000 == 0)) {
				//Label for element based on the position.
				String label = (i == 0) ? "First element is: "
						: (i == shapes.length - 1) ? "Last element is: " : String.format("%-7d-th element:", i);
				//Get sorted values 
				String sortedValues = (compareType == 'h' ? "Height: " + Double.toString(shapes[i].getHeight())
						: (compareType == 'v' ? "Volume: " + Double.toString(shapes[i].calcVolume())
								: ("Area: " + Double.toString(shapes[i].calcBaseArea()))));
				//prints the output
				System.out.printf("%s  %-18s %s%n", label, shapes[i].getClass().getSimpleName(), sortedValues);
			}
		}
	}

	//Bubble soort algorithm
	public static void bubbleSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		//starts with the time of sorting and the number of element in an array
		Integer n = shapes.length;

		//Iterate through the array.
		for (Integer i = 0; i < n - 1; i++) {
			boolean swapped = false;

			//Inner loop to compare and swap adjacent elements
			for (Integer j = 0; j < n - i - 1; j++) {

				//If comparator in null use the default
				//Else use the given
				if ((comparator == null && shapes[j].compareTo(shapes[j + 1]) < 0)
						|| (comparator != null && comparator.compare(shapes[j], shapes[j + 1]) > 0)) {

					Shapes temp = shapes[j];
					shapes[j] = shapes[j + 1];
					shapes[j + 1] = temp;
					swapped = true;
				}
			}

			//If no swaps were made in the inner loop, the array is sorted
			if (!swapped)
				break;
		}

	
	}

	//Insertion sort algorithm
	public static void insertionSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		//starts with the time of sorting and the number of element in an array
		int n = shapes.length;

		for (int i = 1; i < n; i++) {
			Shapes key = shapes[i];

			int j = i - 1;

			//Elements greater than the key are moved one position ahead.
			while (j >= 0 && ((comparator == null && shapes[j].compareTo(key) < 0)
					|| (comparator != null && comparator.compare(shapes[j], key) > 0))) {
				shapes[j + 1] = shapes[j];
				j--;
			}
			shapes[j + 1] = key;

		}

	}

	//Selection sort algorithm
	public static void selectionSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		//starts with the time of sorting and the number of element in an array
		int n = shapes.length;

		//outer loop assuming the current index as the minimum index
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			//inner loop to find the minimum element in the unsorted part of the array
			for (int j = i + 1; j < n; j++) {
				if ((comparator == null && shapes[j].compareTo(shapes[minIndex]) > 0)
						|| (comparator != null && comparator.compare(shapes[j], shapes[minIndex]) < 0)) {
					//Updates if any smaller element is found.
					minIndex = j;
				}
			}

			//Swaps the minimum element with the first element in an unsorted array
			Shapes temp = shapes[minIndex];
			shapes[minIndex] = shapes[i];
			shapes[i] = temp;

		}

		
	}

	//Merge sort algorithm
	public static void mergeSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		mergeSortRecursive(shapes, 0, shapes.length - 1, comparator);
		
	}

	//Recursive helper method
	private static void mergeSortRecursive(Shapes[] shapes, int left, int right, Comparator<Shapes> comparator) {
		if (left < right) {
			int mid = left + (right - left) / 2;

			// Recursively sort first and second halves
			mergeSortRecursive(shapes, left, mid, comparator);
			mergeSortRecursive(shapes, mid + 1, right, comparator);

			// Merge the sorted halves
			merge(shapes, left, mid, right, comparator);
		}
	}

	//merge two sorted arrays in one.
	private static void merge(Shapes[] shapes, int left, int mid, int right, Comparator<Shapes> comparator) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		// Create temporary arrays
		Shapes[] leftArray = new Shapes[n1];
		Shapes[] rightArray = new Shapes[n2];

		// Copy data to temp arrays
		System.arraycopy(shapes, left, leftArray, 0, n1);
		System.arraycopy(shapes, mid + 1, rightArray, 0, n2);

		int i = 0, j = 0, k = left;

		// Merge the temp arrays back into the main array
		while (i < n1 && j < n2) {
			if ((comparator == null && leftArray[i].compareTo(rightArray[j]) >= 0)
					|| (comparator != null && comparator.compare(leftArray[i], rightArray[j]) <= 0)) {
				shapes[k] = leftArray[i];
				i++;
			} else {
				shapes[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of leftArray[], if any
		while (i < n1) {
			shapes[k] = leftArray[i];
			i++;
			k++;
		}

		// Copy remaining elements of rightArray[], if any
		while (j < n2) {
			shapes[k] = rightArray[j];
			j++;
			k++;
		}
	}

	//Quick sort algorithm.
	public static void quickSort(Shapes[] shapes, Comparator<Shapes> comparator) {

		quickSortHelper(shapes, 0, shapes.length - 1, comparator);

		
	}

	//helper method for quick sort
	private static void quickSortHelper(Shapes[] shapes, int low, int high, Comparator<Shapes> comparator) {
		if (low < high) {
			int pivotIndex = randomizedPartition(shapes, low, high, comparator);

			//sorts the subarrays recursively.
			quickSortHelper(shapes, low, pivotIndex - 1, comparator);
			quickSortHelper(shapes, pivotIndex + 1, high, comparator);
		}
	}

	//partition method for quick sort
	private static int randomizedPartition(Shapes[] shapes, int low, int high, Comparator<Shapes> comparator) {
		Random rand = new Random();
		int randomPivotIndex = low + rand.nextInt(high - low + 1);
		swap(shapes, randomPivotIndex, high); // Move random pivot to end

		return partition(shapes, low, high, comparator);
	}

	//partition logic
	private static int partition(Shapes[] shapes, int low, int high, Comparator<Shapes> comparator) {
		Shapes pivot = shapes[high];
		int i = low - 1;

		//loops through and swaps the elements that are smaller than the pivot.
		for (int j = low; j < high; j++) {
			if ((comparator == null && shapes[j].compareTo(pivot) >= 0)
					|| (comparator != null && comparator.compare(shapes[j], pivot) <= 0)) {
				i++;
				swap(shapes, i, j);
			}
		}

		//swaps the pivot back in its correct position.
		swap(shapes, i + 1, high);
		return i + 1;
	}

	//swaps elements in the shapes array.
	private static void swap(Shapes[] shapes, int i, int j) {
		Shapes temp = shapes[i];
		shapes[i] = shapes[j];
		shapes[j] = temp;
	}

	
	/**
	 * Heap sort method taking an array of objects and a comparator
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static void heapSort(Shapes[] shapes, Comparator<Shapes> comparator) {
	    int n = shapes.length;

	    // Build max heap
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(shapes, n, i, comparator);
	    }

	    // Extract elements one by one
	    for (int i = n - 1; i > 0; i--) {
	        swap(shapes, 0, i);
	        heapify(shapes, i, 0, comparator);
	    }
	}

    /**
     * Heapifies a subtree rooted with node i which is an index in arr[]. n is size of heap.
     *
     * @param arr        The array to be heapified.
     * @param n          Size of the heap.
     * @param i          Index of the root of the subtree.
     * @param comparator The comparator to use for sorting.
     */
	private static void heapify(Shapes[] shapes, int n, int i, Comparator<Shapes> comparator) {
		int largest = i;
		int l = 2 * i + 1; // Left child
		int r = 2 * i + 2; // Right child
	
		// Compare left child
		if (l < n && ((comparator == null && shapes[l].compareTo(shapes[largest]) < 0) ||
					  (comparator != null && comparator.compare(shapes[l], shapes[largest]) > 0))) {
			largest = l;
		}
	
		// Compare right child
		if (r < n && ((comparator == null && shapes[r].compareTo(shapes[largest]) < 0) ||
					  (comparator != null && comparator.compare(shapes[r], shapes[largest]) > 0))) {
			largest = r;
		}
	
		// Swap and recursively heapify if needed
		if (largest != i) {
			swap(shapes, i, largest);
			heapify(shapes, n, largest, comparator);
		}
	}
}
