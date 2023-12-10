package com.zerobase.fintech.entity;

import com.zerobase.fintech.annotation.Encrypt;
import com.zerobase.fintech.dto.AddUserInfoForm;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "USER_INFO")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usrKey;

    @Encrypt
    private String usrRegNum;

    private String usrNm;
    private Integer usrIcmAmt;


    public static UserInfo of(AddUserInfoForm form) {
        return UserInfo.builder()
                .usrIcmAmt(form.getUserIncomeAmount())
                .usrNm(form.getUserName())
                .usrRegNum(form.getUserRegistrationNumber())
                .usrKey(RandomStringUtils.randomAlphanumeric(20))
                .build();
    }
}
