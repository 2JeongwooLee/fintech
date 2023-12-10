package com.zerobase.fintech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserInfoForm {
    private String userRegistrationNumber;
    private String userName;
    private Integer userIncomeAmount;
}
