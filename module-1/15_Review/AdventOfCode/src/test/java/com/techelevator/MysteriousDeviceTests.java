package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MysteriousDeviceTests {

    private MysteriousDevice sut;

    @Before
    public void setup() {
        //Arrange
        sut = new MysteriousDevice();
    }

    @Test
    public void device_frequency_starts_at_zero() {
        //Act
        int result = sut.getCurrentFrequency();
        //Assert
        Assert.assertEquals(0, result);
    }

    @Test
    public void device_frequency_can_be_changed_to_1() {
        sut.adjustFrequency(+1);
        int result = sut.getCurrentFrequency();

        Assert.assertEquals(1, result);
    }

    @Test
    public void device_frequency_can_be_changed_repeatedly() {
        sut.adjustFrequency(+1);
        sut.adjustFrequency(+1);
        sut.adjustFrequency(+1);

        Assert.assertEquals(3, sut.getCurrentFrequency());
    }

    @Test
    public void device_frequency_can_be_changed_repeatedly_with_negative_numbers() {
        sut.adjustFrequency(-1);
        sut.adjustFrequency(-2);
        sut.adjustFrequency(-3);

        Assert.assertEquals(-6, sut.getCurrentFrequency());
    }

    @Test
    public void device_accepts_array_of_frequency_changes() {
        sut.adjustFrequency(new int[] {+1, +1, -1});

        Assert.assertEquals(1, sut.getCurrentFrequency());
    }

    @Test
    public void provided_test_cases_return_correct_results() {
        sut.adjustFrequency(new int[] {+1, +1, +1});
        Assert.assertEquals(3, sut.getCurrentFrequency());

        sut = new MysteriousDevice();
        sut.adjustFrequency(new int[] {+1, +1, -2});
        Assert.assertEquals(0, sut.getCurrentFrequency());

        sut = new MysteriousDevice();
        sut.adjustFrequency(new int[] {-1, -2, -3});
        Assert.assertEquals(-6, sut.getCurrentFrequency());
    }

}
