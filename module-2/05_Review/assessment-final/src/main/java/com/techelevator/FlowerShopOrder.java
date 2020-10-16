package com.techelevator;

import java.math.BigDecimal;

public class FlowerShopOrder {
    public static final BigDecimal BASE_BOUQUET_COST = new BigDecimal("19.99");
    public static final BigDecimal COST_PER_ROSE = new BigDecimal("2.99");

    private final String bouquetType;
    private final int numberOfRoses;

    public FlowerShopOrder(String bouquetType, int numberOfRoses) {
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
    }

    public String getBouquetType() {
        return bouquetType;
    }

    public int getNumberOfRoses() {
        return numberOfRoses;
    }

    public BigDecimal getSubtotal() {
        BigDecimal roseTotal = COST_PER_ROSE.multiply(BigDecimal.valueOf(numberOfRoses));
        return BASE_BOUQUET_COST.add(roseTotal);
    }

    public BigDecimal deliveryTotal(boolean sameDayDelivery, String zipCode) {
        DeliveryZone zone = DeliveryZone.getZoneForZipCode(zipCode);
        BigDecimal result = zone.getDeliveryFee();
        if (sameDayDelivery) {
            result = result.add(zone.getSameDayFee());
        }
        return result;
    }

    @Override
    public String toString() {
        return "ORDER - " + getBouquetType() + " - " + getNumberOfRoses() + " roses - $" + getSubtotal();
    }

}
