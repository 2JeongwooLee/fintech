package com.zerobase.fintech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddProductInfoForm {
    private String organizationCode;
    private String productCode;
    private String productName;
    private Double productMinimumInterest;
    private Double productMaximumInterest;
}
