package com.stoxalpha;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayIntersector {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 4, 5, 6};
        int[] array2 = {2, 3, 5, 7};
        ArrayIntersector arrayIntersector = new ArrayIntersector();
        ArrayList<Integer> intersectBruteForce = arrayIntersector.intersectBruteForce(array1, array2);
        System.out.println(intersectBruteForce);

        ArrayList<Integer> intersect = arrayIntersector.intersect(array1, array2);
        System.out.println(intersect);
    }

    //O(n*m)
    private ArrayList<Integer> intersectBruteForce(int[] array1, int[] array2) {
        ArrayList<Integer> collector = new ArrayList<>();

        //O(n)
        for (int i: array1) {
            //O(m)
            for (int j: array2)  {
                if (i == j) {
                    collector.add(i);
                }
            }
        }

        return collector;
    }

    //O(n) or O(m)
    private ArrayList<Integer> intersect(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int m = array1.length;
        int n = array2.length;

        ArrayList<Integer> collector = new ArrayList<>();

        while (i < m && j < n) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array2[j] < array1[i]) {
                j++;
            } else {
                collector.add(array1[i]);
                i++;
            }
        }

        return collector;
    }
}

