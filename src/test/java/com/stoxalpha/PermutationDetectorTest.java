package com.stoxalpha;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationDetectorTest {

    @Test
    public void permutationOfTheOther() {
        PermutationDetector permutationDetector = new PermutationDetector();
        assertTrue(permutationDetector.isPermutation("abc", "cba"));
        assertFalse(permutationDetector.isPermutation("abc", "xyz"));
    }
}
