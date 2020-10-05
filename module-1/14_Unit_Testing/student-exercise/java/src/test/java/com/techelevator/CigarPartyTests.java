package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests {

    @Test
    public void getHaveParty_on_weekend_with_70_cigars() {
        //Arrange
        CigarParty sut = new CigarParty();

        //Act
        boolean result = sut.haveParty(70, true);

        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void getHaveParty_not_on_weekend_with_65_cigars() {
        CigarParty sut = new CigarParty();

        boolean result = sut.haveParty(65, false);

        Assert.assertEquals(false, result);
    }

    @Test
    public void getHaveParty_not_on_weekend_with_40_cigars() {
        CigarParty sut = new CigarParty();

        boolean result = sut.haveParty(40, false);

        Assert.assertEquals(true, result);
    }
}
