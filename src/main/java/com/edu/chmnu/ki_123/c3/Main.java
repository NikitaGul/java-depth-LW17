package com.edu.chmnu.ki_123.c3;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static boolean isSorted(int[] array) {
        if (array.length < 2) {
            return true;
        }

        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                isAscending = false;
            }
            if (array[i] > array[i - 1]) {
                isDescending = false;
            }
        }

        return isAscending || isDescending;
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static int[] countSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int[] count = new int[max - min + 1];
        for (int num : array) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[index++] = i + min;
            }
        }
        return array;
    }

    public static int binarySearchIterative(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, right);
        }
        return binarySearchRecursive(array, target, left, mid - 1);
    }


    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 0; i <= 1000; i++) {
            System.out.println("Factorial of " + i + ": " + factorial(i));
        }

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        if(isSorted(arr)){
            System.out.println(Arrays.toString(arr));
        }
        else{
            System.out.println("Arrays is not sorted");
        }

        int[] arr2 = {1, 5, 7, 3, 4, 9, 10, 5, 11, 8};
        long start1 = System.nanoTime();
        selectSort(arr2);
        long selectionSortTime1 = System.nanoTime() - start1;
        System.out.println(Arrays.toString(arr2));
        System.out.println(selectionSortTime1 + "ns");

        int[] arr3 = {1, 4, 3, 2, 7, 5, 20, 2, 5};
        long start2 = System.nanoTime();
        countSort(arr3);
        long countingSortTime2 = System.nanoTime() - start2;
        System.out.println(Arrays.toString(arr3));
        System.out.println(countingSortTime2 + "ns");

        int[] arr4 = {1, 4, 6, 7, 8, 9, 10, 11, 15};
        int element = 6;

        System.out.println("Iterative search " + binarySearchIterative(arr4, element));
        System.out.println("Recursive  search " + binarySearchRecursive(arr4, element, 0, arr4.length - 1));

    }
}