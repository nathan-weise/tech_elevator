package com.techelevator;

import java.math.BigDecimal;

public class FlowerShopOrder {

    private String bouquetType;
    private int numberOfRoses;
    private BigDecimal subtotal;

    public FlowerShopOrder(String bouquetType, int numberOfRoses) {
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
    }

    public BigDecimal deliveryTotal(Boolean sameDayDelivery, String zipCode) {
        BigDecimal deliveryFee = BigDecimal.ZERO;
        int zipCodeAsInt = Integer.parseInt(zipCode);
        if (zipCodeAsInt >= 20000 && zipCodeAsInt <= 29999) {
            deliveryFee = deliveryFee.add(BigDecimal.valueOf(3.99));
            {
                if (sameDayDelivery) {
                    deliveryFee = deliveryFee.add(BigDecimal.valueOf(5.99));
                }
            }
        } else if (zipCodeAsInt >= 30000 && zipCodeAsInt <= 39999) {
            deliveryFee = deliveryFee.add(BigDecimal.valueOf(6.99));
            {
                if (sameDayDelivery) {
                    deliveryFee = deliveryFee.add(BigDecimal.valueOf(5.99));
                }
            }
        } else if (zipCodeAsInt >= 10000 && zipCodeAsInt <= 19999) {
            deliveryFee = deliveryFee.add(BigDecimal.valueOf(0.00));
        } return BigDecimal.ZERO;
    }

    public String getBouquetType() {
        return bouquetType;
    }

    public void setBouquetType(String bouquetType) {
        this.bouquetType = bouquetType;
    }

    public int getNumberOfRoses() {
        return numberOfRoses;
    }

    public void setNumberOfRoses(int numberOfRoses) {
        this.numberOfRoses = numberOfRoses;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public static void main(String[] args) {

        FlowerShopOrder g = new FlowerShopOrder("Sorry", 2);

        System.out.println(g);


    }
}
