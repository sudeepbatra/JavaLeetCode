package com.stoxalpha;

import java.util.Arrays;

public class SplitArrayIntoTwoSubArraysMinSumDiff {

    public static void main(String[] args) {
        SplitArrayIntoTwoSubArraysMinSumDiff splitArrayIntoTwoSubArraysMinSumDiff = new SplitArrayIntoTwoSubArraysMinSumDiff();
        int[] arr = {7, 9, 5, 10};
        int index = splitArrayIntoTwoSubArraysMinSumDiff.split(arr);
        int[] subArray1 = Arrays.copyOfRange(arr, 0, index+1);
        int[] subArray2 = Arrays.copyOfRange(arr, index+1, arr.length);
        System.out.println(index);
        System.out.println(Arrays.toString(subArray1));
        System.out.println(Arrays.toString(subArray2));
    }

    // Efficient approach - calculate the total sum of the array elements.
    // Calculate the prefix_sum of the left side array
    // suffix_sum = total_sum - prefix_sum
    // Difference = Math.abs((total_sum - prefix_sum) - prefix_sum)
    private int split(int[] arr) {
        int index = -1;
        int sum_total = Arrays.stream(arr).sum();
        int prefix_sum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];
            int diff = Math.abs((sum_total - prefix_sum) - prefix_sum);

            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }

        return index;
    }
}
