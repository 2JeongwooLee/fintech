package com.zerobase.fintech.service;


import com.zerobase.fintech.dto.AddUserInfoForm;
import com.zerobase.fintech.dto.UserInfoDto;
import com.zerobase.fintech.entity.UserInfo;
import com.zerobase.fintech.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInformationService {
    private final UserInfoRepository userInfoRepository;

    public UserInfo addUserInfo(AddUserInfoForm form) {
        return userInfoRepository.save(UserInfo.of(form));
    }

    public UserInfoDto getUserInfo(String userKey) {
        UserInfo userInfo = userInfoRepository.findByUsrKey(userKey);

        return UserInfoDto.builder()
                .userKey(userInfo.getUsrKey())
                .userRegistrationNumber(userInfo.getUsrRegNum())
                .build();
    }

}
