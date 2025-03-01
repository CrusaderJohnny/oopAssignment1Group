package utilities;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

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
		if( arr == null || arr.length <= 1) {
			return;
		}
		int n = arr.length;
		T[] temp = Arrays.copyOf(arr, n);
		mergeSort(arr, temp, 0, n-1);
	}
	
    /**
     * Recursive helper function for merge sort.
     *
     * @param arr   The array to be sorted.
     * @param temp  The temporary array for merging.
     * @param left  The left index of the subarray.
     * @param right The right index of the subarray.
     * @param <T>   The type of objects in the array.
     */
	private static <T extends Comparable<T>> void mergeSort(T[] arr, T[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }
	
	 /**
     * Merges two sorted subarrays into a single sorted subarray.
     *
     * @param arr   The array containing the subarrays.
     * @param temp  The temporary array for merging.
     * @param left  The left index of the first subarray.
     * @param mid   The right index of the first subarray.
     * @param right The right index of the second subarray.
     * @param <T>   The type of objects in the array.
     */
	private static <T extends Comparable<T>> void merge(T[] arr, T[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i]; // Copy elements to the temporary array
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }

	
	/**
	 * Merge sort method taking and array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void mergeSort(T[] arr, Comparator<T> c) {
		if( arr == null || arr.length <= 1) {
			return;
		}
		int n = arr.length;
		T[] temp = Arrays.copyOf(arr, n);
		mergeSort(arr, temp , 0, n-1, c);
	}
	
	/**
     * Recursive helper function for merge sort with a custom comparator.
     *
     * @param arr        The array to be sorted.
     * @param temp       The temporary array for merging.
     * @param left       The left index of the subarray.
     * @param right      The right index of the subarray.
     * @param comparator The comparator to use for sorting.
     * @param <T>        The type of objects in the array.
     */
    private static <T> void mergeSort(T[] arr, T[] temp, int left, int right, Comparator<T> c) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid, c);
            mergeSort(arr, temp, mid + 1, right, c);
            merge(arr, temp, left, mid, right, c);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray with a custom comparator.
     *
     * @param arr        The array containing the subarrays.
     * @param temp       The temporary array for merging.
     * @param left       The left index of the first subarray.
     * @param mid        The right index of the first subarray.
     * @param right      The right index of the second subarray.
     * @param comparator The comparator to use for sorting.
     * @param <T>        The type of objects in the array.
     */
    private static <T> void merge(T[] arr, T[] temp, int left, int mid, int right, Comparator<T> c) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i]; // Copy elements to the temporary array
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (c.compare(temp[i], temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
	
	/**
	 * Quick Sort Method taking an array of objects
	 * @param <T> Takes Object class
	 * @param arr array of objects
	 */
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		if ( arr == null || arr.length <= 1 ) {
			return;
		}
		quickSort(arr,0,arr.length-1);
	}
	
	 /**
     * Recursive helper function for quicksort (natural ordering).
     *
     * @param arr  The array to be sorted.
     * @param low  The low index of the subarray.
     * @param high The high index of the subarray.
     * @param <T>  The type of objects in the array.
     */
    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the subarray and returns the pivot index (natural ordering).
     *
     * @param arr  The array to be partitioned.
     * @param low  The low index of the subarray.
     * @param high The high index of the subarray.
     * @param <T>  The type of objects in the array.
     * @return The pivot index.
     */
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        // Choose a random pivot (to avoid worst-case scenarios)
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        T pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high); // Move pivot to the end

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Move pivot to its correct position
        return i + 1;
    }

	
	/**
	 * Quick sort method taking an array of objects and a comparator
	 * @param <T> Object class
	 * @param arr Array of objects
	 * @param c Passed comparator method
	 */
	public static <T> void quickSort(T[] arr, Comparator<T> c) {
		if ( arr == null || arr.length <= 1) {
			return;
		}
		quickSort(arr, 0, arr.length - 1, c);
	}
	
	 /**
     * Recursive helper function for quicksort with a custom comparator.
     *
     * @param arr        The array to be sorted.
     * @param low        The low index of the subarray.
     * @param high       The high index of the subarray.
     * @param comparator The comparator to use for sorting.
     * @param <T>        The type of objects in the array.
     */
    private static <T> void quickSort(T[] arr, int low, int high, Comparator<T> c) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, c);
            quickSort(arr, low, pivotIndex - 1, c);
            quickSort(arr, pivotIndex + 1, high, c);
        }
    }

    /**
     * Partitions the subarray and returns the pivot index.
     *
     * @param arr        The array to be partitioned.
     * @param low        The low index of the subarray.
     * @param high       The high index of the subarray.
     * @param comparator The comparator to use for sorting.
     * @param <T>        The type of objects in the array.
     * @return The pivot index.
     */
    private static <T> int partition(T[] arr, int low, int high, Comparator<T> c) {
        // Choose a random pivot (to avoid worst-case scenarios)
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        T pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high); // Move pivot to the end

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (c.compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Move pivot to its correct position
        return i + 1;
    }
    
    /**
     * Sorts an array of objects using the heapsort algorithm.
     *
     * @param arr The array of objects to be sorted.
     * @param <T> The type of objects in the array, which must implement Comparable.
     */
    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        heapSort(arr, Comparator.naturalOrder()); // Use natural ordering if no comparator is provided.
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
     * Heapifies a subtree rooted with node i which is an index in arr[]. n is size of heap.
     *
     * @param arr        The array to be heapified.
     * @param n          Size of the heap.
     * @param i          Index of the root of the subtree.
     * @param comparator The comparator to use for sorting.
     * @param <T>        The type of objects in the array.
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
     * Swaps two elements in the array.
     *
     * @param arr The array.
     * @param i   The index of the first element.
     * @param j   The index of the second element.
     * @param <T> The type of objects in the array.
     */
	private static <T> void swap(T[] arr, int i, int j) {
	    T temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

}