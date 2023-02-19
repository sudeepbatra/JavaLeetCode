package com.stoxalpha;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class URLIfyTest {

    @Test
    public void urlIfyTest() {
        URLConverter urlConverter = new URLConverter();
        assertEquals("My%20Home%20Page", urlConverter.urlIfy("My Home Page    ", 16));
    }
}
