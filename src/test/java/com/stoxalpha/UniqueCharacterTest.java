package com.stoxalpha;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueCharacterTest {

    @Test
    public void uniqueCharacters() {
        UniqueCharDetector uniqueCharDetector = new UniqueCharDetector();
        assertTrue(uniqueCharDetector.isUnique("ab"));
        assertFalse(uniqueCharDetector.isUnique("aa"));
        assertTrue(uniqueCharDetector.isUnique("abcdefghijklmnopqrstuvwxyz"));
    }
}
