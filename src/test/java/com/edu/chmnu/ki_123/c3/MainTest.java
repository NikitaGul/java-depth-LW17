package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

   @Test
    void testZeroFactorial(){
       assertEquals(BigInteger.ONE, Main.factorial(0));
   }

    @Test
    void testOneFactorial() {
        assertEquals(BigInteger.ONE, Main.factorial(1));
    }

    @Test
    void testThreeDigitsFactorial() {
        assertEquals(BigInteger.valueOf(120), Main.factorial(5));
    }

    @Test
    void testStringFactorial() {
       assertEquals(new BigInteger("3628800"), Main.factorial(10));
    }

    @Test
    void testNotRightIsSorted() {
        assertFalse(Main.isSorted(new int[]{1, 3, 2, 4, 5}));
    }

    @Test
    void testOneElementIsSorted() {
        assertTrue(Main.isSorted(new int[]{1}));
    }

    @Test
    void testIsSorted() {
        assertTrue(Main.isSorted(new int[]{}));
        }

    @Test
    void testSelectSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        Main.selectSort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    void testCountSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] sortedArray = Main.countSort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, sortedArray);
    }

    @Test
    void testBinarySearchIterative() {
        int[] sortedArray = {1, 3, 5, 7, 9, 11};
        assertEquals(2, Main.binarySearchIterative(sortedArray, 5));
    }

    @Test
    void testBinarySearchRecursive() {
        int[] sortedArray = {1, 3, 5, 7, 9, 11};
        assertEquals(-1, Main.binarySearchRecursive(sortedArray, 4, 0, sortedArray.length - 1));
    }
    }