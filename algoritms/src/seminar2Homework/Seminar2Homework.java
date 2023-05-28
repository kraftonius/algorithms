package seminar2Homework;

import java.util.*;

public class Seminar2Homework {

    public static void main(String[] args) {
        int[] myArray = new int[32];
        Random rnd = new Random();
        for (int i = 0; i < myArray.length; i++) myArray[i] = rnd.nextInt(100);
        System.out.println(Arrays.toString(myArray));
        heapSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void heapSort(int arr[]) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) makeHeap(arr, len, i); //
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            makeHeap(arr, i, 0);
        }
    }

    public static void makeHeap(int arr[], int len, int index)
    {
        int max = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2; 
        if (left < len && arr[left] > arr[max])
            max = left;
        if (right < len && arr[right] > arr[max])
            max = right;
        if (max != index)
        {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            makeHeap(arr, len, max);
        }
    }     
}