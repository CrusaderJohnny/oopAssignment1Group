package utilities;

import java.util.Comparator;

/**
 * Sorting Class that holds all sorting methods for the application
 */


public class SortManager {
	
	/**
	 * Takes an array and sorts using the bubble sort method
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */

	public static <T extends Comparable<T>>void bubbleSort(T[] arr) {
		boolean swap;
		for (int i = 0; i < arr.length - 1; i++) {
			swap = false;
			for(int k = 0; k < arr.length - i - 1; k++) {
				if(arr[k].compareTo(arr[k + 1]) > 0) {
					T hold = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = hold;
					swap = true;
				}
			}
			//no swaps in inner loop, break out 
			if(!swap) {
				break;
			}
		}
	}
	
	/**
	 * Bubble sort method that takes an array and comparator method
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */

	public static <T> void bubbleSort(T[] arr, Comparator<T> c) {
		boolean swap;
		for (int i = 0; i < arr.length - 1; i++) {
			swap = false;
			for(int k = 0; k < arr.length - i - 1; k++) {
				if(c.compare(arr[k], arr[k+1])> 0) {
					T hold = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = hold;
					swap = true;
				}
			}
			//no swaps in inner loop, break out 
			if(!swap) {
				break;
			}
		}
	}
	
	/**
	 * Insertion sort method taking an array of objects
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			T key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].compareTo(key) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	
	/**
	 * Insertion sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void insertionSort(T[] arr, Comparator<T> c) {
		for (int i = 1; i < arr.length; i++) {
			T key = arr[i];
			int j = i - 1;
			while (j >= 0 && c.compare(arr[j], key) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
	
	/**
	 * Selection sort method taking an array of objects
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			T temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
	
	/**
	 * Selection sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void selectionSort(T[] arr, Comparator<T> c) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (c.compare(arr[j], arr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			T temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
	
	/**
	 * Merge sort method taking an array of objects
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */
	public static <T extends Comparable<T>> void mergeSort(T[] arr) {
		// to do
	}
	
	/**
	 * Merge sort method taking and array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void mergeSort(T[] arr, Comparator<T> c) {
		// to do
	}
	
	/**
	 * Quick Sort Method taking an array of objects
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		// to do
	}
	
	/**
	 * Quick sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void quickSort(T[] arr, Comparator<T> c) {
		// to do
	}


	/**
	 * Heap sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void heapSort(T[] arr, Comparator<T> c) {
	    int n = arr.length;

	    // Build max heap
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(arr, n, i, c);
	    }

	    // Extract elements one by one
	    for (int i = n - 1; i > 0; i--) {
	        swap(arr, 0, i);
	        heapify(arr, i, 0, c);
	    }
	}

	/**
	 * Heapify method for Comparable version
	 */
	private static <T extends Comparable<T>> void heapify(T[] arr, int n, int i) {
	    int largest = i;
	    int l = 2 * i + 1; // Left child
	    int r = 2 * i + 2; // Right child

	    if (l < n && arr[l].compareTo(arr[largest]) > 0) {
	        largest = l;
	    }
	    if (r < n && arr[r].compareTo(arr[largest]) > 0) {
	        largest = r;
	    }
	    if (largest != i) {
	        swap(arr, i, largest);
	        heapify(arr, n, largest);
	    }
	}

	/**
	 * Heapify method for Comparator version
	 */
	private static <T> void heapify(T[] arr, int n, int i, Comparator<T> c) {
	    int largest = i;
	    int l = 2 * i + 1; // Left child
	    int r = 2 * i + 2; // Right child

	    if (l < n && c.compare(arr[l], arr[largest]) > 0) {
	        largest = l;
	    }
	    if (r < n && c.compare(arr[r], arr[largest]) > 0) {
	        largest = r;
	    }
	    if (largest != i) {
	        swap(arr, i, largest);
	        heapify(arr, n, largest, c);
	    }
	}

	/**
	 * Swap utility function
	 */
	private static <T> void swap(T[] arr, int i, int j) {
	    T temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

}