package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {

    long executionTime = 0;
    /*
     * Please implement all the sorting algorithm. Feel free to add helper methods.
     * Store all the sorted data into one of the databases.
     */

    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        for (int j = 0; j < array.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        for (int i = 1; i < list.length; i++) {
            int j = i - 1, pass = list[i];
            while (j >= 0 && list[j] > pass) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = pass;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    public int[] bubbleSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        // This iteration will go through the array n times.
        for (int i = 0; i < list.length - 1; i++)
            // This iteration will keep "bubble-swapping"
            for (int j = 0; j < list.length - i - 1; j++)
                // If the curr elem is bigger than the next one, SWAP!
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    public int[] mergeSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        m_sort(list, list.length);

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    private void m_sort(int[] arr, int arrLength) {
        // If arrayLength is 1 then the array has been divided to 1 elements.
        if (arrLength <= 1) return;

        int mid = arrLength / 2;
        // Diving the array into 2.
        int[] left = new int[mid];
        int[] right = new int[arrLength - mid];

        // Add all of the lest side of the array to a new new array.
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        // Add all of the right side of the array to a new array.
        for (int i = mid; i < arrLength; i++)
            right[i - mid] = arr[i];

        // Recursively split the left and right side till you get arrays of size 1.
        m_sort(left, mid);
        m_sort(right, arrLength - mid);

        // Merging the arrays together after the division.
        merge(arr, left, right, mid, arrLength - mid);
    }

    private void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int leftIndex = 0, rightIndex = 0, origIndex = 0;

        // Comparing the elements of left array and right array.
        // Which is smaller will go into the current merged array.
        while (leftIndex < left && rightIndex < right) {
            if (leftArr[leftIndex] < rightArr[rightIndex])
                arr[origIndex++] = leftArr[leftIndex++];
            else
                arr[origIndex++] = rightArr[rightIndex++];
        }

        // If there is no more right array elements, keep adding the left array elements
        // to the merged array.
        while (leftIndex < left)
            arr[origIndex++] = leftArr[leftIndex++];

        // If there is no more left array elements, add the remaining right array elements.
        while (rightIndex < right)
            arr[origIndex++] = rightArr[rightIndex++];
    }

    public int[] quickSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        qSort(list, 0, list.length - 1);

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    private void qSort(int[] arr, int begin, int end) {
        if (begin < end) {
            // Find the partition to divide the array.
            int partition = partition(arr, begin, end);

            qSort(arr, begin, partition - 1);
            qSort(arr, partition + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        // Decided to use the last element as my pivot.
        int pivot = arr[end];
        int pivotCheck = begin - 1;
        int temp;

        for (int i = begin; i < end; i++) {
            // pivCheck will keep on moving till there is another element that needs to be swapped.
            if (arr[i] <= pivot) {
                pivotCheck++;

                temp = arr[pivotCheck];
                arr[pivotCheck] = arr[i];
                arr[i] = temp;
            }
        }

        // pivCheck is at the proper position where pivot should be.
        // Swap the pivot to it and then return a new partition.
        temp = arr[pivotCheck + 1];
        arr[pivotCheck + 1] = arr[end];
        arr[end] = temp;

        return pivotCheck + 1;
    }

    public int[] heapSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int[] list = array;
        int arrLength = list.length;

        // Bring the largest element in the heap to the root
        for (int i = (arrLength / 2) - 1; i >= 0; i--)
            maxHeapify(list, arrLength, i);

        // Swap the max to the end of the array so it can be in the "sorted" side of the array.
        for (int i = arrLength - 1; i >= 0; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;

            maxHeapify(list, i, 0);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    private static void maxHeapify(int[] arr, int arrLength, int i) {
        int maxIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        // If a left node is greater than the current node, change maxIndex.
        if (leftIndex < arrLength && arr[leftIndex] > arr[maxIndex])
            maxIndex = leftIndex;

        // If a right node is greater than the current node, change maxIndex.
        if (rightIndex < arrLength && arr[rightIndex] > arr[maxIndex])
            maxIndex = rightIndex;


        if (maxIndex != i) {
            int swap = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = swap;

            maxHeapify(arr, arrLength, maxIndex);
        }
    }

    public int[] bucketSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int[] list = array;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for (int x : list)
            tempList.add(Integer.valueOf(x));

        // Finding the maxVal to better determine the bucket size.
        int maxVal = Collections.max(tempList);

        int[] buckets = new int[maxVal + 1];
        // Filling all elements in buckets with 0.
        Arrays.fill(buckets, 0);

        // Adding 1 in the buckets array where the index is the element of list[i].
        for (int i = 0; i < list.length; i++)
            buckets[list[i]]++;

        int k = 0;
        for (int i = 0; i < buckets.length; i++)
            for (int j = 0; j < buckets[i]; j++)
                // Adding the indices which are the numbers in the orig array back to list.
                list[k++] = i;


        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    public int[] shellSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int[] list = array;

        // Starting gap as half of the length.
        for (int gap = list.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < list.length; i++) {
                int j, temp = list[i];
                // shifting till list[i]
                for (j = i; j >= gap && list[j - gap] > temp; j -= gap)
                    list[j] = list[j - gap];

                // temp is in the proper place.
                list[j] = temp;
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);

    }
}
