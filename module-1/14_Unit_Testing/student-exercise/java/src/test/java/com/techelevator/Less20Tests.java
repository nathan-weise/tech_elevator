package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests {

    @Test
    public void isLessThanMultipleOf20_39() {
        Less20 sut = new Less20();

        boolean result = sut.isLessThanMultipleOf20(39);

        Assert.assertEquals(true, result);
    }

    @Test
    public void isLessThanMultipleOf20_38() {
        Less20 sut = new Less20();

        boolean result = sut.isLessThanMultipleOf20(38);

        Assert.assertEquals(true, result);

    }

    @Test
    public void isLessThanMultipleOf20_37() {
        Less20 sut = new Less20();

        boolean result = sut.isLessThanMultipleOf20(37);

        Assert.assertEquals(false, result);
    }
}
