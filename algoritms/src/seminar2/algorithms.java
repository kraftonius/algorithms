package seminar2;

import java.util.*;

public class algorithms {
    static int cnt = 0;

    public static void main(String[] args) {
        int x = 1000 * 1000;
        int[] simpleList = new int[x];
        Random rnd = new Random();
        for (int i = 0; i < simpleList.length; i++)
            simpleList[i] = rnd.nextInt(100);
        long start = System.currentTimeMillis();
        //directSort(simpleList);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        for (int i = 0; i < simpleList.length; i++)
            simpleList[i] = rnd.nextInt(100);
        start = System.currentTimeMillis();
        //insertSort(simpleList);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        for (int i = 0; i < simpleList.length; i++)
            simpleList[i] = rnd.nextInt(100);
        start = System.currentTimeMillis();
        //quickSort(simpleList, 0, simpleList.length - 1);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        for (int i = 0; i < simpleList.length; i++) simpleList[i] = rnd.nextInt(100);
        quickSort(simpleList, 0, simpleList.length - 1);
        int a = simpleList[new Random().nextInt(simpleList.length)];
        start = System.nanoTime();
        binarySearch(simpleList, a);
        end = System.nanoTime();
        System.out.println("binarySearch" + " " + (end - start));

        //for (int i = 0; i < simpleList.length; i++) simpleList[i] = rnd.nextInt(100);
        start = System.nanoTime();
        binarywo(simpleList, a);
        end = System.nanoTime();
        System.out.println("binarywo" + " " + (end - start));

        //for (int i = 0; i < simpleList.length; i++) simpleList[i] = rnd.nextInt(100);
        start = System.nanoTime();
        find(simpleList, a);
        end = System.nanoTime();
        System.out.println("find" + " " + (end - start));
    }

    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            if (i != minPos) {
                int temp = array[i];
                array[i] = array[minPos];
                array[minPos] = temp;
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int startPos, int endPos) {
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = array[startPos + (endPos - startPos) / 2];
        do {
            while (array[leftPos] < pivot) {
                leftPos++;
            }
            while (array[rightPos] > pivot) {
                rightPos--;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos < rightPos);
        if (leftPos < endPos)
            quickSort(array, leftPos, endPos);
        if (startPos < rightPos)
            quickSort(array, startPos, rightPos);
    }

    public static int binarySearch(int[] array, int value, int min, int max) {

        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }

    public static int binarywo(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while(s <= e) {
            int m = (e - s)/2 + s;
            if(nums[m] > target) {
                e = m - 1;
            }
            else if(nums[m] < target) {
                s = m + 1;
            }
            else return m;
        }
        return -1;
    }

    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}