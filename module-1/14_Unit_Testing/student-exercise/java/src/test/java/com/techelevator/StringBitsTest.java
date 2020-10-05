package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
    @Test
    public void getBits_bandage_bnae(){
        StringBits sut = new StringBits();

        String result = sut.getBits("bandage");

        Assert.assertEquals("bnae", result);
    }
    @Test
    public void getBits_null_(){
        StringBits sut = new StringBits();

        String result = sut.getBits("");

        Assert.assertEquals("", result);
    }
}
