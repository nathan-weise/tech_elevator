package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests {
    @Test
    public void isItTheSame_3_5_7_9_false() {

        SameFirstLast sut = new SameFirstLast();

        boolean result = sut.isItTheSame(new int[] {3, 5, 7, 9});

        Assert.assertEquals(false, result);
    }
    @Test
    public void isItTheSame_11_1_20_11_true() {

        SameFirstLast sut = new SameFirstLast();

        boolean result = sut.isItTheSame(new int[] {11, 1, 20, 11});

        Assert.assertEquals(true, result);
    }
}

