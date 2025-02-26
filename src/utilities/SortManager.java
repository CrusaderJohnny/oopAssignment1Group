package utilities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import shapes.Shapes;

public class SortManager {

	public static void printResult(Shapes[] shapes, char compareType) {
		for (int i = 0; i < shapes.length; i++) {
			// Determine if we should print this element
			if (i == 0 || i == shapes.length - 1 || (shapes.length > 1000 && i % 1000 == 0)) {
				String label = (i == 0) ? "First element is: "
						: (i == shapes.length - 1) ? "Last element is: " : String.format("%-7d-th element:", i);

				String sortedValues = (compareType == 'h' ? "Height: " + Double.toString(shapes[i].getHeight())
						: (compareType == 'v' ? "Volume: " + Double.toString(shapes[i].calcVolume())
								: ("Area: " + Double.toString(shapes[i].calcBaseArea()))));

				System.out.printf("%s  %-18s %s%n", label, shapes[i].getClass().getSimpleName(), sortedValues);
			}
		}
	}

	public static void bubbleSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		long start = System.currentTimeMillis();
		Integer n = shapes.length;

		for (Integer i = 0; i < n - 1; i++) {
			boolean swapped = false;

			for (Integer j = 0; j < n - i - 1; j++) {

				if ((comparator == null && shapes[j].compareTo(shapes[j + 1]) < 0)
						|| (comparator != null && comparator.compare(shapes[j], shapes[j + 1]) > 0)) {

					Shapes temp = shapes[j];
					shapes[j] = shapes[j + 1];
					shapes[j + 1] = temp;
					swapped = true;
				}
			}

			if (!swapped)
				break;
		}

		long end = System.currentTimeMillis();
		System.out.println("-------------------------------------------------Time taken by Bubble sort is "
				+ (end - start) + " millis");
	}

	public static void insertionSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		long start = System.currentTimeMillis();
		int n = shapes.length;

		for (int i = 1; i < n; i++) {
			Shapes key = shapes[i];

			int j = i - 1;

			if (i % 10000 == 0) {
				System.out.println(i + " elements sorted, time: " + (System.currentTimeMillis() - start) + " ms");
			}
			while (j >= 0 && ((comparator == null && shapes[j].compareTo(key) < 0)
					|| (comparator != null && comparator.compare(shapes[j], key) > 0))) {
				shapes[j + 1] = shapes[j];
				j--;
			}
			shapes[j + 1] = key;

		}

		long end = System.currentTimeMillis();
		System.out.println("-------------------------------------------------Time taken by Insertion Sort: "
				+ (end - start) + " ms");
	}

	public static void selectionSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		long start = System.currentTimeMillis();
		int n = shapes.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if ((comparator == null && shapes[j].compareTo(shapes[minIndex]) > 0)
						|| (comparator != null && comparator.compare(shapes[j], shapes[minIndex]) < 0)) {
					minIndex = j;
				}
			}

			Shapes temp = shapes[minIndex];
			shapes[minIndex] = shapes[i];
			shapes[i] = temp;

		}

		long end = System.currentTimeMillis();
		System.out.println("-------------------------------------------------Time taken by Selection Sort: "
				+ (end - start) + " ms");
	}

	public static void mergeSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		long start = System.currentTimeMillis();
		mergeSortRecursive(shapes, 0, shapes.length - 1, comparator);
		long end = System.currentTimeMillis();
		System.out.println(
				"-------------------------------------------------Time taken by Merge Sort: " + (end - start) + " ms");
	}

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

	public static void quickSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		long start = System.currentTimeMillis();

		quickSortHelper(shapes, 0, shapes.length - 1, comparator);

		long end = System.currentTimeMillis();
		System.out.println(
				"-------------------------------------------------Time taken by Quick Sort: " + (end - start) + " ms");
	}

	private static void quickSortHelper(Shapes[] shapes, int low, int high, Comparator<Shapes> comparator) {
		if (low < high) {
			int pivotIndex = randomizedPartition(shapes, low, high, comparator);

			quickSortHelper(shapes, low, pivotIndex - 1, comparator);
			quickSortHelper(shapes, pivotIndex + 1, high, comparator);
		}
	}

	private static int randomizedPartition(Shapes[] shapes, int low, int high, Comparator<Shapes> comparator) {
		Random rand = new Random();
		int randomPivotIndex = low + rand.nextInt(high - low + 1);
		swap(shapes, randomPivotIndex, high); // Move random pivot to end

		return partition(shapes, low, high, comparator);
	}

	private static int partition(Shapes[] shapes, int low, int high, Comparator<Shapes> comparator) {
		Shapes pivot = shapes[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if ((comparator == null && shapes[j].compareTo(pivot) >= 0)
					|| (comparator != null && comparator.compare(shapes[j], pivot) <= 0)) {
				i++;
				swap(shapes, i, j);
			}
		}

		swap(shapes, i + 1, high);
		return i + 1;
	}

	private static void swap(Shapes[] shapes, int i, int j) {
		Shapes temp = shapes[i];
		shapes[i] = shapes[j];
		shapes[j] = temp;
	}

	public static void timSort(Shapes[] shapes, Comparator<Shapes> comparator) {
		long start = System.currentTimeMillis();

		Arrays.sort(shapes, comparator.reversed());

		long end = System.currentTimeMillis();
		System.out.println("Time taken by TimSort (Arrays.sort()): " + (end - start) + " ms");
	}
}
