package com.zerobase.fintech.dto;

import com.zerobase.fintech.entity.UserInfo;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
    private String userKey;
    private String userRegistrationNumber;

    public static UserInfoDto from(UserInfo userInfo) {
        return UserInfoDto.builder()
                .userKey(userInfo.getUsrKey())
                .userRegistrationNumber(userInfo.getUsrRegNum())
                .build();
    }
}
