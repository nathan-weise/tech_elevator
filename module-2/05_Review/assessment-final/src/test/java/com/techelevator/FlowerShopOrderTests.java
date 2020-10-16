package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FlowerShopOrderTests {

    private static final BigDecimal BOUQUET_PRICE = new BigDecimal("19.99");
    private static final BigDecimal ROSE_PRICE = new BigDecimal("2.99");

    @Test
    public void subtotal_for_no_roses_is_base() {
        FlowerShopOrder sut = new FlowerShopOrder("Test", 0);
        Assert.assertEquals(BOUQUET_PRICE, sut.getSubtotal());
    }

    @Test
    public void subtotal_for_one_rose_is_correct() {
        FlowerShopOrder sut = new FlowerShopOrder("Test", 1);
        BigDecimal expected = BOUQUET_PRICE.add(ROSE_PRICE);
        Assert.assertEquals(expected, sut.getSubtotal());
    }

    @Test
    public void subtotal_for_ten_roses_is_correct() {
        FlowerShopOrder sut = new FlowerShopOrder("Test", 10);
        BigDecimal expected = BOUQUET_PRICE;
        expected = expected.add(ROSE_PRICE.multiply(BigDecimal.TEN));
        Assert.assertEquals(expected, sut.getSubtotal());
    }

    @Test
    public void delivery_fee_for_zone1_is_correct() {
        FlowerShopOrder sut = new FlowerShopOrder("Test", 0);
        BigDecimal actual = sut.deliveryTotal(false, "10000");
        BigDecimal expected = new BigDecimal("0.00");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(true, "10000");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delivery_fee_for_zone2_is_correct() {
        FlowerShopOrder sut = new FlowerShopOrder("Test", 0);
        BigDecimal actual = sut.deliveryTotal(false, "20000");
        BigDecimal expected = new BigDecimal("3.99");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(true, "20000");
        expected = expected.add(new BigDecimal("5.99"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delivery_fee_for_zone3_is_correct() {
        FlowerShopOrder sut = new FlowerShopOrder("Test", 0);
        BigDecimal actual = sut.deliveryTotal(false, "30000");
        BigDecimal expected = new BigDecimal("6.99");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(true, "30000");
        expected = expected.add(new BigDecimal("5.99"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delivery_fee_for_other_zones_is_correct() {
        FlowerShopOrder sut = new FlowerShopOrder("Test", 0);
        BigDecimal actual = sut.deliveryTotal(false, "40000");
        BigDecimal expected = new BigDecimal("19.99");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(true, "40000");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(false, "01000");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(true, "01000");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(false, "90000");
        Assert.assertEquals(expected, actual);
        actual = sut.deliveryTotal(true, "90000");
        Assert.assertEquals(expected, actual);
    }

}
