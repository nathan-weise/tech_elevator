package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Tests {

    @Test
    public void getLucky_0_1_2() {

        int[] nums = new int[]{0, 1, 2};

        Lucky13 sut = new Lucky13();

        boolean result = sut.getLucky(nums);

        Assert.assertEquals(false, result);

    }

    @Test
    public void getLucky_0_4_5() {

        int[] nums = new int[]{0, 4, 5};

        Lucky13 sut = new Lucky13();

        boolean result = sut.getLucky(nums);

        Assert.assertEquals(true, result);
    }
}

