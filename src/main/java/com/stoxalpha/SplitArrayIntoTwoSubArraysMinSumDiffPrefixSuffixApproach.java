package com.stoxalpha;

import java.util.Arrays;

public class SplitArrayIntoTwoSubArraysMinSumDiffPrefixSuffixApproach {

    public static void main(String[] args) {
        SplitArrayIntoTwoSubArraysMinSumDiffPrefixSuffixApproach splitArrayIntoTwoSubArraysMinSumDiff = new SplitArrayIntoTwoSubArraysMinSumDiffPrefixSuffixApproach();
        int[] arr = {7, 9, 5, 10};
        int index = splitArrayIntoTwoSubArraysMinSumDiff.split(arr);
        int[] subArray1 = Arrays.copyOfRange(arr, 0, index+1);
        int[] subArray2 = Arrays.copyOfRange(arr, index+1, arr.length);
        System.out.println(index);
        System.out.println(Arrays.toString(subArray1));
        System.out.println(Arrays.toString(subArray2));
    }

    //Prefix and Suffix Sum array technique. Generate the prefix and suffix sum array of the give array. Iterate over
    //the array and print the minimum difference between the prefix_sum[i] and suffix_sum[i+1] for any index i (0<=i<=N -1)
    // from the array
    //Time complexity: O(N)
    //Auxiliary space: O(N)
    private int split(int[] arr) {
        int index = -1;
        int n = arr.length;

        int[] prefix_sum = new int[n];
        prefix_sum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        int[] suffix_sum = new int[n];
        suffix_sum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix_sum[i] = suffix_sum[i+1] + arr[i];
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n-1; i++) {
            int diff = Math.abs(prefix_sum[i] - suffix_sum[i + 1]);

            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }

        return index;
    }
}
