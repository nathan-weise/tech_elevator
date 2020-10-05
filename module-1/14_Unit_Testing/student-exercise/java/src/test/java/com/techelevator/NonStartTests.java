package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests {

    @Test
    public void getPartialString_whole_grain_holegrain() {
        NonStart sus = new NonStart();

        String result = sus.getPartialString("whole", "grain");

        Assert.assertEquals("holerain", result);
    }

    @Test
    public void getPartialString_a_b_ab() {
        NonStart sus = new NonStart();

        String result = sus.getPartialString("a", "b");

        Assert.assertEquals("", result);
    }

    @Test
    public void getPartialString_a_cat_at() {
        NonStart sus = new NonStart();

        String result = sus.getPartialString("", "cat");

        Assert.assertEquals("at", result);
    }

    @Test
    public void getPartialString_cat_a_at() {
        NonStart sus = new NonStart();

        String result = sus.getPartialString("cat", "");

        Assert.assertEquals("at", result);
    }
}
