package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTests {

    @Test
    public void getATable_you_1_date_5() {

        DateFashion sut = new DateFashion();

        int result = sut.getATable(1, 5);

        Assert.assertEquals(0, result);
    }

    @Test
    public void getATable_you_6_date_10() {

        DateFashion sut = new DateFashion();

        int result = sut.getATable(6, 10);

        Assert.assertEquals(2, result);
    }

    @Test
    public void getATable_you_5_date_5() {

        DateFashion sut = new DateFashion();

        int result = sut.getATable(5, 5);

        Assert.assertEquals(1, result);
    }
}
