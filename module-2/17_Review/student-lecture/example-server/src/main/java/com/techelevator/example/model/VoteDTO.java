package com.techelevator.example.model;

import javax.validation.constraints.NotBlank;

public class VoteDTO {
    @NotBlank
    private String yesOrNo;

    public String getYesOrNo() {
        return yesOrNo;
    }

    public void setYesOrNo(String yesOrNo) {
        this.yesOrNo = yesOrNo;
    }
}
