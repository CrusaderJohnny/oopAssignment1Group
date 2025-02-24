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

	public static void insertionSort(Shapes[] shapes) {
		// TODO Auto-generated method stub
		
	}

	public static void selectionSort(Shapes[] shapes) {
		// TODO Auto-generated method stub
		
	}

	public static void mergeSort(Shapes[] shapes) {
		// TODO Auto-generated method stub
		
	}

	public static void quickSort(Shapes[] shapes) {
		// TODO Auto-generated method stub
		
	}

	public static void heapSort(Shapes[] shapes) {
		// TODO Auto-generated method stub
		
	}

	public static void insertionSort(Shapes[] shapes, BaseAreaCompare bac) {
		// TODO Auto-generated method stub
		
	}

	public static void selectionSort(Shapes[] shapes, BaseAreaCompare bac) {
		// TODO Auto-generated method stub
		
	}
	
	public static void mergeSort(Shapes[] shapes, BaseAreaCompare bac) {
		// TODO Auto-generated method stub
		
	}

	public static void quickSort(Shapes[] shapes, BaseAreaCompare bac) {
		// TODO Auto-generated method stub
		
	}

	public static void heapSort(Shapes[] shapes, BaseAreaCompare bac) {
		// TODO Auto-generated method stub
		
	}

	public static void insertionSort(Shapes[] shapes, VolumeCompare vc) {
		// TODO Auto-generated method stub
		
	}

	public static void selectionSort(Shapes[] shapes, VolumeCompare vc) {
		// TODO Auto-generated method stub
		
	}

	public static void mergeSort(Shapes[] shapes, VolumeCompare vc) {
		// TODO Auto-generated method stub
		
	}

	public static void quickSort(Shapes[] shapes, VolumeCompare vc) {
		// TODO Auto-generated method stub
		
	}

	public static void heapSort(Shapes[] shapes, VolumeCompare vc) {
		// TODO Auto-generated method stub
		
	}

}
