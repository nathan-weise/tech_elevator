package com.techelevator;

import java.math.BigDecimal;

public class DeliveryZone {  //This would be better accomplished with an enum, but we haven't discussed those yet.

    public static final DeliveryZone ZONE_1 = new DeliveryZone(new BigDecimal("0.00"), new BigDecimal("0.00"));
    public static final DeliveryZone ZONE_2 = new DeliveryZone(new BigDecimal("3.99"), new BigDecimal("5.99"));
    public static final DeliveryZone ZONE_3 = new DeliveryZone(new BigDecimal("6.99"), new BigDecimal("5.99"));
    public static final DeliveryZone ZONE_OTHER = new DeliveryZone(new BigDecimal("19.99"), new BigDecimal("0.00"));

    private static final DeliveryZone[] ALL_ZONES = {ZONE_OTHER, ZONE_1, ZONE_2, ZONE_3};

    private final BigDecimal deliveryFee;
    private final BigDecimal sameDayFee;

    private DeliveryZone(BigDecimal deliveryFee, BigDecimal sameDayFee) { //Delivery zones should only be created within this class.
        this.deliveryFee = deliveryFee;
        this.sameDayFee = sameDayFee;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public BigDecimal getSameDayFee() {
        return sameDayFee;
    }

    public static DeliveryZone getZoneForZipCode(String zipCode) {
        if (zipCode.length() != 5) {
            throw new IllegalArgumentException("Zip code must be 5 digits.");
        }
        int firstDigit = Integer.parseInt(zipCode.substring(0,1));
        if (firstDigit > ALL_ZONES.length - 1) {
            return ZONE_OTHER;
        } else {
            return ALL_ZONES[firstDigit];
        }
    }
}
