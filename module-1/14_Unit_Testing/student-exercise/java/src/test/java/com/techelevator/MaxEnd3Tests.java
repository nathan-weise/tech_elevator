package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Tests {

    @Test
    public void getLucky_4_5_6() {

        int[] nums = new int[]{4, 5, 6};
        int[] nums1 = new int[]{6, 6, 6};

        MaxEnd3 sut = new MaxEnd3();

        int[] result = sut.makeArray(nums);

        Assert.assertEquals(nums, result);
    }

    @Test
    public void getLucky_7_11_8() {

        int[] nums = new int[]{7, 11, 8};
        int[] nums1 = new int[]{11, 11, 11};

        MaxEnd3 sut = new MaxEnd3();

        int[] result = sut.makeArray(nums);

        Assert.assertEquals(nums, result);

    }
}
