package utilities;

import java.util.Comparator;

import shapes.BaseAreaCompare;
import shapes.Shapes;
import shapes.VolumeCompare;

public class SortManager {

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
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		//to do
	}
	
	public static <T> void insertionSort(T[] arr, Comparator<T> c) {
		// to do
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		// to do
	}
	
	public static <T> void selectionSort(T[] arr, Comparator<T> c) {
		// to do
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] arr) {
		// to do
	}
	
	public static <T> void mergeSort(T[] arr, Comparator<T> c) {
		// to do
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		// to do
	}
	
	public static <T> void quickSort(T[] arr, Comparator<T> c) {
		// to do
	}
	
	public static <T extends Comparable<T>> void heapSort(T[] arr) {
		// to do
	}
	
	public static <T> void heapSort(T[] arr, Comparator<T> c) {
		// to do
	}
}
