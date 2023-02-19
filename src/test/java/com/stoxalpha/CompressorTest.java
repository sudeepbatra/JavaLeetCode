package com.stoxalpha;

import org.junit.Assert;
import org.junit.Test;

public class CompressorTest {

    @Test
    public void compressor() {
        Compressor compressor = new Compressor();
        Assert.assertEquals("a3b2", compressor.compress("aaabb"));
    }
}
