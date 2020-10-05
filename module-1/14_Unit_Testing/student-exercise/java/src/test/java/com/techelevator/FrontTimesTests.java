package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTests {

    @Test
    public void generateString_ChoChoCho() {

        FrontTimes sut = new FrontTimes();

        String result = sut.generateString("Chocolate", 3);

        Assert.assertEquals("ChoChoCho", result);

    }

    @Test
    public void generateString_CoCoCo() {

        FrontTimes sut = new FrontTimes();

        String result = sut.generateString("Co", 4);

        Assert.assertEquals("CoCoCoCo", result);

    }

    @Test
    public void generateString_null() {

        FrontTimes sut = new FrontTimes();

        String result = sut.generateString(null, 3);

        Assert.assertEquals("", result);

    }
}
