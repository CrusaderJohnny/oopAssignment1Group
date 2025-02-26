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
			if(swap = false) {
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
			if(swap = false) {
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
		//to do
	}
	
	/**
	 * Insertion sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void insertionSort(T[] arr, Comparator<T> c) {
		// to do
	}
	
	/**
	 * Selection sort method taking an array of objects
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		// to do
	}
	
	/**
	 * Selection sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void selectionSort(T[] arr, Comparator<T> c) {
		// to do
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
	 * Heap sort method taking an array of objects
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */
	public static <T extends Comparable<T>> void heapSort(T[] arr) {
		// to do
	}
	
	/**
	 * Heap sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void heapSort(T[] arr, Comparator<T> c) {
		// to do
	}
}
